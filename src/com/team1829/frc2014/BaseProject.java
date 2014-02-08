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
    
    /*
     * Declare constants of the PWM ports for specified motors
     */
    public static final int DRIVE_LEFT_FRONT  = 1;
    public static final int DRIVE_LEFT_REAR   = 2;
    public static final int DRIVE_RIGHT_FRONT = 3;
    public static final int DRIVE_RIGHT_REAR  = 4;
    
    /*
     * Declare constants of the USB ports for specified joysticks
     */
    public static final int JOYSTICK = 1;
    
    /*
     * Declare keys for SmartDashboard Data
     */
    public static final String SD_LOG = "Log";
    public static final String SD_JOYSTICK_X = "JoyX";
    public static final String SD_JOYSTICK_Y = "JoyY";
    
    /*
     * Declare channels for Driver Station Data
     * 
     * For use with "getDigitalIn(int channel)", "getAnalogIn(int channel)"
     * and "setDigitalOut(int channel)"
     */
    public static final int DS_DIGITAL_1 = 1;
    public static final int DS_DIGITAL_2 = 2;
    public static final int DS_DIGITAL_3 = 3;
    public static final int DS_DIGITAL_4 = 4;
    public static final int DS_DIGITAL_5 = 5;
    public static final int DS_DIGITAL_6 = 6;
    public static final int DS_DIGITAL_7 = 7;
    public static final int DS_DIGITAL_8 = 8;
    public static final int DS_ANALOG_1 = 1;
    public static final int DS_ANALOG_2 = 2;
    public static final int DS_ANALOG_3 = 3;
    public static final int DS_ANALOG_4 = 4;
    public static final int DS_ANALOG_5 = 5;
    public static final int DS_ANALOG_6 = 6;
    public static final int DS_ANALOG_7 = 7;
    public static final int DS_ANALOG_8 = 8;
    
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
        SmartDashboard.putString(SD_LOG, "Entered 'robotInit()'");
        
        mRobotDrive = new RobotDrive(DRIVE_LEFT_FRONT, DRIVE_LEFT_REAR, 
                DRIVE_RIGHT_FRONT, DRIVE_RIGHT_REAR);
        SmartDashboard.putString(SD_LOG, "Initialized RobotDrive");
        
        mJoystick = new Joystick(JOYSTICK);
        SmartDashboard.putString(SD_LOG, "Initialized Joystick");
        
        mDriverStation = DriverStation.getInstance();
        SmartDashboard.putString(SD_LOG, "Initialized Driver Station");
        
        SmartDashboard.putString(SD_LOG, "End 'robotInit()'");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        SmartDashboard.putString(SD_LOG, "Entered 'autonomousPeriodic()'");
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        SmartDashboard.putString(SD_LOG, "Entered 'teleopPeriodic()'");
        
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