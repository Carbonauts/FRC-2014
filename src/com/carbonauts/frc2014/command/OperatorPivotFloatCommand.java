/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

/**
 * Moves the PivotPickup subsystem in a direction given by a parameter
 * @author Nick
 */
public class OperatorPivotFloatCommand extends CommandBase implements PIDOutput {
    
    private Console console;
    private PIDController controller;
    private boolean finished = false;
    private boolean pidEnabled = false;
    
    public OperatorPivotFloatCommand() {
        requires(pivot);
        requires(intake);
        setInterruptible(true);
        console = Console.getConsole();
    }
    
    protected void initialize() {
        controller = new PIDController(Constants.PIVOT_PID_P,
                                       Constants.PIVOT_PID_I, 
                                       Constants.PIVOT_PID_D, 
                                       pivot, 
                                       this);
        controller.setInputRange(Constants.PIVOT_PID_MIN, Constants.PIVOT_PID_MAX);
        controller.enable();
    }

    protected void execute() {
        
        if(console.getUI().getPivotForwardButtonState() && console.getUI().getPivotReverseButtonState()) {
            pivot.stopPivot();
            pidEnabled = false;
            
        } else if(console.getUI().getPivotForwardButtonState()) {
            pivot.setPivotForward();
            pidEnabled = false;
            
        } else if(console.getUI().getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            pidEnabled = false;
            
        } else if(!console.getUI().getPivotForwardButtonState() && !console.getUI().getPivotReverseButtonState()) {
            
            if(!console.getUI().getPivotPIDButtonState()) {
                pidEnabled = true;
                controller.setSetpoint(0.0);
            } else {
                pidEnabled = false;
                pivot.stopPivot();
            }
        }
        
        if(pivot.getPosition() > 0.0 + Constants.PIVOT_POSITION_TOLERANCE) {
            intake.setIntakeForward();
            
        } else if(pivot.getPosition() < 0.0 - Constants.PIVOT_POSITION_TOLERANCE) {
            intake.setIntakeReverse();
            
        } else {
            intake.stopIntake();
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        pivot.stopPivot();
    }

    protected void interrupted() {
        
    }

    public void pidWrite(double output) {
        if(pidEnabled) {
            pivot.setPivotSpeed(output);
        }
    }
}