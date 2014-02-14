/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Class to contain all of the user input devices (Joysticks, gamepads) and
 * to manage the logging and interface with the SmartDashboard and Driver
 * Station
 * @author Nick
 */
public class Console {
    
    /**
     * Driver Station object to transfer data to and from the DS
     */
    private DriverStation mDriverStation;
    
    /**
     * The object for writing data to the "User Messages" box on the Driver
     * Station.  Can be used for debugging or state conditions.
     */
    private DriverStationLCD mLCD;
    
    /*
     * TODO rename controls and use constants
     */
    public static Joystick mJoystick = new Joystick(Constants.JOYSTICK);
    public static Button mButton1 = new JoystickButton(mJoystick, 1);
    public static Button mButton2 = new JoystickButton(mJoystick, 2);
    public static Button mButton3 = new JoystickButton(mJoystick, 3);
}