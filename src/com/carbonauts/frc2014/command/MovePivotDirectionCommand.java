/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.subsystems.Pivot;

/**
 * Moves the PivotPickup subsystem in a direction given by a parameter
 * @author Nick
 */
public class MovePivotDirectionCommand extends CommandBase {
    
    private boolean finished = false;
    private int direction;
    private int endPosition;
    
    public MovePivotDirectionCommand(int direction) {
        requires(pickupPivot);
        setInterruptible(true);
        
        this.direction = direction;
        System.out.println("New MovePickupDirectionCommand: " + direction);
        
        if(this.direction == Pivot.DIRECTION_FORWARD) {
            endPosition = Pivot.POSITION_FORWARD;
        } else if (this.direction == Pivot.DIRECTION_REVERSE) {
            endPosition = Pivot.POSITION_REVERSE;
        }
        
        //If we're already at the position we want to go to, do nothing
        if(pickupPivot.isAtPosition(endPosition)) {  
            finished = true;  //Notify that command is done
        }
    }
    
    protected void initialize() {
        System.out.println("Button Press");
    }

    protected void execute() {
        
        System.out.println("FL:" + CommandBase.pickupPivot.getForwardLimitState() +
                " MD:" + CommandBase.pickupPivot.getRestingLimitState() +
                " RE:" + CommandBase.pickupPivot.getReverseLimitState());
        
        System.out.println("IsAtPosition:" + pickupPivot.isAtPosition(endPosition));
        if(pickupPivot.isAtPosition(endPosition)) {
            pickupPivot.stopPivot();
            finished = true;
        } else {
            pickupPivot.moveDirection(direction);
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        pickupPivot.stopPivot();
    }

    protected void interrupted() {
        pickupPivot.stopPivot();
    }
}