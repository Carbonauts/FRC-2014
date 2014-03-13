/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.util.CarbonDigitalInput;
import com.carbonauts.frc2014.util.CarbonTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to control the pickup arm and it's rollers on the robot.  Includes
 * pivoting the arm and running the rollers to suck in the ball.  Needs position
 * management, for which limit switches are currently being used.  It may be
 * necessary (or just nice) to employ encoders for this subsystem
 * @author Nick
 */
public class Pivot extends Subsystem {

    public static final int DIRECTION_FORWARD = 1;   //State constant
    public static final int DIRECTION_STOPPED = 0;   //State constant
    public static final int DIRECTION_REVERSE = -1;  //State constant
    public static final int POSITION_FORWARD = 0;    //State constant
    public static final int POSITION_RESTING = 1;    //State constant
    public static final int POSITION_REVERSE = 2;    //State constant
    public static final int POSITION_UNKNOWN = 3;    //State constant
    
    //Declare Talon
    private CarbonTalon pivotMotor;
    
    private Console console;
    
    //Declare Limit switch objects
    private DigitalInput limitForward;
    private DigitalInput limitResting;
    private DigitalInput limitReverse;
    
    //Declare pivot encoder
    private Encoder encoder;
    
    //State-keeping variables (may replace with methods)
    private int position = -1;
    private int positionTarget = -1;
    
    /**
     * Construct the subsystem; define hardware
     */
    public Pivot() {
        
        //Define Talon
        pivotMotor = new CarbonTalon(Constants.PIVOT);
        
        pivotMotor.enableDeadbandElimination(true);
        
        /*
         * Using custom DigitalInput class (CarbonDigitalInput) in order to control
         * the inversion of the get() statement.  Each inversion is declared at
         * construction and is controlled from constants
         */
        limitForward = new CarbonDigitalInput(
                Constants.PIVOT_LIMIT_FORWARD,
                Constants.PIVOT_LIMIT_FORWARD_INVERTED);
        limitResting = new CarbonDigitalInput(
                Constants.PIVOT_LIMIT_RESTING,
                Constants.PIVOT_LIMIT_RESTING_INVERTED);
        limitReverse = new CarbonDigitalInput(
                Constants.PIVOT_LIMIT_REVERSE,
                Constants.PIVOT_LIMIT_REVERSE_INVERTED);
        
        console = Console.getConsole();
        
        encoder = new Encoder(Constants.PIVOT_ENCODER_PIN1, 
                              Constants.PIVOT_ENCODER_PIN2, 
                              Constants.PIVOT_ENCODER_INVERTED);
        
        updatePosition();
    }
    
    /**
     * Determines whether the pickup arm is currently positioned at one of the
     * preset positions with a limit switch
     * @return True if the arm is at preset, false otherwise
     */
    public boolean isAtLimit() {
        return limitForward.get() || limitResting.get() || limitReverse.get();
    }
    
    /**
     * Checks whether the pickup arm is at 'position' based on readings from
     * limit switches.
     * @param position The position to check if we're at
     * @return True if we're at 'position', false otherwise
     */
    public boolean isAtPosition(int position) {
        return this.position == position;
    }
    
    public final void updatePosition() {
        if(limitForward.get()) {
            position = POSITION_FORWARD;
            
        } else if(limitResting.get()) {
            position = POSITION_RESTING;
            
        } else if(limitReverse.get()) {
            position = POSITION_REVERSE;
            
        } else {
            position = POSITION_UNKNOWN;
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
        if(directionFromSpeed(speed) == DIRECTION_FORWARD &&
                                        limitForward.get()) {
            pivotMotor.setRamp(0.0);
            return false;
        }
        
        if(directionFromSpeed(speed) == DIRECTION_REVERSE &&
                                        limitReverse.get()) {
            pivotMotor.setRamp(0.0);
            return false;
        }
        
        //Scale the output if the range is too wide.
        if(speed > 1.0) {
            speed = 1.0;
        } else if (speed < -1.0) {
            speed = -1.0;
        }
        
        pivotMotor.setRamp(speed);
        return true;
    }
    
    /**
     * Sets motor to full forward or full reverse based on parameter
     * @param direction The direction to spin the motor.
     * @return True for successful completion, false for incomplete.
     */
    public boolean moveDirection(int direction) {
        switch(direction) {
            case DIRECTION_FORWARD:
                positionTarget = POSITION_FORWARD;
                return moveSpeed(1.0);
                
            case DIRECTION_REVERSE:
                positionTarget = POSITION_REVERSE;
                return moveSpeed(-1.0);
                
            case DIRECTION_STOPPED:
                positionTarget = POSITION_UNKNOWN;
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
     * Sets the motor speed to 0 without using a ramp (instant speed change)
     */
    public void emergencyStopPivot() {
        pivotMotor.stopMotor();
    }
    
    /**
     * Determines the direction of movement based on a number value.
     * @param speed The number value which will be analyzed for direction.
     * @return The direction of movement, in terms of constants in Constants.java
     */
    private int directionFromSpeed(double speed) {
        if(speed > 0) {
            return DIRECTION_FORWARD;
        } else if (speed < 0) {
            return DIRECTION_REVERSE;
        }
        return DIRECTION_STOPPED;
    }
    
    protected void initDefaultCommand() {
        //No default command, leave blank
    }

    public int getPosition() {
        return position;
    }
    
    public int getPositionTarget() {
        return positionTarget;
    }
    
    public boolean getForwardLimitState() {
        return limitForward.get();
    }
    
    public boolean getRestingLimitState() {
        return limitResting.get();
    }
    
    public boolean getReverseLimitState() {
        return limitReverse.get();
    }
}