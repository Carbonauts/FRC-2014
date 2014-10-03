/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Single-purpose command to make the pivot move in reverse
 * @author Nick
 */
public class PivotMoveReverseCommand extends CommandBase {

    private boolean finished = false;
    
    public PivotMoveReverseCommand() {
        requires(pivot);
        setInterruptible(true);
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        if(pivot.isAtReverseLimit()) {
            pivot.hardStopPivot();
            finished = true;
        } else {
            pivot.setPivotReverse();
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
