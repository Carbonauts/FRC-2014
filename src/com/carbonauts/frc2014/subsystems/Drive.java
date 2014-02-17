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

    private Talon leftFrontDrive;
    private Talon leftRearDrive;
    private Talon rightFrontDrive;
    private Talon rightRearDrive;
    private RobotDrive robotDrive;
    
    private boolean driveEnabled;
    private int driveDirection;
    
    /**
     * Primary constructor for Drive
     */
    public Drive() {
        leftFrontDrive = new Talon(Constants.DRIVE_LEFT_FRONT);
        leftRearDrive = new Talon(Constants.DRIVE_LEFT_REAR);
        rightFrontDrive = new Talon(Constants.DRIVE_RIGHT_FRONT);
        rightRearDrive = new Talon(Constants.DRIVE_RIGHT_REAR);
        
        robotDrive = new RobotDrive(
            leftFrontDrive,
            leftRearDrive, 
            rightFrontDrive, 
            rightRearDrive);
        
        driveEnabled = true;
        driveDirection = 1;
    }
    
    /**
     * Method for driving the robot by specifying lateral motion (forward and
     * backward) and rotation.
     * @param lateralPower The power to drive forward/backward (-1 - 1) at.
     * @param rotationalPower The power to turn with (-1 - 1).
     */
    public void driveArcade(double lateralPower, double rotationalPower) {
        if(driveEnabled) {
            robotDrive.arcadeDrive(getDirection() * lateralPower, rotationalPower);
        } else {
            robotDrive.arcadeDrive(0,0);
        }
    }
    
    /**
     * Method for driving the robot by specifying left and right speeds
     * individually.
     * @param leftPower Speed to drive robot-left at.
     * @param rightPower Speed to drive robot-right at.
     */
    public void driveTank(double leftPower, double rightPower) {
        if(driveEnabled) {
            robotDrive.tankDrive(getDirection() * leftPower, getDirection() * rightPower);
        } else {
            robotDrive.tankDrive(0,0);
        }
    }
    
    public void setDriveDirection(int direction) {
        driveDirection = direction;
    }
    
    public void toggleDirection() {
        driveDirection = -driveDirection;
    }
    
    /**
     * Set the state which enables or disables the drive system.  Upon receiving
     * false, all functions which require the drive system to operate will be
     * frozen until re-enabled.
     * @param enabled
     */
    public void setDriveEnabled(boolean enabled) {
        driveEnabled = enabled;
    }
    
    public void toggleEnabled() {
        driveEnabled = !driveEnabled;
    }
    
    public boolean isEnabled() {
        return driveEnabled;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new OperatorDriveCommand());
    }
    
    public int getDirection() {
        return driveDirection;
    }
}