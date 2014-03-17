/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;

/**
 *
 * @author Nick
 */
public class OperatorPivotSimpleCommand extends CommandBase {

    private Console console;
    private boolean finished = false;
    
    public OperatorPivotSimpleCommand() {
        requires(pivot);
        requires(intake);
        setInterruptible(true);
        console = Console.getConsole();
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        
        if(console.getUI().getPivotForwardButtonState() && console.getUI().getPivotReverseButtonState()) {
            pivot.stopPivot();
            
        } else if(console.getUI().getPivotForwardButtonState()) {
            pivot.setPivotForward();
            
        } else if(console.getUI().getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            
        } else {
            pivot.stopPivot();
        }
        
        if(console.getUI().getIntakeForwardButtonState() && console.getUI().getIntakeReverseButtonState()) {
            intake.stopIntake();
            
        } else if(console.getUI().getIntakeForwardButtonState()) {
            intake.setIntakeForward();
            
        } else if(console.getUI().getIntakeReverseButtonState()) {
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