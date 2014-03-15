/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.command.OperatorDriveCommand;
import com.carbonauts.frc2014.util.CarbonRamp;
import com.carbonauts.frc2014.util.CarbonTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for managing all drive actions of the robot.
 * @author Nick
 */
public class Drive extends Subsystem {

    public static final int DIRECTION_FORWARD = 0;    //State constant
    public static final int DIRECTION_REVERSE = 1;   //State constant
    
    private CarbonTalon leftFrontDrive;
    private CarbonTalon leftRearDrive;
    private CarbonTalon rightFrontDrive;
    private CarbonTalon rightRearDrive;
    private RobotDrive robotDrive;
    
    private CarbonRamp arcadeLateralRamp;
    private CarbonRamp arcadeRotationalRamp;
    private CarbonRamp tankLeftRamp;
    private CarbonRamp tankRightRamp;
    
    private OperatorDriveCommand defaultDriveCommand;
    
    private Console console;
    
    private boolean driveEnabled;
    private int driveDirection;
    
    /**
     * Primary constructor for Drive
     */
    public Drive() {
        leftFrontDrive = new CarbonTalon(Constants.DRIVE_LEFT_FRONT);
        leftRearDrive = new CarbonTalon(Constants.DRIVE_LEFT_REAR);
        rightFrontDrive = new CarbonTalon(Constants.DRIVE_RIGHT_FRONT);
        rightRearDrive = new CarbonTalon(Constants.DRIVE_RIGHT_REAR);
        
        robotDrive = new RobotDrive(
            leftFrontDrive,
            leftRearDrive, 
            rightFrontDrive, 
            rightRearDrive);
        
        driveDirection = 1;
        
        arcadeLateralRamp = new CarbonRamp();
        arcadeRotationalRamp = new CarbonRamp();
        tankLeftRamp = new CarbonRamp();
        tankRightRamp = new CarbonRamp();
        
        console = Console.getConsole();
    }
    
    /**
     * Method for driving the robot by specifying lateral motion (forward and
     * backward) and rotation.
     * @param lateralPower The power to drive forward/backward (-1 - 1) at.
     * @param rotationalPower The power to turn with (-1 - 1).
     */
    public void driveArcadeRamp(double lateralPower, double rotationalPower) {
        if(lateralPower > 1.0) {
            lateralPower = 1.0;
        } else if(lateralPower < -1.0) {
            lateralPower = -1.0;
        }
        
        if(rotationalPower > 1.0) {
            rotationalPower = 1.0;
        } else if(rotationalPower < -1.0) {
            rotationalPower = -1.0;
        }
        
        arcadeLateralRamp.setTarget(lateralPower);
        arcadeRotationalRamp.setTarget(rotationalPower);
        
        arcadeLateralRamp.tick();
        arcadeRotationalRamp.tick();
        
        robotDrive.arcadeDrive(getDirection() * arcadeLateralRamp.getOutput(),
                arcadeRotationalRamp.getOutput());
        console.getLCDManager().setDriveMode(Console.LCDManager.DRIVEMODE_ARCADE);
        //TODO set motor speeds in console
    }
    
    public void driveArcade(double lateralPower, double rotationalPower) {
        robotDrive.arcadeDrive(lateralPower, rotationalPower);
    }
    
    /**
     * Method for driving the robot by specifying left and right speeds
     * individually.
     * @param leftPower Speed to drive robot-left at.
     * @param rightPower Speed to drive robot-right at.
     */
    public void driveTank(double leftPower, double rightPower) {
        if(leftPower > 1.0) {
            leftPower = 1.0;
        } else if(leftPower < -1.0) {
            leftPower = -1.0;
        }
        
        if(rightPower > 1.0) {
            rightPower = 1.0;
        } else if(rightPower < -1.0) {
            rightPower = -1.0;
        }
        
        tankLeftRamp.setTarget(leftPower);
        tankRightRamp.setTarget(rightPower);
        
        tankLeftRamp.tick();
        tankRightRamp.tick();
        
        robotDrive.tankDrive(getDirection() * tankLeftRamp.getOutput(),
                getDirection() * tankRightRamp.getOutput());
        console.getLCDManager().setDriveMode(Console.LCDManager.DRIVEMODE_TANK);
        //TODO set motor speeds in console
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
        if(defaultDriveCommand == null) {
            defaultDriveCommand = new OperatorDriveCommand();
        }
        setDefaultCommand(defaultDriveCommand);
    }
    
    public int getDirection() {
        return driveDirection;
    }
}