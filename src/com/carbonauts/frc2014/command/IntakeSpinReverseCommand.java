/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

/**
 * Single-purpose command to spin the intake rollers in reverse
 * @author Nick
 */
public class IntakeSpinReverseCommand extends CommandBase {

    private boolean finished = false;
    
    public IntakeSpinReverseCommand() {
        requires(intake);
        setInterruptible(true);
    }
    
    protected void initialize() {
        intake.setIntakeReverse();
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
