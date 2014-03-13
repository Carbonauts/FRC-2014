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

    private Console console;
    
    public OperatorDriveCommand() {
        //requires(drive);
        setInterruptible(true);
        console = Console.getConsole();
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        //drive.driveArcade(console.getJoystick().getY(), console.getJoystick().getZ());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
