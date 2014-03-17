/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.command.OperatorDriveCommand;
import com.carbonauts.frc2014.util.CarbonRamp;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for managing all drive actions of the robot.
 * @author Nick
 */
public class Drive extends Subsystem {

    public static final int DIRECTION_FORWARD = 0;    //State constant
    public static final int DIRECTION_REVERSE = 1;   //State constant
    
    private Talon leftFrontDrive;
    private Talon leftRearDrive;
    private Talon rightFrontDrive;
    private Talon rightRearDrive;
    private RobotDrive robotDrive;
    
    private CarbonRamp arcadeYRamp;
    private CarbonRamp arcadeXRamp;
    private CarbonRamp tankLeftRamp;
    private CarbonRamp tankRightRamp;
    
    private OperatorDriveCommand defaultDriveCommand;
    
    private Console console;
    
    private double driveDirection;
    
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
        
        driveDirection = 1.0;
        
        arcadeYRamp = new CarbonRamp();
        arcadeXRamp = new CarbonRamp();
        tankLeftRamp = new CarbonRamp();
        tankRightRamp = new CarbonRamp();
        
        console = Console.getConsole();
    }
    
    /**
     * Method for driving the robot by specifying lateral motion (forward and
     * backward) and rotation.
     * @param yPower The power to drive forward/backward (-1 - 1) at.
     * @param xPower The power to turn with (-1 - 1).
     */
    public void driveArcade(double yPower, double xPower) {
        if(yPower > 1.0) {
            yPower = 1.0;
        } else if(yPower < -1.0) {
            yPower = -1.0;
        }
        
        if(xPower > 1.0) {
            xPower = 1.0;
        } else if(xPower < -1.0) {
            xPower = -1.0;
        }
        
        arcadeYRamp.setTarget(yPower);
        arcadeXRamp.setTarget(xPower);
        
        arcadeYRamp.tick();
        arcadeXRamp.tick();
        
        robotDrive.arcadeDrive(getDirection() * arcadeYRamp.getOutput(),
                arcadeXRamp.getOutput());
        //TODO set motor speeds in console
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
        //TODO set motor speeds in console
    }
    
    public void setDriveDirection(int direction) {
        driveDirection = direction;
    }
    
    public void toggleDirection() {
        driveDirection = -driveDirection;
    }
    
    protected void initDefaultCommand() {
        /*
         * Default Drive command cannot be declared in the constructor because
         * the command requires the drive, and in the constructor the Drive
         * object has not been created.  This is the earliest it can be defined.
         */
        if(defaultDriveCommand == null) {
            defaultDriveCommand = new OperatorDriveCommand();
        }
        setDefaultCommand(defaultDriveCommand);
    }
    
    public double getDirection() {
        return driveDirection;
    }
    
    public void reset() {
        arcadeYRamp.reset();
        arcadeXRamp.reset();
        tankLeftRamp.reset();
        tankRightRamp.reset();
    }
    
    public void stopDrive() {
        arcadeYRamp.setTarget(0.0);
        arcadeXRamp.setTarget(0.0);
        tankLeftRamp.setTarget(0.0);
        tankRightRamp.setTarget(0.0);
    }
    
    public void hardStopDrive() {
        reset();
        leftFrontDrive.set(0.0);
        rightFrontDrive.set(0.0);
        leftRearDrive.set(0.0);
        rightRearDrive.set(0.0);
        robotDrive.arcadeDrive(0.0, 0.0);
        robotDrive.tankDrive(0.0, 0.0);
    }
}