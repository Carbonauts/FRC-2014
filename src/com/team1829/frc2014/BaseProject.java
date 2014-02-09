/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team1829.frc2014;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BaseProject extends IterativeRobot {
    
    /**
     * RobotDrive object handles the four drive motors in the manner required 
     * for an arcade, tank, or omni-directional drive
     */
    private RobotDrive mRobotDrive;
    
    /**
     * Joystick object handles the fetching of all user input from a single
     * physical device.
     */
    private Joystick mJoystick;
    
    /**
     * Driver Station object to transfer data to and from the DS
     */
    private DriverStation mDriverStation;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        SmartDashboard.putString(Constants.SD_LOG, "Entered 'robotInit()'");
        
        mRobotDrive = new RobotDrive(Constants.DRIVE_LEFT_FRONT, Constants.DRIVE_LEFT_REAR, 
                Constants.DRIVE_RIGHT_FRONT, Constants.DRIVE_RIGHT_REAR);
        SmartDashboard.putString(Constants.SD_LOG, "Initialized RobotDrive");
        
        mJoystick = new Joystick(Constants.JOYSTICK);
        SmartDashboard.putString(Constants.SD_LOG, "Initialized Joystick");
        
        mDriverStation = DriverStation.getInstance();
        SmartDashboard.putString(Constants.SD_LOG, "Initialized Driver Station");
        
        SmartDashboard.putString(Constants.SD_LOG, "End 'robotInit()'");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        SmartDashboard.putString(Constants.SD_LOG, "Entered 'autonomousPeriodic()'");
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        SmartDashboard.putString(Constants.SD_LOG, "Entered 'teleopPeriodic()'");
        
        while(isEnabled() && isOperatorControl()) {
            mRobotDrive.arcadeDrive(mJoystick.getY(), mJoystick.getX());
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
}