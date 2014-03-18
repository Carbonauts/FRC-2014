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
    private double pidTarget = 0;
    
    public OperatorPivotFloatCommand() {
        requires(pivot);
        requires(intake);
        setInterruptible(true);
        console = Console.getConsole();
    }
    
    protected void initialize() {
        controller = new PIDController(0.01, 0, 0, pivot, this);
        controller.setInputRange(Constants.PIVOT_PID_MIN, Constants.PIVOT_PID_MAX);
        controller.enable();
    }

    protected void execute() {
        
        if(console.getUI().getPivotForwardButtonState() && console.getUI().getPivotReverseButtonState()) {
            pivot.stopPivot();
            pidEnabled = false;
            pivot.getMotor().setRampEnabled(true);
            
        } else if(console.getUI().getPivotForwardButtonState()) {
            pivot.setPivotForward();
            pidEnabled = false;
            pivot.getMotor().setRampEnabled(true);
            
        } else if(console.getUI().getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            pidEnabled = false;
            pivot.getMotor().setRampEnabled(true);
            
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
        
        System.out.println("Encoder Distance: " + pivot.getPosition() + " Direction: " + pivot.getDirection());
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
            System.out.println("PID Write: " + output);
        }
    }
}