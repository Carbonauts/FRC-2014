/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.util.CarbonJoystick;
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
    public static final CarbonJoystick mJoystick = new CarbonJoystick(Constants.JOYSTICK);
    public static Button mButton1 = new JoystickButton(mJoystick, 1);
    public static Button mButton2 = new JoystickButton(mJoystick, 2);
    public static Button mButton3 = new JoystickButton(mJoystick, 3);
    public static Button mButton4 = new JoystickButton(mJoystick, 3);
    public static Button mButton5 = new JoystickButton(mJoystick, 3);
    public static Button mButton6 = new JoystickButton(mJoystick, 3);
    public static Button mButton7 = new JoystickButton(mJoystick, 3);
    public static Button mButton8 = new JoystickButton(mJoystick, 3);
    public static Button mButton9 = new JoystickButton(mJoystick, 3);
    public static Button mButton10 = new JoystickButton(mJoystick, 3);
    public static Button mButton11 = new JoystickButton(mJoystick, 3);
    public static Button mButton12 = new JoystickButton(mJoystick, 3);
}