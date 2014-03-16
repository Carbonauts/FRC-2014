/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Single-purpose command to run the pivot forward
 * @author Nick
 */
public class PivotMoveForwardCommand extends CommandBase {

    private boolean finished = false;
    
    public PivotMoveForwardCommand() {
        requires(pivot);
        setInterruptible(true);
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        if(!pivot.getForwardLimitState()) {
            pivot.setPivotForward();
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
