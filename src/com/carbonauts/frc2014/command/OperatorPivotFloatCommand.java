/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.CarbonUI;
import com.carbonauts.frc2014.Constants;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

/**
 * Moves the PivotPickup subsystem in a direction given by a parameter
 * @author Nick
 */
public class OperatorPivotFloatCommand extends CommandBase implements PIDOutput {
    
    private final CarbonUI ui;
    private PIDController controller;
    private boolean finished = false;
    private boolean pidEnabled = false;
    
    public OperatorPivotFloatCommand() {
        requires(pivot);
        requires(intake);
        setInterruptible(true);
        ui = CarbonUI.getUI();
        
        System.out.println("OperatorPivotFloatCommand!");
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
        
        /*
         * If both forward and reverse pivot buttons are pressed
         */
        if(ui.getPivotForwardButtonState() && ui.getPivotReverseButtonState()) {
            pivot.stopPivot();
            pidEnabled = false;
            
        /*
         * If the forward pivot button is pressed
         */
        } else if(ui.getPivotForwardButtonState()) {
            pivot.setPivotForward();
            pidEnabled = false;
           
        /*
         * If the reverse pivot button is pressed   
         */
        } else if(ui.getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            pidEnabled = false;
            
        /*
         * If neither the forward or reverse pivot buttons are pressed    
         */
        } else if(!ui.getPivotForwardButtonState() && !ui.getPivotReverseButtonState()) {
            
            /*
             * Return the pivot to the zero position
             */
            if(!ui.getZeroPivotEncoderButtonState()) {
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