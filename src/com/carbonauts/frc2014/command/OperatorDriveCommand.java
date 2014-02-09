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
        requires(mDrive);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        mDrive.driveArcade(Console.mJoystick.getY(), Console.mJoystick.getX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
