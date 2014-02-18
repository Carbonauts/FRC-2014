/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.util.CarbonJoystick;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;

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
    
    /*
     * TODO rename controls and use constants
     */
    private static final CarbonJoystick joystick = new CarbonJoystick(Constants.JOYSTICK);

    public static void init() {
        
    }
    
    /**
     * @return the joystick
     */
    public static CarbonJoystick getJoystick() {
        return joystick;
    }
    
    /**
     * Use this class to create preset data 'bins' for output to the screen.
     * For example if a reading from a sensor needs to be displayed, create a
     * variable for it in this class (including a setter and getter) and then
     * set the values via calls from within subsystems and other parts of the
     * code.  Then each bin can be correctly placed in an arrangement which can
     * then be sent to the Driver Station.
     */
    public class LCDManager {
        
        /**
        * The object for writing data to the "User Messages" box on the Driver
        * Station.  Can be used for debugging or state conditions.
        */
        private DriverStationLCD lcd;
        
        public LCDManager() {
            lcd = DriverStationLCD.getInstance();
        }
    }
}