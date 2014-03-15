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
public class OperatorPivotCommand extends CommandBase {
    
    private Console console;
    private boolean finished = false;
    
    public OperatorPivotCommand() {
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
            pivot.resetDistance();
            
        }
        
        if(console.getUI().getArmForwardButtonState() && console.getUI().getArmReverseButtonState()) {
            pivot.stopPivot();
            
        } else if(console.getUI().getArmForwardButtonState()) {
            pivot.setPivotForward();
            intake.setPivotForward();
                
        } else if(console.getUI().getArmReverseButtonState()) {
            pivot.setPivotReverse();
            intake.setPivotReverse();
            
        } else if(!console.getUI().getArmForwardButtonState() && !console.getUI().getArmReverseButtonState()) {
            
            if(pivot.getDistance() > (Constants.PIVOT_POSITION_CENTER + Constants.PIVOT_POSITION_TOLERANCE)) {
                pivot.setPivotReverse();
                
            } else if(pivot.getDistance() < (Constants.PIVOT_POSITION_CENTER - Constants.PIVOT_POSITION_TOLERANCE)) {
                pivot.setPivotForward();
                
            } else {
                pivot.stopPivot();
                intake.stopIntake();
            }
        }
        
        System.out.println("Pivot Encoder Distance: " + pivot.getDistance() + " Direction: " + pivot.getDirection());
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        pivot.stopPivot();
    }

    protected void interrupted() {
        pivot.stopPivot();
    }
}