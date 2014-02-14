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
                Constants.FRONT_ARM_LIMIT_SWITCH,
                Constants.DIO1_INVERTED);
        mLimitResting = new CarbonDigitalInput(
                Constants.RESTING_ARM_LIMIT_SWITCH,
                Constants.DIO2_INVERTED);
        mLimitReverse = new CarbonDigitalInput(
                Constants.REAR_ARM_LIMIT_SWITCH,
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
     * Move the pivot motor
     * @param speed speed to move motor at
     * @return true if the motor is set properly, false if limit is hit
     */
    public boolean moveSpeed(double speed) {
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
    
    public boolean moveDirection(int direction) {
        switch(direction) {
            case Constants.PICKUP_DIRECTION_FORWARD:
                return moveSpeed(1.0);
            case Constants.PICKUP_DIRECTION_REVERSE:
                return moveSpeed(-1.0);
            case Constants.PICKUP_DIRECTION_STILL:
                return moveSpeed(0.0);
            default:
                moveSpeed(0.0);
                return false;
        }
    }
    
    private int directionFromSpeed(double speed) {
        if(speed > 0) {
            return Constants.PICKUP_DIRECTION_FORWARD;
        } else if (speed < 0) {
            return Constants.PICKUP_DIRECTION_REVERSE;
        }
        return Constants.PICKUP_DIRECTION_STILL;
    }
    
    protected void initDefaultCommand() {
        //No default command, leave blank
    }
}