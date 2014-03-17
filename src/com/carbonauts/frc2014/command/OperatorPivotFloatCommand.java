/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;

/**
 * Moves the PivotPickup subsystem in a direction given by a parameter
 * @author Nick
 */
public class OperatorPivotFloatCommand extends CommandBase {
    
    private Console console;
    private boolean finished = false;
    
    public OperatorPivotFloatCommand() {
        requires(pivot);
        requires(intake);
        setInterruptible(true);
        console = Console.getConsole();
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        
        //Zero encoder when limits are hit
        if(pivot.getForwardLimitState()) {
            
            
        } else if(pivot.getReverseLimitState()) {
            //pivot.resetDistance();
            
        }
        
        if(console.getUI().getPivotForwardButtonState() && console.getUI().getPivotReverseButtonState()) {
            pivot.stopPivot();
            
        } else if(console.getUI().getPivotForwardButtonState()) {
            pivot.setPivotForward();
            intake.setIntakeForward();
                
        } else if(console.getUI().getPivotReverseButtonState()) {
            pivot.setPivotReverse();
            intake.setIntakeReverse();
            
        } else if(!console.getUI().getPivotForwardButtonState() && !console.getUI().getPivotReverseButtonState()) {
            
            if(pivot.getPosition() > (pivot.getRestingPosition() + Constants.PIVOT_POSITION_TOLERANCE)) {
                pivot.setPivotReverse();
                
            } else if(pivot.getPosition() < (pivot.getRestingPosition() - Constants.PIVOT_POSITION_TOLERANCE)) {
                pivot.setPivotForward();
                
            } else {
                pivot.stopPivot();
                intake.stopIntake();
            }
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
}