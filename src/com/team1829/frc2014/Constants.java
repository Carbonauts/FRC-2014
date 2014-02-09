/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.team1829.frc2014;

/**
 *
 * @author Taylor C.
 */
public class Constants {
    
    /*
     * Declare constants of the PWM ports of specified motors 
     */
    public static final int DRIVE_LEFT_FRONT = 1;
    public static final int DRIVE_LEFT_REAR = 2;
    public static final int DRIVE_RIGHT_FRONT = 3;
    public static final int DRIVE_RIGHT_REAR = 4;
    
    /*
     * Declare channels for Driver Station Data
     * 
     * For use with "getDigitalIn(int channel)", "getAnalogIn(int channel)"
     * and "setDigitalOut(int channel)"
     */
    public static final int DS_DIGITAL_1 = 1;
    public static final int DS_DIGITAL_2 = 2;
    public static final int DS_DIGITAL_3 = 3;
    public static final int DS_DIGITAL_4 = 4;
    public static final int DS_DIGITAL_5 = 5;
    public static final int DS_DIGITAL_6 = 6;
    public static final int DS_DIGITAL_7 = 7;
    
    public static final int DS_ANALOG_1 = 1;
    public static final int DS_ANALOG_2 = 2;
    public static final int DS_ANALOG_3 = 3;
    public static final int DS_ANALOG_4 = 4;
    public static final int DS_ANALOG_5 = 5;
    
    /*
     * Declare keys for SmartDashboard Data
     */
    public static final String SD_LOG = "Log";
    public static final String SD_JOYSTICK_X = "JoyX";
    public static final String SD_JOYSTICK_Y = "JoyY";
    
    /*
     * Declare constants of the USB ports for specified joysticks
     */
    public static final int JOYSTICK = 1;
}