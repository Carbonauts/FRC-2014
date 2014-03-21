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
    public static final int PIVOT = 7;              //PWM for Pivot Talon
    public static final int THROWER = 6;            //PWM for Thrower Talon
    public static final int INTAKE = 5;              //PWM for Roller Talon
    
    //LIMIT SWITCHES
    public static final int PIVOT_LIMIT_REVERSE = 1;   //PWM for Reverse Limit
    public static final int PIVOT_LIMIT_FORWARD = 2;   //PWM for Forward Limit
    public static final int THROWER_RETRACT_LIMIT = 3; //PWM for Thrower retracted limit
    public static final int THROWER_LOADED_LIMIT = 4;  //PWM for Thrower loaded limit
    
    //ENCODERS
    public static final int PIVOT_ENCODER_PIN1 = 13;   //DIO for Encoder
    public static final int PIVOT_ENCODER_PIN2 = 14;   //DIO for Encoder
    
    //SOLENOIDS
    public static final int SHIFTER_SOLENOID = 1;   //Port for Shifter Solenoid
    
    //HARDWARE INVERSIONS
    public static final boolean DRIVE_LEFT_FRONT_INVERTED = false;
    public static final boolean DRIVE_LEFT_REAR_INVERTED = false;
    public static final boolean DRIVE_RIGHT_FRONT_INVERTED = false;
    public static final boolean DRIVE_RIGHT_REAR_INVERTED = false;
    public static final boolean PIVOT_LIMIT_FORWARD_INVERTED = true;
    public static final boolean PIVOT_LIMIT_REVERSE_INVERTED = true;
    public static final boolean THROWER_RETRACT_LIMIT_INVERTED = true;
    public static final boolean THROWER_LOADED_LIMIT_INVERTED = true;
    public static final boolean PIVOT_ENCODER_INVERTED = true;
    public static final boolean SHIFTER_HIGH_GEAR = true;
    
    //JOYSTICK
    public static final int JOYSTICK1 = 1;               //USB for Joystick
    public static final int JOYSTICK2 = 2;               //USB for Joystick
    public static final int JOYSTICK3 = 3;               //USB for Joystick
    public static final int JOYSTICK4 = 4;               //USB for Joystick
    public static final int BUTTON_DEFAULT_THROW = 1;           //Button ID
    public static final int BUTTON_DEFAULT_UNLOAD = 2;          //Button ID
    public static final int BUTTON_DEFAULT_PIVOT_FORWARD = 3;     //Button ID
    public static final int BUTTON_DEFAULT_PIVOT_REVERSE = 5;     //Button ID
    public static final int BUTTON_DEFAULT_INTAKE = 6;      //Button ID
    public static final int BUTTON_DEFAULT_INVERT_DRIVE = 7;    //Button ID
    public static final int BUTTON_DEFAULT_SHIFT = 8;           //Button ID
    public static final boolean AXIS_ARCADEX_INVERTED = false;
    public static final boolean AXIS_ARCADEY_INVERTED = false;
    public static final boolean AXIS_TANKLEFT_INVERTED = false;
    public static final boolean AXIS_TANKRIGHT_INVERTED = false;
    
    //VALUES
    public static final boolean RAMPS_ENABLED = true;
    public static final double RAMP_DEFAULT_STEPSIZE = 0.05;
    public static final double PIVOT_POSITION_CENTER = 0;
    public static final double PIVOT_POSITION_TOLERANCE = 20.0;
    public static final double PIVOT_RATE = 0.4;
    public static final double PIVOT_PID_P = 0.01;
    public static final double PIVOT_PID_I = 0;
    public static final double PIVOT_PID_D = 0;
    public static final double PIVOT_PID_MIN = -PIVOT_RATE;
    public static final double PIVOT_PID_MAX = PIVOT_RATE;
    public static final long RAMP_DEFAULT_STEPTIME = 10;    
    public static final long THROWER_UNLOAD_TIME = 700;
    
    //AUTONOMOUS
    public static final double AUTO_DRIVE_POWER = 0.3;
}