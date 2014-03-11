/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.subsystems.Pivot;
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

    private static Console console;
    
    /**
     * Driver Station object to transfer data to and from the DS
     */
    private DriverStation driverStation;
    
    private LCDManager lcdManager;
    
    /*
     * TODO rename controls and use constants
     */
    private CarbonJoystick joystick;

    private Console() {
        lcdManager = new LCDManager();
        joystick = new CarbonJoystick(Constants.JOYSTICK);
    }
    
    public static Console getConsole() {
        if(console == null) {
            console = new Console();
            return console;
        } else {
            return console;
        }
    }
    
    /**
     * @return the joystick
     */
    public CarbonJoystick getJoystick() {
        return joystick;
    }
    
    public LCDManager getLCDManager() {
        return lcdManager;
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
        
        private String driveStatus;
        private String pivotStatus;
        private String pickupIntakeStatus;
        private String throwerStatus;
        
        private String driveMotorSpeeds;
        private String driveMode;
        
        private String pivotPosition;
        private String pivotSpeed;
        private String pivotMode;
        
        public LCDManager() {
            lcd = DriverStationLCD.getInstance();
            
            driveStatus = null;
            pivotStatus = null;
            pickupIntakeStatus = null;
            throwerStatus = null;
            
            driveMotorSpeeds = null;
            driveMode = null;
        }
        
        public void setDriveMotorSpeeds(double fl, double fr, double rl, double rr) {
            driveMotorSpeeds = "FL:" + fl + " FR:" + fr + " RL:" + rl + " RR:" + rr;
            updateDriveStatus();
        }
        
        public void setDriveMode(int mode) {
            if(mode == Constants.STATUS_DRIVEMODE_ARCADE) {
                driveMode = "[DRIVE:ARCADE]";
            } else if (mode == Constants.STATUS_DRIVEMODE_TANK) {
                driveMode = "[DRIVE:TANK]";
            }
            updateDriveStatus();
        }
        
        public void updateDriveStatus() {
            driveStatus = driveMode + " " + driveMotorSpeeds;
            updateLCD();
        }
        
        public void setPivotPosition(int position) {
            if(position == Pivot.POSITION_FORWARD) {
                pivotPosition = "Position:FORWARD";
            } else if (position == Pivot.POSITION_RESTING) {
                pivotPosition = "Position:RESTING";
            } else if (position == Pivot.POSITION_REVERSE) {
                pivotPosition = "Position:REVERSE";
            } else {
                pivotPosition = "Position:UNKNOWN";
            }
            updatePivotStatus();
        }
        
        public void setPivotMotorSpeed(double speed) {
            pivotSpeed = "Speed: " + speed;
            updatePivotStatus();
        }
        
        public void setPivotMode(int mode) {
            if(mode == Constants.STATUS_PIVOTMODE_HOLDDOWN) {
                pivotMode = "[PIVOT:HOLD]";
            } else if (mode == Constants.STATUS_PIVOTMODE_TOGGLE) {
                pivotMode = "[PIVOT:TOGGLE]";
            } else if (mode == Constants.STATUS_PIVOTMODE_AUTO) {
                pivotMode = "[PIVOT:AUTO]";
            }
            updatePivotStatus();
        }
        
        public void updatePivotStatus() {
            pivotStatus = pivotMode + " " + pivotSpeed + " " + pivotPosition;
            updateLCD();
        }
        
        public void updateLCD() {
            lcd.println(DriverStationLCD.Line.kUser1, 0, driveStatus);
            lcd.println(DriverStationLCD.Line.kUser2, 0, pivotStatus);
            lcd.updateLCD();
        }
    }
}