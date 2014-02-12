/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014;

/**
 *
 * @author Taylor C.
 */
public class Constants {
    
    //Declare constants of the PWM ports of specified motors
    //TODO rewrite values with correct correspondance to the robot.
    public static final int DRIVE_LEFT_FRONT = 1;
    public static final int DRIVE_LEFT_REAR = 2;
    public static final int DRIVE_RIGHT_FRONT = 3;
    public static final int DRIVE_RIGHT_REAR = 4;
    public static final int PICKUP_PIVOT = 5;
    public static final int PICKUP_ROLLERS = 6;
    
    //Solenoid outputs
    public static final int SHIFTER_SOLENOID = 1;
    
    //Declare Digital IO ports of digital sensors
    public static final int FRONT_ARM_LIMIT_SWITCH = 1;
    public static final int RESTING_ARM_LIMIT_SWITCH = 2;
    public static final int REAR_ARM_LIMIT_SWITCH = 3;
    public static final int PASSING_LIMIT_SWITCH = 4;
    public static final int THROWING_LIMIT_SWITCH = 5;
    
    //Joystick buttons
    //to-do: add final button values
    public static final int THROW_BUTTON = 1;
    public static final int PASS_BUTTON = 0;
    public static final int ARM_FRONT_BUTTON = 2;
    public static final int ARM_RESTING_BUTTON = 3;
    public static final int ARM_REAR_BUTTON = 4;
    public static final int ROLLER_ON_BUTTON = 5;
    public static final int REVERSE_DRIVE_BUTTON = 6;

            
    /*
     * Declare channels for Driver Station Data. For use with 
     * "getDigitalIn(int channel)", 
     * "getAnalogIn(int channel)"
     * "setDigitalOut(int channel)"
     */
    public static final int DS_DIGITAL_1 = 1;
    public static final int DS_DIGITAL_2 = 2;
    public static final int DS_DIGITAL_3 = 3;
    public static final int DS_DIGITAL_4 = 4;
    public static final int DS_DIGITAL_5 = 5;
    public static final int DS_DIGITAL_6 = 6;
    public static final int DS_DIGITAL_7 = 7;
    public static final int DS_DIGITAL_8 = 8;
    
    public static final int DS_ANALOG_1 = 1;
    public static final int DS_ANALOG_2 = 2;
    public static final int DS_ANALOG_3 = 3;
    public static final int DS_ANALOG_4 = 4;
    public static final int DS_ANALOG_5 = 5;
    
    //Declare keys for SmartDashboard Data
    public static final String SD_LOG = "Log";
    public static final String SD_JOYSTICK_X = "JoyX";
    public static final String SD_JOYSTICK_Y = "JoyY";
    
    //Declare constants of the USB ports for specified joysticks
    public static final int JOYSTICK = 1;
    
    //Declare constants for robot states or conditions
    public static final int DRIVE_DIRECTION_FORWARD = 1;
    public static final int DRIVE_DIRECTION_REVERSE = -1;
    public static final int PICKUP_POSITION_FORWARD = 1;
    public static final int PICKUP_POSITION_RESTING = 2;
    public static final int PICKUP_POSITION_REVERSE = 3;
    public static final int PICKUP_POSITION_UNKNOWN = 4;
    public static final boolean DIGITAL_INPUT_1_INVERTED = false;
    public static final boolean DIGITAL_INPUT_2_INVERTED = false;
    public static final boolean DIGITAL_INPUT_3_INVERTED = false;
    public static final boolean DIGITAL_INPUT_4_INVERTED = false;
    public static final boolean DIGITAL_INPUT_5_INVERTED = false;
    public static final boolean DIGITAL_INPUT_6_INVERTED = false;
    public static final boolean DIGITAL_INPUT_7_INVERTED = false;
    public static final boolean DIGITAL_INPUT_8_INVERTED = false;
    public static final boolean DIGITAL_INPUT_9_INVERTED = false;
}