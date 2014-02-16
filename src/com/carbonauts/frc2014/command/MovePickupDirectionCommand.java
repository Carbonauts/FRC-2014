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
public class MovePickupDirectionCommand extends CommandBase {
    
    private boolean mFinished = false;
    private int mDirection;
    
    public MovePickupDirectionCommand(int direction) {
        requires(mPickupPivot);
        setInterruptible(true);
        
        mDirection = direction;
        
        //If we're already at the position we want to go to, do nothing
        if(mPickupPivot.isAtPosition(mDirection)) {  
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
        
    }

    protected boolean isFinished() {
        return mFinished;
    }

    protected void end() {
        mPickupPivot.moveDirection(Constants.PICKUP_DIRECTION_STOPPED);
    }

    protected void interrupted() {
        
    }
}
