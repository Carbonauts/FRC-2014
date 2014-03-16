/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Single-purpose command to make the intake rollers spin forward
 * @author Nick
 */
public class IntakeSpinForwardCommand extends CommandBase {

    private boolean finished = false;
    
    public IntakeSpinForwardCommand() {
        requires(intake);
        setInterruptible(true);
    }
    
    protected void initialize() {
        intake.setIntakeForward();
        finished = false;
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
