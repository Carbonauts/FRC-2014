/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.command.OperatorDriveCommand;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for managing all drive actions of the robot.
 * @author Nick
 */
public class Drive extends Subsystem {

    private Talon mLeftFrontDrive = new Talon(Constants.DRIVE_LEFT_FRONT);
    private Talon mLeftRearDrive = new Talon(Constants.DRIVE_LEFT_REAR);
    private Talon mRightFrontDrive = new Talon(Constants.DRIVE_RIGHT_FRONT);
    private Talon mRightRearDrive = new Talon(Constants.DRIVE_RIGHT_REAR);
    
    private RobotDrive mRobotDrive = new RobotDrive(
            mLeftFrontDrive,
            mLeftRearDrive, 
            mRightFrontDrive, 
            mRightRearDrive);
    
    private boolean isDriveMode = true;
    private int mDriveDirection = 1;
    
    /**
     * Method for driving the robot by specifying lateral motion (forward and
     * backward) and rotation.
     * @param lateralPower The power to drive forward/backward (-1 - 1) at.
     * @param rotationalPower The power to turn with (-1 - 1).
     */
    public void driveArcade(double lateralPower, double rotationalPower) {
        if(isDriveMode) {
            mRobotDrive.arcadeDrive(getDirection() * lateralPower, rotationalPower);
        } else {
            mRobotDrive.arcadeDrive(0,0);
        }
    }
    
    /**
     * Method for driving the robot by specifying left and right speeds
     * individually.
     * @param leftPower Speed to drive robot-left at.
     * @param rightPower Speed to drive robot-right at.
     */
    public void driveTank(double leftPower, double rightPower) {
        if(isDriveMode) {
            mRobotDrive.tankDrive(getDirection() * leftPower, getDirection() * rightPower);
        } else {
            mRobotDrive.tankDrive(0,0);
        }
    }
    
    public void setDriveDirection(int direction) {
        mDriveDirection = direction;
    }
    
    public void toggleDirection() {
        mDriveDirection = -mDriveDirection;
    }
    
    /**
     * Set the state which enables or disables the drive system.  Upon receiving
     * false, all functions which require the drive system to operate will be
     * frozen until re-enabled.
     * @param enabled
     */
    public void setDriveEnabled(boolean enabled) {
        isDriveMode = enabled;
    }
    
    public void toggleEnabled() {
        isDriveMode = !isDriveMode;
    }
    
    public boolean getEnabled() {
        return isDriveMode;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new OperatorDriveCommand());
    }
    
    public int getDirection() {
        return mDriveDirection;
    }
}