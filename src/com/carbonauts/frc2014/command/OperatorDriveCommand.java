/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;

/**
 *
 * @author Nick
 */
public class OperatorDriveCommand extends CommandBase {

    public OperatorDriveCommand() {
        requires(drive);
        setInterruptible(true);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        drive.driveArcade(Console.getJoystick().getY(), Console.getJoystick().getX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
