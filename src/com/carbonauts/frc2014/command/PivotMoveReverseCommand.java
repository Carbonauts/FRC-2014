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
        if(!pivot.getReverseLimitState()) {
            pivot.setPivotReverse();
        } else {
            pivot.stopPivot();
            finished = true;
        }
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
