/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;

/**
 * Moves the PivotPickup subsystem in a direction given by a parameter
 * @author Nick
 */
public class OperatorPivotCommand extends CommandBase {
    
    private Console console;
    private boolean finished = false;
    
    public OperatorPivotCommand() {
        requires(pivot);
        setInterruptible(true);
        console = Console.getConsole();
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        
        //Zero encoder when limits are hit
        if(pivot.getForwardLimitState()) {
            
        } else if(pivot.getReverseLimitState()) {
            
        }
        
        if(console.getJoystick().getArmForwardButtonState() &&
                console.getJoystick().getArmReverseButtonState()) {
            
            pivot.stopPivot();
            
        } else if(console.getJoystick().getArmForwardButtonState()) {
            
            if(!pivot.getForwardLimitState()) {
                pivot.setPivotForward();
            } else {
                pivot.hardStopPivot();
            }
            
        } else if(console.getJoystick().getArmReverseButtonState()) {
            
            if(!pivot.getReverseLimitState()) {
                pivot.setPivotReverse();
            } else {
                pivot.hardStopPivot();
            }
        } else if(!console.getJoystick().getArmForwardButtonState() &&
                !console.getJoystick().getArmReverseButtonState()) {
            
            
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