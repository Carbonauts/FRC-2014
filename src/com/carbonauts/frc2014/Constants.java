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
    
    /***************************************************************************
     * All DRIVE constants
     **************************************************************************/
    public static final int DRIVE_LEFT_FRONT = 1;   //PWM for LF Talon
    public static final int DRIVE_LEFT_REAR = 2;    //PWM for LR Talon
    public static final int DRIVE_RIGHT_FRONT = 3;  //PWM for RF Talon
    public static final int DRIVE_RIGHT_REAR = 4;   //PWM for RR Talon
    public static final int SHIFTER_SOLENOID = 1;   //PWM for Shifter Solenoid
    
    public static final int DRIVE_DIRECTION_FORWARD = 1;    //State constant
    public static final int DRIVE_DIRECTION_REVERSE = -1;   //State constant
    
    /***************************************************************************
     * All PICKUP PIVOT constants
     **************************************************************************/
    public static final int PICKUP_PIVOT = 5;           //PWM for Pivot Talon
    public static final int PICKUP_LIMIT_FORWARD = 1;   //PWM for Forward Limit
    public static final int PICKUP_LIMIT_RESTING = 2;   //PWM for Resting Limit
    public static final int PICKUP_LIMIT_REVERSE = 3;   //PWM for Reverse Limit
    
    public static final int PICKUP_DIRECTION_FORWARD = 1;   //State constant
    public static final int PICKUP_DIRECTION_STOPPED = 0;   //State constant
    public static final int PICKUP_DIRECTION_REVERSE = -1;  //State constant
    public static final int PICKUP_POSITION_FORWARD = 0;    //State constant
    public static final int PICKUP_POSITION_RESTING = 1;    //State constant
    public static final int PICKUP_POSITION_REVERSE = 2;    //State constant
    public static final int PICKUP_POSITION_UNKNOWN = 3;    //State constant
    
    /***************************************************************************
     * All PICKUP INTAKE constants
     **************************************************************************/
    public static final int PICKUP_ROLLERS = 6; //PWM for Roller Talon
    
    /***************************************************************************
     * All JOYSTICK constants
     **************************************************************************/
    public static final int JOYSTICK = 1;               //USB for Joystick
    
    public static final int BUTTON_THROW = 1;           //Button ID
    public static final int BUTTON_PASS = 1;            //Button ID
    public static final int BUTTON_ARM_FORWARD = 2;     //Button ID
    public static final int BUTTON_ARM_RESTING = 3;     //Button ID
    public static final int BUTTON_ARM_REVERSE = 4;     //Button ID
    public static final int BUTTON_ROLLERS_ON = 5;      //Button ID
    public static final int BUTTON_INVERT_DRIVE = 6;    //Button ID
    
    /***************************************************************************
     * All INVERSION constants
     **************************************************************************/
    public static final boolean DIO1_INVERTED = false;
    public static final boolean DIO2_INVERTED = false;
    public static final boolean DIO3_INVERTED = false;
    public static final boolean DIO4_INVERTED = false;
    public static final boolean DIO5_INVERTED = false;
    public static final boolean DIO6_INVERTED = false;
    public static final boolean DIO7_INVERTED = false;
    public static final boolean DIO8_INVERTED = false;
    public static final boolean DIO9_INVERTED = false;
}