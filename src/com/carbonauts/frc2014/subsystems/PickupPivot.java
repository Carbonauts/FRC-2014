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
    private int mLastPosition;
    private int mRollerDirection = 0;
    
    /**
     * Construct the subsystem; define hardware
     */
    /************************************************
     * Comment by Greg:
     * for consistency with the WPI functions consider having the constructor
     * take the talon and LS ports as input. When you instantiate the object
     * you use the appropriate constants from Constants.java
     * pros: as written this is more user-proof (you don't get the opportunity to NOT
     * use the constants)
     * cons: as written this is less abstract; it contains a lateral dependency
     * ************************************************
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
                Constants.DIGITAL_INPUT_1_INVERTED);
        mLimitResting = new CarbonDigitalInput(
                Constants.RESTING_ARM_LIMIT_SWITCH,
                Constants.DIGITAL_INPUT_2_INVERTED);
        mLimitReverse = new CarbonDigitalInput(
                Constants.REAR_ARM_LIMIT_SWITCH,
                Constants.DIGITAL_INPUT_3_INVERTED);
    }
    
    /**
     * Determines whether the pickup arm is currently positioned at one of the
     * preset positions
     * @return True if the arm is at preset, false otherwise
     * 
     * ********************************************************
     * Comment by Greg:
     * is this redundant with isAtPosition()?
     * if not they should both be implemented with the same private (or public)
     * method getPosition()
     * ********************************************************
     */
    public boolean isAtLimit() {
        return mLimitForward.get() || mLimitResting.get() || mLimitReverse.get();
    }
    
    /**
     * Determines whether the system is currently at the position fed as a
     * parameter
     * @param position The position we're checking whether we're at or not
     * @return True if we're at position, false otherwise
     * @param position
     * @return 
     */
    
    /************************************************************
     * Comment by Greg:
     * There should really be at least 5 positions for the arm.
     * The three you have listed below and two more for the in between states
     * Having those explicitly as positions might simplify the commands
     * (I'm thinking about roller direction)
     * 
     * Also doesn't it make more sense for there to be a private method or
     * variable that keeps track of the current position?
     * Then this method could be implemented with a single line:
     * return position == privatePosition;
     * **************************************************************
     */
    public boolean isAtPosition(int position) {
        switch(position) {
            case Constants.PICKUP_POSITION_FORWARD:
                return mLimitForward.get();
            case Constants.PICKUP_POSITION_RESTING:
                return mLimitResting.get();
            case Constants.PICKUP_POSITION_REVERSE:
                return mLimitReverse.get();
            default:
                return false;
        }
    }
    
    protected void initDefaultCommand() {
        //No default command, leave blank
    }
}