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
public class MovePickupTeleopCommand extends CommandBase {
    
    private boolean mFinished = false;
    private int mDirection;
    
    public MovePickupTeleopCommand() {
        requires(mPickupPivot);
        setInterruptible(true);
        
        if(mPickupPivot.isAtPosition(mDirection)) {  //If we're at the position we want to go to, do nothing
            mFinished = true;  //Notify that command is done
        }
        /*****************************************************
         * Comment by Greg:
         * all this needs is this line (assuming we add the getPosition method to pickupPivot)
         * IMPORTANT: The following line must be BEFORE the isFinished check otherwise the motor
         * may not turn off when the goal is reached
         * mPickupPivot.mPivotMotor.set(Java.signum(position - mPickupPivot.getPosition());
         */
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        /*
         * Code that moves arm to position.  Add a condition which will trigger
         * a return of "true" to the isFinished() method when this completes.
         */
        if(mPickupPivot.isAtPosition(mDirection)) {
            mFinished = true;
        } else {
            
        }
    }

    protected boolean isFinished() {
        return mFinished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
