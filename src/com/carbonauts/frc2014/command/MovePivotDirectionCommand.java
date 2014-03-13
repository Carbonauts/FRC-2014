/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Moves the PivotPickup subsystem in a direction given by a parameter
 * @author Nick
 */
public class MovePivotDirectionCommand extends CommandBase {
    
    private boolean finished = false;
    
    public MovePivotDirectionCommand(boolean direction) {
        requires(pivot);
        setInterruptible(true);
    }
    
    protected void initialize() {
        
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
        pivot.stopPivot();
    }
}