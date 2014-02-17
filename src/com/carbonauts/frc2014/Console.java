/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.command.CommandBase;
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
    
    /**
     * The object for writing data to the "User Messages" box on the Driver
     * Station.  Can be used for debugging or state conditions.
     */
    private static DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    /*
     * TODO rename controls and use constants
     */
    private static final CarbonJoystick joystick = new CarbonJoystick(Constants.JOYSTICK);

    public static void init() {
        
    }
    
    public static void updateLCD() {
        lcd.println(DriverStationLCD.Line.kUser1, 1, CommandBase.drive.getDriveStatus());
        lcd.println(DriverStationLCD.Line.kUser2, 1, CommandBase.pickupPivot.getPickupStatus());
        lcd.updateLCD();
    }
    
    /**
     * @return the joystick
     */
    public static CarbonJoystick getJoystick() {
        return joystick;
    }
}