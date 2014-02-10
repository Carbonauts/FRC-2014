/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 *
 * @author Nick
 */
public class MovePickupToPositionCommand extends CommandBase {
    
    private boolean isFinished = false;
    
    public MovePickupToPositionCommand(int position) {
        if(mPickupPivot.isAtPosition(position)) {  //If we're at the position we want to go to do nothing
            isFinished = true;  //Notify that command is done
        }
    }
    
    protected void initialize() {
        requires(mPickupPivot);
    }

    protected void execute() {
        /*
         * Code that moves arm to position.  Add a condition which will trigger
         * a return of "true" to the isFinished() method when this completes.
         */
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
