/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.util.CarbonDigitalInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to control the pickup arm and it's rollers on the robot.  Includes
 * pivoting the arm and running the rollers to suck in the ball.  Needs position
 * management, for which limit switches are currently being used.  It may be
 * necessary (or just nice) to employ encoders for this subsystem
 * @author Nick
 */
public class PickupPivot extends Subsystem {

    //Declare Talon
    private Talon mPivotMotor;
    
    /*
     * Declare Limit switch objects
     */
    private DigitalInput mLimitForward;
    private DigitalInput mLimitResting;
    private DigitalInput mLimitReverse;
    
    /*
     * State-keeping variables (may replace with methods)
     */
    private int mPosition;
    private int mRollerDirection = 0;
    
    /**
     * Construct the subsystem; define hardware
     */
    public PickupPivot() {
        
        //Define Talon
        mPivotMotor = new Talon(Constants.PICKUP_PIVOT);
        
        /*
         * Using custom DigitalInput class (CarbonDigitalInput) in order to control
         * the inversion of the get() statement.  Each inversion is declared at
         * construction and is controlled from constants
         */
        mLimitForward = new CarbonDigitalInput(
                Constants.PICKUP_LIMIT_FORWARD,
                Constants.DIO1_INVERTED);
        mLimitResting = new CarbonDigitalInput(
                Constants.PICKUP_LIMIT_RESTING,
                Constants.DIO2_INVERTED);
        mLimitReverse = new CarbonDigitalInput(
                Constants.PICKUP_LIMIT_REVERSE,
                Constants.DIO3_INVERTED);
    }
    
    /**
     * Determines whether the pickup arm is currently positioned at one of the
     * preset positions with a limit switch
     * @return True if the arm is at preset, false otherwise
     */
    public boolean isAtLimit() {
        return mLimitForward.get() || mLimitResting.get() || mLimitReverse.get();
    }
    
    /**
     * Checks whether the pickup arm is at 'position' based on readings from
     * limit switches.
     * @param position The position to check if we're at
     * @return True if we're at 'position', false otherwise
     */
    public boolean isAtPosition(int position) {
        switch(position) {
            case Constants.PICKUP_POSITION_FORWARD:
                if(mLimitForward.get()) {
                    mPosition = Constants.PICKUP_POSITION_FORWARD;
                    return true;
                }
            case Constants.PICKUP_POSITION_REVERSE:
                if(mLimitReverse.get()) {
                    mPosition = Constants.PICKUP_POSITION_REVERSE;
                    return true;
                }
            case Constants.PICKUP_POSITION_RESTING:
                if(mLimitResting.get()) {
                    mPosition = Constants.PICKUP_POSITION_RESTING;
                    return true;
                }
            default:
                mPosition = Constants.PICKUP_POSITION_UNKNOWN;
                return false;
        }
    }
    
    /**
     * Move the pivot motor based on speed
     * @param speed speed to move motor at
     * @return true if the motor is successfully set, false if limit is hit
     */
    public boolean moveSpeed(double speed) {
        /*
         * Check if the limit switch for the direction of movement is hit, and
         * stop the motor if it is.
         */
        if(directionFromSpeed(speed) == Constants.PICKUP_DIRECTION_FORWARD &&
                mLimitForward.get()) {
            mPivotMotor.set(0.0);
            return false;
        }
        
        if(directionFromSpeed(speed) == Constants.PICKUP_DIRECTION_REVERSE &&
                mLimitReverse.get()) {
            mPivotMotor.set(0.0);
            return false;
        }
        
        //Scale the output if the range is too wide.
        if(speed > 1.0) {
            speed = 1.0;
        } else if (speed < -1.0) {
            speed = -1.0;
        }
        
        mPivotMotor.set(speed);
        return true;
    }
    
    /**
     * Sets motor to full forward or full reverse based on parameter
     * @param direction The direction to spin the motor.
     * @return True for successful completion, false for incomplete.
     */
    public boolean moveDirection(int direction) {
        switch(direction) {
            case Constants.PICKUP_DIRECTION_FORWARD:
                return moveSpeed(1.0);
            case Constants.PICKUP_DIRECTION_REVERSE:
                return moveSpeed(-1.0);
            case Constants.PICKUP_DIRECTION_STOPPED:
                return moveSpeed(0.0);
            default:
                moveSpeed(0.0);
                return false;
        }
    }
    
    /**
     * Sets the motor speed to 0
     */
    public void stopPivot() {
        moveSpeed(0.0);
    }
    
    /**
     * Determines the direction of movement based on a number value.
     * @param speed The number value which will be analyzed for direction.
     * @return The direction of movement, in terms of constants in Constants.java
     */
    private int directionFromSpeed(double speed) {
        if(speed > 0) {
            return Constants.PICKUP_DIRECTION_FORWARD;
        } else if (speed < 0) {
            return Constants.PICKUP_DIRECTION_REVERSE;
        }
        return Constants.PICKUP_DIRECTION_STOPPED;
    }
    
    protected void initDefaultCommand() {
        //No default command, leave blank
    }
}