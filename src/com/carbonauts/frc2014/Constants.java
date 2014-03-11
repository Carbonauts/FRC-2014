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
    public static final int DRIVE_LEFT_FRONT = 2;   //PWM for LF Talon
    public static final int DRIVE_LEFT_REAR = 4;    //PWM for LR Talon
    public static final int DRIVE_RIGHT_FRONT = 1;  //PWM for RF Talon
    public static final int DRIVE_RIGHT_REAR = 3;   //PWM for RR Talon
    public static final int SHIFTER_SOLENOID = 1;   //DIO for Shifter Solenoid
    
    /***************************************************************************
     * All PIVOT constants
     **************************************************************************/
    public static final int PIVOT = 7;           //PWM for Pivot Talon
    public static final int PIVOT_LIMIT_FORWARD = 1;   //PWM for Forward Limit
    public static final int PIVOT_LIMIT_RESTING = 2;   //PWM for Resting Limit
    public static final int PIVOT_LIMIT_REVERSE = 3;   //PWM for Reverse Limit
    public static final int PIVOT_ENCODER_PIN1 = -1;   //PUT A NUMBER HERE VERY IMPORTANT
    public static final int PIVOT_ENCODER_PIN2 = -1;   //ALSO PUT A NUMBER HERE VERY IMPORTANT
    public static final boolean PIVOT_ENCODER_INVERTED = false;
    
    /***************************************************************************
     * All INTAKE constants
     **************************************************************************/
    public static final int INTAKE_ROLLERS = 5; //PWM for Roller Talon
    
    /***************************************************************************
     * All JOYSTICK constants
     **************************************************************************/
    public static final int JOYSTICK = 1;               //USB for Joystick
    
    public static final int BUTTON_THROW = 5;           //Button ID
    public static final int BUTTON_ARM_FORWARD = 2;     //Button ID
    public static final int BUTTON_ARM_RESTING = 3;     //Button ID
    public static final int BUTTON_ARM_REVERSE = 4;     //Button ID
    public static final int BUTTON_ROLLERS_ON = 1;      //Button ID
    public static final int BUTTON_INVERT_DRIVE = 6;    //Button ID
    public static final int BUTTON_SHIFT = 7;           //Button ID
    
    /***************************************************************************
     * All INVERSION constants
     **************************************************************************/
    public static final boolean PIVOT_LIMIT_FORWARD_INVERTED = true;
    public static final boolean PIVOT_LIMIT_RESTING_INVERTED = true;
    public static final boolean PIVOT_LIMIT_REVERSE_INVERTED = true;
    public static final boolean DIO4_INVERTED = false;
    public static final boolean DIO5_INVERTED = false;
    public static final boolean DIO6_INVERTED = false;
    public static final boolean DIO7_INVERTED = false;
    public static final boolean DIO8_INVERTED = false;
    public static final boolean DIO9_INVERTED = false;
    
    /***************************************************************************
     * All CONSOLE constants
     **************************************************************************/
    
    //Status selector constants
    public static final int STATUS_DRIVEMODE_ARCADE = 0;
    public static final int STATUS_DRIVEMODE_TANK = 1;
    
    public static final int STATUS_PIVOTMODE_HOLDDOWN = 0;
    public static final int STATUS_PIVOTMODE_TOGGLE = 1;
    public static final int STATUS_PIVOTMODE_AUTO = 2;
    
    /***************************************************************************
     * All RAMP constants
     **************************************************************************/
    public static final double DEFAULT_RAMP_STEP = 0.05; 
    public static final long DEFAULT_RAMP_TIME = 10;
}
