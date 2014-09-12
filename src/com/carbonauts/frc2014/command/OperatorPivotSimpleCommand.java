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
        
        if(ui.getPivotForwardButtonState() && ui.getPivotReverseButtonState()) {
            pivot.stopPivot();
            
        } else if(ui.getPivotForwardButtonState()) {
            pivot.setPivotForward();
            
        } else if(ui.getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            
        } else {
            pivot.stopPivot();
        }
        
        if(ui.getIntakeForwardButtonState() && ui.getIntakeReverseButtonState()) {
            intake.stopIntake();
            
        } else if(ui.getIntakeForwardButtonState()) {
            intake.setIntakeForward();
            
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