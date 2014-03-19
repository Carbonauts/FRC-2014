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
        System.out.println("Init IntakeSpinForwardCommand");
        intake.setIntakeForward();
        finished = false;
    }

    protected void execute() {
        intake.setIntakeForward();
        System.out.println("In IntakeSpinForwardCommand.execute()");
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
