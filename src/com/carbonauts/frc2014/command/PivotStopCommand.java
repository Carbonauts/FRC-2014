/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Single-purpose command to stop pivot motor
 * @author Nick
 */
public class PivotStopCommand extends CommandBase {

    private boolean finished = false;
    
    public PivotStopCommand() {
        requires(pivot);
        setInterruptible(true);
    }
    
    protected void initialize() {
        pivot.stopPivot();
        finished = true;
    }

    protected void execute() {
        
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
