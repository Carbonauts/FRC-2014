/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.util.CarbonTimer;

/**
 * Single-purpose command which drives the robot forward for a time
 * @author Nick
 */
public class DriveForwardCommand extends CommandBase {

    private CarbonTimer timer;
    private boolean finished = false;
    private long waitTime = 0;
    
    public DriveForwardCommand(long time) {
        requires(drive);
        setInterruptible(true);
        waitTime = time;
        timer = new CarbonTimer(waitTime);
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        if(timer.isDone()) {
            drive.stopDrive();
            finished = true;
        } else {
            drive.driveTank(Constants.AUTO_DRIVE_POWER, Constants.AUTO_DRIVE_POWER);
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        drive.stopDrive();
    }

    protected void interrupted() {
        
    }
}