/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.CarbonUI;

/**
 *
 * @author Nick
 */
public class OperatorPivotSimpleCommand extends CommandBase {

    private CarbonUI ui;
    private boolean finished = false;
    
    public OperatorPivotSimpleCommand() {
        requires(pivot);
        requires(intake);
        setInterruptible(true);
        ui = CarbonUI.getUI();
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        
        /**
         * If both the Pivot Forward and Pivot Reverse buttons are pressed,
         * stop the pivot.
         */
        if(ui.getPivotForwardButtonState() && ui.getPivotReverseButtonState()) {
            pivot.stopPivot();
            
        /**
         * If the Pivot Forward button is pressed, run the pivot forward.
         */
        } else if(ui.getPivotForwardButtonState()) {
            pivot.setPivotForward();
            
        /**
         * If the Pivot Reverse button is pressed, run the pivot backward.
         */
        } else if(ui.getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            
        /**
         * If neither the Pivot Forward or Pivot Reverse buttons are pressed,
         * stop the pivot
         */
        } else {
            pivot.stopPivot();
        }
        
        /**
         * If both the Intake Forward and Reverse buttons are pressed, stop the
         * intake.
         */
        if(ui.getIntakeForwardButtonState() && ui.getIntakeReverseButtonState()) {
            intake.stopIntake();
            
        /**
         * If the Intake Forward button is pressed, run the Intake forward.
         */
        } else if(ui.getIntakeForwardButtonState()) {
            intake.setIntakeForward();
            
        /**
         * If the Intake Reverse button is pressed, run the Intake backward.
         */
        } else if(ui.getIntakeReverseButtonState()) {
            intake.setIntakeReverse();
        }
        
        System.out.println("Pivot position: " + pivot.getPosition());
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}