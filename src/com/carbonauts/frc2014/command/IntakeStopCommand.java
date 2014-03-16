/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Single-purpose command to stop the intake rollers
 * @author Nick
 */
public class IntakeStopCommand extends CommandBase {

    private boolean finished = false;
    
    public IntakeStopCommand() {
        requires(intake);
        setInterruptible(true);
    }
    
    protected void initialize() {
        intake.stopIntake();
        finished = true;
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
