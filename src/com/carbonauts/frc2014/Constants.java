/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014;

/**
 * These constant values are used throughout the project code to reference
 * unchanging values.  Some values are to reference physical manifestations on
 * the robot (such as PWM or DIO ports) and others are used to define states
 * of systems (for example, define a value which represents "forward" on a 
 * particular system).
 * @author Taylor C.
 * @author Nick
 */
public class Constants {
    
    //MOTORS
    public static final int DRIVE_RIGHT_FRONT = 1;  //PWM for RF Talon
    public static final int DRIVE_LEFT_FRONT = 2;   //PWM for LF Talon
    public static final int DRIVE_RIGHT_REAR = 3;   //PWM for RR Talon
    public static final int DRIVE_LEFT_REAR = 4;    //PWM for LR Talon
    public static final int INTAKE_ROLLERS = 5;     //PWM for Roller Talon
    public static final int THROWER = 6;            //PWM for Thrower Talon
    public static final int PIVOT = 7;              //PWM for Pivot Talon
    
    //LIMIT SWITCHES
    public static final int THROWER_LIMIT = 1;         //PWM for Thrower Limit
    public static final int PIVOT_LIMIT_FORWARD = 2;   //PWM for Forward Limit
    public static final int PIVOT_LIMIT_RESTING = 3;   //PWM for Resting Limit
    public static final int PIVOT_LIMIT_REVERSE = 4;   //PWM for Reverse Limit
    
    
    //ENCODERS
    public static final int PIVOT_ENCODER_PIN1 = 13;   //PUT A NUMBER HERE VERY IMPORTANT
    public static final int PIVOT_ENCODER_PIN2 = 14;   //ALSO PUT A NUMBER HERE VERY IMPORTANT
    
    //SOLENOIDS
    public static final int SHIFTER_SOLENOID = 1;   //DIO for Shifter Solenoid
    
    //HARDWARE INVERSIONS
    public static final boolean PIVOT_LIMIT_FORWARD_INVERTED = true;
    public static final boolean PIVOT_LIMIT_RESTING_INVERTED = true;
    public static final boolean PIVOT_LIMIT_REVERSE_INVERTED = true;
    public static final boolean THROWER_LIMIT_INVERTED = true;
    public static final boolean PIVOT_ENCODER_INVERTED = false;
    
    //JOYSTICK
    public static final int JOYSTICK = 1;               //USB for Joystick
    public static final int BUTTON_THROW = 1;           //Button ID
    public static final int BUTTON_UNLOAD = 2;          //Button ID
    public static final int BUTTON_ARM_FORWARD = 3;     //Button ID
    public static final int BUTTON_ARM_RESTING = 4;     //Button ID
    public static final int BUTTON_ARM_REVERSE = 5;     //Button ID
    public static final int BUTTON_ROLLERS_ON = 6;      //Button ID
    public static final int BUTTON_INVERT_DRIVE = 7;    //Button ID
    public static final int BUTTON_SHIFT = 8;           //Button ID
    
    //VALUES
    public static final boolean DEBUG_MODE = true;
    public static final double RAMP_DEFAULT_STEPSIZE = 0.05; 
    public static final long RAMP_DEFAULT_STEPTIME = 10;    
    public static final long THROWER_UNLOAD_TIME = 1000;
}