/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.command.OperatorDrive;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Nick
 */
public class Drive extends Subsystem {

    private Talon mLeftFrontDrive = new Talon(Constants.DRIVE_LEFT_FRONT);
    private Talon mLeftRearDrive = new Talon(Constants.DRIVE_LEFT_REAR);
    private Talon mRightFrontDrive = new Talon(Constants.DRIVE_RIGHT_FRONT);
    private Talon mRightRearDrive = new Talon(Constants.DRIVE_RIGHT_REAR);
    
    private RobotDrive mRobotDrive = new RobotDrive(mLeftFrontDrive,
            mLeftRearDrive, mRightFrontDrive, mRightRearDrive);
    
    private boolean isDriveMode = true;
    private boolean mDriveDirection = true;
    
    public void driveArcade(double lateralPower, double rotationalPower) {
        if(isDriveMode) {
            mRobotDrive.arcadeDrive(getDirection() * lateralPower, rotationalPower);
        }
    }
    
    public void driveTank(double leftPower, double rightPower) {
        if(isDriveMode) {
            mRobotDrive.tankDrive(getDirection() * leftPower, getDirection() * rightPower);
        }
    }
    
    public void setDriveDirection(boolean direction) {
        mDriveDirection = direction;
    }
    
    public void toggleDirection() {
        mDriveDirection = !mDriveDirection;
    }
    
    public void setDriveEnabled(boolean enable) {
        isDriveMode = enable;
    }
    
    public void toggleEnabled() {
        isDriveMode = !isDriveMode;
    }
    
    public boolean getEnabled() {
        return isDriveMode;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new OperatorDrive());
    }
    
    private int getDirection() {
        return mDriveDirection ? 1 : -1;
    }
}