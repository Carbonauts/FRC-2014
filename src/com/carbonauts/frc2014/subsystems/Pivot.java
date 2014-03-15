/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.command.OperatorPivotCommand;
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

    public static final boolean DIRECTION_FORWARD = true;   //State constant
    public static final boolean DIRECTION_REVERSE = false;  //State constant
    public static final int POSITION_FORWARD = 0;    //State constant
    public static final int POSITION_RESTING = 1;    //State constant
    public static final int POSITION_REVERSE = 2;    //State constant
    
    private CarbonTalon pivotMotor;
    private OperatorPivotCommand defaultPivotCommand;
    private Console console;
    
    //Declare Limit switch objects
    private DigitalInput limitForward;
    private DigitalInput limitReverse;
    
    //Declare pivot encoder
    private Encoder encoder;
    
    /**
     * Construct the subsystem; define hardware
     */
    public Pivot() {
        
        //Define Talon
        pivotMotor = new CarbonTalon(Constants.PIVOT);
        
        /*
         * Using custom DigitalInput class (CarbonDigitalInput) in order to control
         * the inversion of the get() statement.  Each inversion is declared at
         * construction and is controlled from constants
         */
        limitForward = new CarbonDigitalInput(
                Constants.PIVOT_LIMIT_FORWARD,
                Constants.PIVOT_LIMIT_FORWARD_INVERTED);
        limitReverse = new CarbonDigitalInput(
                Constants.PIVOT_LIMIT_REVERSE,
                Constants.PIVOT_LIMIT_REVERSE_INVERTED);
        
        console = Console.getConsole();
        
        encoder = new Encoder(Constants.PIVOT_ENCODER_PIN1, 
                              Constants.PIVOT_ENCODER_PIN2, 
                              Constants.PIVOT_ENCODER_INVERTED);
        encoder.start();
    }
    
    public void setPivotSpeed(double speed) {
        pivotMotor.setRamp(speed);
    }
    
    public void setPivotForward() {
        if(!limitForward.get()) {
            setPivotSpeed(1.0);
        } else {
            hardStopPivot();
        }
    }
    
    public void setPivotReverse() {
        if(!limitReverse.get()) {
            setPivotSpeed(-1.0);
        } else {
            hardStopPivot();
        }
    }
    
    public void stopPivot() {
        pivotMotor.stopMotor();
    }
    
    public void hardStopPivot() {
        pivotMotor.hardStopMotor();
    }
    
    protected void initDefaultCommand() {
        defaultPivotCommand = new OperatorPivotCommand();
        setDefaultCommand(defaultPivotCommand);
    }
    
    public boolean getForwardLimitState() {
        return limitForward.get();
    }
    
    public boolean getReverseLimitState() {
        return limitReverse.get();
    }
    
    public boolean getDirection() {
        return encoder.getDirection();
    }
    
    public double getDistance() {
        return encoder.getDistance();
    }
    
    public void resetDistance() {
        encoder.reset();
    }
}