/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.subsystems.Pivot;
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
    private DSManager dsManager;
    private LCDManager lcdManager;
    private CarbonUI ui;
    
    public UIConfig nickJoystickConfig;
    public UIConfig nickGamepadConfig;

    private Console() {
        lcdManager = new LCDManager();
        initUIConfigs();
    }
    
    public static Console getConsole() {
        if(console == null) {
            console = new Console();
            return console;
        } else {
            return console;
        }
    }
    
    public CarbonUI initUI() {
        ui = new CarbonUI();
        return ui;
    }

    public CarbonUI getUI() {
        return ui;
    }
    
    public final void initUIConfigs() {
        /*
         * NICK JOYSTICK CONFIG
         */
        nickJoystickConfig = new UIConfig();
        //Button IDs
        nickJoystickConfig.setThrowButtonID(1);
        nickJoystickConfig.setUnloadButtonID(2);
        nickJoystickConfig.setPivotForwardButtonID(8);
        nickJoystickConfig.setPivotReverseButtonID(7);
        //Button Ports
        nickJoystickConfig.setThrowButtonPort(1);
        nickJoystickConfig.setUnloadButtonPort(1);
        nickJoystickConfig.setPivotForwardButtonPort(1);
        nickJoystickConfig.setPivotReverseButtonPort(1);
        //Axis IDs
        nickJoystickConfig.setDriveArcadeXAxisID(1);
        nickJoystickConfig.setDriveArcadeYAxisID(2);
        nickJoystickConfig.setDriveTankLeftAxisID(3);
        nickJoystickConfig.setDriveTankRightAxisID(4);
        //Axis Ports
        nickJoystickConfig.setDriveArcadeXAxisPort(1);
        nickJoystickConfig.setDriveArcadeYAxisPort(1);
        nickJoystickConfig.setDriveTankLeftAxisPort(1);
        nickJoystickConfig.setDriveTankRightPort(1);
        
        /*
         * NICK GAMEPAD CONFIG
         */
        nickGamepadConfig = new UIConfig();
        //Button IDs
        nickGamepadConfig.setThrowButtonID(6);
        nickGamepadConfig.setUnloadButtonID(8);
        nickGamepadConfig.setPivotForwardButtonID(5);
        nickGamepadConfig.setPivotReverseButtonID(7);
        //Button Ports
        nickGamepadConfig.setThrowButtonPort(1);
        nickGamepadConfig.setUnloadButtonPort(1);
        nickGamepadConfig.setPivotForwardButtonPort(1);
        nickGamepadConfig.setPivotReverseButtonPort(1);
        //Axis IDs
        nickGamepadConfig.setDriveArcadeXAxisID(3);
        nickGamepadConfig.setDriveArcadeYAxisID(2);
        //Axis Ports
        nickGamepadConfig.setDriveArcadeXAxisPort(1);
        nickGamepadConfig.setDriveArcadeYAxisPort(1);
    }
    
    public LCDManager getLCDManager() {
        return lcdManager;
    }
    
    public DSManager getDriverStationManager() {
        return dsManager;
    }
    
    public class DSManager {
        
        public static final int CHANNEL_DIGITAL1 = 1;
        public static final int CHANNEL_DIGITAL2 = 2;
        public static final int CHANNEL_DIGITAL3 = 3;
        public static final int CHANNEL_DIGITAL4 = 4;
        public static final int CHANNEL_DIGITAL5 = 5;
        public static final int CHANNEL_DIGITAL6 = 6;
        public static final int CHANNEL_DIGITAL7 = 7;
        public static final int CHANNEL_DIGITAL8 = 8;
        public static final int CHANNEL_ANALOG1 = 1;
        public static final int CHANNEL_ANALOG2 = 2;
        public static final int CHANNEL_ANALOG3 = 3;
        public static final int CHANNEL_ANALOG4 = 4;
        
       /**
        * Driver Station object to transfer data to and from the DS
        */
        private DriverStation driverStation;
        
        private DSManager() {
            driverStation = DriverStation.getInstance();
        }
        
        public void setDigitalOutput(int channel, boolean enabled) {
            driverStation.setDigitalOut(channel, enabled);
        }
        
        public boolean getDigitalOutput(int channel) {
            return driverStation.getDigitalOut(channel);
        }
        
        public boolean getDigitalInput(int channel) {
            return driverStation.getDigitalIn(channel);
        }
        
        public double getAnalogInput(int channel) {
            return driverStation.getAnalogIn(channel);
        }
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
        
        public static final int DRIVEMODE_ARCADE = 0;
        public static final int DRIVEMODE_TANK = 1;
        public static final int PIVOTMODE_HOLDDOWN = 0;
        public static final int PIVOTMODE_TOGGLE = 1;
        public static final int PIVOTMODE_AUTO = 2;
        
        private String driveStatus = "";
        private String pivotStatus = "";
        private String pickupIntakeStatus = "";
        private String throwerStatus = "";
        
        private String driveMotorSpeeds = "";
        private String driveMode = "";
        private String pivotPosition = "";
        private String pivotSpeed = "";
        private String pivotMode = "";
        private String throwerReloaded = "";
        
        private LCDManager() {
            System.out.println("Init LCDManager");
            lcd = DriverStationLCD.getInstance();
            System.out.println("LCD: " + lcd);
            
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
            if(mode == DRIVEMODE_ARCADE) {
                driveMode = "[DRIVE:ARCADE]";
            } else if (mode == DRIVEMODE_TANK) {
                driveMode = "[DRIVE:TANK]";
            }
            updateDriveStatus();
        }
        
        private void updateDriveStatus() {
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
            if(mode == PIVOTMODE_HOLDDOWN) {
                pivotMode = "[PIVOT:HOLD]";
            } else if (mode == PIVOTMODE_TOGGLE) {
                pivotMode = "[PIVOT:TOGGLE]";
            } else if (mode == PIVOTMODE_AUTO) {
                pivotMode = "[PIVOT:AUTO]";
            }
            updatePivotStatus();
        }
        
        private void updatePivotStatus() {
            pivotStatus = pivotMode + " " + pivotSpeed + " " + pivotPosition;
            updateLCD();
        }
        
        public void setThrowerReloaded(boolean reloaded) {
            if(reloaded) {
                throwerReloaded = "[THROWER:RELOADED]";
            } else {
                throwerReloaded = "[THROWER:RELOADING]";
            }
            updateThrowerStatus();
        }
        
        private void updateThrowerStatus() {
            throwerStatus = throwerReloaded;
            updateLCD();
        }
        
        private void updateLCD() {
            lcd.println(
                    DriverStationLCD.Line.kUser1,
                    1, 
                    driveStatus);
            lcd.println(DriverStationLCD.Line.kUser2, 1, pivotStatus);
            lcd.println(DriverStationLCD.Line.kUser3, 1, throwerStatus);
            lcd.updateLCD();
        }
    }
}