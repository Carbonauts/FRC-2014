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
        pivot.setPivotForward();
        pivot.getMotor().setRampEnabled(true);
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}