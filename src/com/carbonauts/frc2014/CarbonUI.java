/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the core for all of the Operator needs pertaining to any
 * USB controllers.  The structure here is such that any action that the robot
 * needs to perform based on Operator input may be defined by it's name, and
 * then the resource which controls it may be separately manipulated.
 * 
 * For example, for driving, typically Joystick Axes are used for either a Tank
 * Drive or Arcade Drive.  To assign controls for each, you would define methods
 * such as "getArcadeXAxis()" and "getArcadeYAxis()".  These methods would
 * return the raw joystick value of the axis which was assigned to each of those
 * actions, regardless of which physical thumb-stick was assigned.  These
 * assignments are also dynamic, and they may be changed at any time.
 * 
 * The way to assign controller resources to an action is to create a PORT
 * variable and an ID variable for the action inside the UIConfig class (which
 * is a sub-class inside of CarbonUI).  These PORT and ID variables for the
 * action need encapsulation (getters and setters).  Then, a method is needed
 * in CarbonUI which has a return type which is the same as the value being 
 * retrieved from the USB controller.  The name of the method should reflect the
 * action which is using the resource.  Note: If more than one action all refer
 * to the same USB controller resource, they should both have unique action
 * methods in CarbonUI and unique ID and PORT variables in the UIConfig.  This
 * way, a chance in the resource for one action will not unintentionally remap
 * the resources for another action.
 * @author Nick
 */
public class CarbonUI {
    
    private final Joystick j1;
    private final Joystick j2;
    private final Joystick j3;
    private final Joystick j4;
    
    private final UIConfig defaultConfig = new UIConfig();
    private UIConfig loadedConfig;
    
    public UIConfig nickJoystickConfig;
    public UIConfig nickGamepadConfig;
    
    private static CarbonUI ui;
    
    private CarbonUI() {
        defaultConfig.setDefaultUI();
        loadedConfig = defaultConfig;
        
        j1 = new Joystick(Constants.JOYSTICK1);
        j2 = new Joystick(Constants.JOYSTICK2);
        j3 = new Joystick(Constants.JOYSTICK3);
        j4 = new Joystick(Constants.JOYSTICK4);
    }
    
    public static CarbonUI getUI() {
        if(ui == null) {
            ui = new CarbonUI();
        }
        return ui;
    }
    
    public void setConfig(UIConfig config) {
        if(config != null) {
            this.loadedConfig = config;
        }
    }
    
    public void setConfigDefault() {
        loadedConfig = defaultConfig;
    }
    
    public UIConfig getConfig() {
        return loadedConfig;
    }
    
    public Joystick getJoystick(int usb) {
        if (usb == 1) {
            return j1;
        } else if (usb == 2) {
            return j2;
        } else if (usb == 3) {
            return j3;
        } else if (usb == 4) {
            return j4;
        } else {
            return null;
        }
    }
    
    public void initUIConfigs() {
        /*
         * NICK JOYSTICK CONFIG
         */
        nickJoystickConfig = new UIConfig();
        //Button IDs
        nickJoystickConfig.setThrowButtonID(1);
        nickJoystickConfig.setUnloadButtonID(2);
        nickJoystickConfig.setShiftButtonID(6);
        nickJoystickConfig.setPivotForwardButtonID(8);
        nickJoystickConfig.setPivotReverseButtonID(7);
        nickJoystickConfig.setPivotPIDButtonID(5);
        nickJoystickConfig.setPivotResetButtonID(9);
        //Button Ports
        nickJoystickConfig.setThrowButtonPort(1);
        nickJoystickConfig.setUnloadButtonPort(1);
        nickJoystickConfig.setPivotForwardButtonPort(1);
        nickJoystickConfig.setPivotReverseButtonPort(1);
        nickJoystickConfig.setPivotPIDButtonPort(1);
        nickJoystickConfig.setShiftButtonPort(1);
        nickJoystickConfig.setPivotResetButtonPort(1);
        nickJoystickConfig.setAutoSwitchLaunchButtonPort(1);
        nickJoystickConfig.setAutoSwitchIncrementButtonPort(1);
        nickJoystickConfig.setAutoSwitchDecrementButtonPort(1);
        //Axis IDs
        nickJoystickConfig.setDriveArcadeXAxisID(3);
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
        nickGamepadConfig.setThrowButtonID(1);
        nickGamepadConfig.setUnloadButtonID(4);
        nickGamepadConfig.setPivotForwardButtonID(8);
        nickGamepadConfig.setPivotReverseButtonID(7);
        nickGamepadConfig.setIntakeForwardButtonID(6);
        nickGamepadConfig.setIntakeReverseButtonID(5);
        //Button Ports
        nickGamepadConfig.setThrowButtonPort(1);
        nickGamepadConfig.setUnloadButtonPort(1);
        nickGamepadConfig.setPivotForwardButtonPort(1);
        nickGamepadConfig.setPivotReverseButtonPort(1);
        nickGamepadConfig.setIntakeForwardButtonPort(1);
        nickGamepadConfig.setIntakeReverseButtonPort(1);
        //Axis IDs
        nickGamepadConfig.setDriveArcadeXAxisID(3);
        nickGamepadConfig.setDriveArcadeYAxisID(2);
        //Axis Ports
        nickGamepadConfig.setDriveArcadeXAxisPort(1);
        nickGamepadConfig.setDriveArcadeYAxisPort(1);
    }
    
    public boolean getPivotForwardButtonState() {
        if(getConfig().getPivotForwardButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Pivot Forward Button Port not defined for current config!");
            return false;
        } else if(getConfig().getPivotForwardButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Pivot Forward Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getPivotForwardButtonPort()).getRawButton(getConfig().getPivotForwardButtonID());
    }
    
    public boolean getPivotReverseButtonState() {
        if(getConfig().getPivotReverseButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Pivot Reverse Button Port not defined for current config!");
            return false;
        } else if(getConfig().getPivotReverseButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Pivot Reverse Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getPivotReverseButtonPort()).getRawButton(getConfig().getPivotReverseButtonID());
    }
    
    public boolean getPivotResetButtonState() {
        if(getConfig().getPivotResetButtonPort() == -1){
            System.err.println("[CarbonUI|ERROR] Pivot Reset Button Port not defined for current config!");
            return false;
        } else if (getConfig().getPivotResetButtonID() == -1) {
            System.err.println("[CarbonUI|Error] Pivot Reset Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getPivotResetButtonPort()).getRawButton(getConfig().getPivotResetButtonID());
    }
    
    public boolean getPivotPIDButtonState() {
        if(getConfig().getPivotPIDButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Pivot PID Button Port not defined for current config!");
            return false;
        } else if(getConfig().getPivotPIDButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Pivot PID Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getPivotPIDButtonPort()).getRawButton(getConfig().getPivotPIDButtonID());
    }
    
    public boolean getInvertDriveButtonState() {
        if(getConfig().getInvertDriveButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] InvertDrive Button Port not defined for current config!");
            return false;
        } else if(getConfig().getInvertDriveButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] InvertDrive Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getInvertDriveButtonID()).getRawButton(getConfig().getInvertDriveButtonID());
    }
    
    public boolean getIntakeForwardButtonState() {
        if(getConfig().getIntakeForwardButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Intake Forward Button Port not defined for current config!");
            return false;
        } else if(getConfig().getIntakeForwardButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Intake Forward Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getIntakeForwardButtonPort()).getRawButton(getConfig().getIntakeForwardButtonID());
    }
    
    public boolean getIntakeReverseButtonState() {
        if(getConfig().getIntakeForwardButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Intake Reverse Button Port not defined for current config!");
            return false;
        } else if(getConfig().getIntakeForwardButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Intake Reverse Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getIntakeForwardButtonPort()).getRawButton(getConfig().getIntakeForwardButtonID());
    }
    
    public boolean getShiftButtonState() {
        if(getConfig().getShiftButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Shift Button Port not defined for current config!");
            return false;
        } else if(getConfig().getShiftButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Shift Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getShiftButtonPort()).getRawButton(getConfig().getShiftButtonID());
    }
    
    public boolean getThrowButtonState() {
        if(getConfig().getThrowButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Throw Button Port not defined for current config!");
            return false;
        } else if(getConfig().getThrowButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Throw Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getThrowButtonPort()).getRawButton(getConfig().getThrowButtonID());
    }
    
    public boolean getUnloadButtonState() {
        if(getConfig().getUnloadButtonPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Unload Button Port not defined for current config!");
            return false;
        } else if(getConfig().getUnloadButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Unload Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getUnloadButtonPort()).getRawButton(getConfig().getUnloadButtonID());
    }
    
    public boolean getAutoSwitchIncrementButtonState() {
        if(getConfig().getAutoSwitchIncrementButtonPort()== -1) {
            System.err.println("[CarbonUI|ERROR] Auto Switcher Increment Button Port not defined for current config!");
            return false;
        } else if(getConfig().getAutoSwitchIncrementButtonID() == -1) {
            System.err.println("[CarbonUI|ERROR] Auto Switcher Increment Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getAutoSwitchIncrementButtonPort()).getRawButton(getConfig().getAutoSwitchIncrementButtonID());
    }
    
    public boolean getAutoSwitchDecrementButtonState() {
        if(getConfig().getAutoSwitchDecrementButtonPort()== -1) {
            System.err.println("[CarbonUI|ERROR] Auto Switcher Decrement Button Port not defined for current config!");
            return false;
        } else if(getConfig().getAutoSwitchDecrementButtonID()== -1) {
            System.err.println("[CarbonUI|ERROR] Auto Switcher Decrement Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getAutoSwitchDecrementButtonPort()).getRawButton(getConfig().getAutoSwitchDecrementButtonID());
    }
    
    public boolean getAutoSwitchLaunchButtonState() {
        if(getConfig().getAutoSwitchLaunchButtonPort()== -1) {
            System.err.println("[CarbonUI|ERROR] Auto Switcher Launch Button Port not defined for current config!");
            return false;
        } else if(getConfig().getAutoSwitchLaunchButtonID()== -1) {
            System.err.println("[CarbonUI|ERROR] Auto Switcher Launch Button ID not defined for current config!");
            return false;
        }
        return getJoystick(getConfig().getAutoSwitchLaunchButtonPort()).getRawButton(getConfig().getAutoSwitchLaunchButtonID());
    }
    
    public double getDriveArcadeXAxis() {
        if(getConfig().getDriveArcadeXAxisPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Arcade X Axis Port not defined for current config!");
            return 0.0;
        } else if(getConfig().getDriveArcadeXAxisID() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Arcade X Axis ID not defined for current config!");
            return 0.0;
        }
        return (Constants.AXIS_ARCADEX_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveArcadeXAxisPort())
                .getRawAxis(getConfig().getDriveArcadeXAxisID());
    }
    
    public double getDriveArcadeYAxis() {
        if(getConfig().getDriveArcadeYAxisPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Arcade Y Axis Port not defined for current config!");
            return 0.0;
        } else if(getConfig().getDriveArcadeYAxisID() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Arcade Y Axis ID not defined for current config!");
            return 0.0;
        }
        return (Constants.AXIS_ARCADEY_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveArcadeYAxisPort())
                .getRawAxis(getConfig().getDriveArcadeYAxisID());
    }
    
    public double getDriveTankLeftAxis() {
        if(getConfig().getDriveTankLeftAxisPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Tank Left Axis Port not defined for current config!");
            return 0.0;
        } else if(getConfig().getDriveTankLeftAxisID() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Tank Left Axis ID not defined for current config!");
            return 0.0;
        }
        return (Constants.AXIS_TANKLEFT_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveTankLeftAxisPort())
                .getRawAxis(getConfig().getDriveTankLeftAxisID());
    }
    
    public double getDriveTankRightAxis() {
        if(getConfig().getDriveTankRightAxisPort() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Tank Right Axis Port not defined for current config!");
            return 0.0;
        } else if(getConfig().getDriveTankRightAxisID() == -1) {
            System.err.println("[CarbonUI|ERROR] Drive Tank Right Axis ID not defined for current config!");
            return 0.0;
        }
        return (Constants.AXIS_TANKRIGHT_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveTankRightAxisPort())
                .getRawAxis(getConfig().getDriveTankRightAxisID());
    }
    
    /**
     * Template class to store values of Joystick button IDs and ports so that
     * buttons can be sorted by function regardless of which physical device
     * they're on
     * @author Nick
     */
    public class UIConfig {

        private int pivotForwardButtonID = -1;
        private int pivotForwardButtonPort = -1;
        private int pivotReverseButtonID = -1;
        private int pivotReverseButtonPort = -1;
        private int pivotPIDButtonPort = -1;
        private int pivotPIDButtonID = -1;
        private int invertDriveButtonID = -1;
        private int invertDriveButtonPort = -1;
        private int intakeForwardButtonID = -1;
        private int intakeForwardButtonPort = -1;
        private int intakeReverseButtonID = -1;
        private int intakeReverseButtonPort = -1;
        private int intakeResetButtonID = -1;
        private int intakeResetButtonPort = -1; //TODO add full functionality here
        private int shiftButtonID = -1;
        private int shiftButtonPort = -1;
        private int throwButtonID = -1;
        private int throwButtonPort = -1;
        private int unloadButtonID = -1;
        private int unloadButtonPort = -1;
        private int autoSwitchIncrementButtonID = -1;
        private int autoSwitchIncrementButtonPort = -1;
        private int autoSwitchDecrementButtonID = -1;
        private int autoSwitchDecrementButtonPort = -1;
        private int autoSwitchLaunchButtonID = -1;
        private int autoSwitchLaunchButtonPort = -1;

        private int driveArcadeXAxisID = -1;
        private int driveArcadeXPort = -1;
        private int driveArcadeYAxisID = -1;
        private int driveArcadeYPort = -1;
        private int driveTankLeftAxisID = -1;
        private int driveTankLeftPort = -1;
        private int driveTankRightAxisID = -1;
        private int driveTankRightPort = -1;
        private int driveSensitivityAxisID = -1;
        private int driveSensitivityPort = -1;

        /**
         * Default configuration; Intended to be overridden and new values
         * set to reflect each joystick
         */
        public UIConfig() {

        }

        /**
         * Resets all UI variables to the default values specified in Constants.java
         */
        public void setDefaultUI() {
            pivotForwardButtonID = Constants.BUTTON_DEFAULT_PIVOT_FORWARD;
            pivotForwardButtonPort = 1;
            pivotReverseButtonID = Constants.BUTTON_DEFAULT_PIVOT_REVERSE;
            pivotReverseButtonPort = 1;
            invertDriveButtonID = Constants.BUTTON_DEFAULT_INVERT_DRIVE;
            invertDriveButtonPort = 1;
            intakeForwardButtonID = Constants.BUTTON_DEFAULT_INTAKE;
            intakeForwardButtonPort = 1;
            shiftButtonID = Constants.BUTTON_DEFAULT_SHIFT;
            shiftButtonPort = 1;
            throwButtonID = Constants.BUTTON_DEFAULT_THROW;
            throwButtonPort = 1;
            unloadButtonID = Constants.BUTTON_DEFAULT_UNLOAD;
            unloadButtonPort = 1;
        }

        /**
         * Returns the ID of the Forward Pivot Button, as represented on the USB
         * handheld controller to which the Forward Pivot Button is assigned.
         * @return the integer ID of the Forward Pivot Button
         */
        public int getPivotForwardButtonID() {
            return pivotForwardButtonID;
        }

        /**
         * Set a new hardware ID for the Forward Pivot Button, which correlates to 
         * the USB handheld controller on which the Forward Pivot Button exists.
         * @param pivotForwardButtonID New hardware ID for the Forward Pivot Button
         */
        public void setPivotForwardButtonID(int pivotForwardButtonID) {
            this.pivotForwardButtonID = pivotForwardButtonID;
        }

        /**
         * Returns the Port of the USB handheld controller on which the Forward
         * Pivot Button exists.
         * @return The USB Port which the Forward Pivot Button is on.
         */
        public int getPivotForwardButtonPort() {
            return pivotForwardButtonPort;
        }

        /**
         * Set the USB port of the handheld controller on which the Forward Pivot
         * Button is located.
         * @param forwardButtonPort 
         */
        public void setPivotForwardButtonPort(int forwardButtonPort) {
            this.pivotForwardButtonPort = forwardButtonPort;
        }

        public int getPivotReverseButtonID() {
            return pivotReverseButtonID;
        }

        public void setPivotReverseButtonID(int reverseButtonID) {
            this.pivotReverseButtonID = reverseButtonID;
        }

        public int getPivotReverseButtonPort() {
            return pivotReverseButtonPort;
        }

        public void setPivotReverseButtonPort(int reverseButtonPort) {
            this.pivotReverseButtonPort = reverseButtonPort;
        }

        public int getInvertDriveButtonID() {
            return invertDriveButtonID;
        }

        public void setInvertDriveButtonID(int invertDriveButtonID) {
            this.invertDriveButtonID = invertDriveButtonID;
        }

        public int getInvertDriveButtonPort() {
            return invertDriveButtonPort;
        }

        public void setInvertDriveButtonPort(int invertDriveButtonPort) {
            this.invertDriveButtonPort = invertDriveButtonPort;
        }

        public int getIntakeForwardButtonID() {
            return intakeForwardButtonID;
        }

        public void setIntakeForwardButtonID(int intakeButtonID) {
            this.intakeForwardButtonID = intakeButtonID;
        }

        public int getIntakeForwardButtonPort() {
            return intakeForwardButtonPort;
        }

        public void setIntakeForwardButtonPort(int intakeButtonPort) {
            this.intakeForwardButtonPort = intakeButtonPort;
        }

        public int getIntakeReverseButtonID() {
            return intakeReverseButtonID;
        }

        public void setIntakeReverseButtonID(int intakeButtonID) {
            this.intakeReverseButtonID = intakeButtonID;
        }

        public int getIntakeReverseButtonPort() {
            return intakeReverseButtonPort;
        }

        public void setIntakeReverseButtonPort(int intakeButtonPort) {
            this.intakeReverseButtonPort = intakeButtonPort;
        }

        public int getPivotResetButtonID() {
            return intakeResetButtonID;
        }

        public void setPivotResetButtonID(int intakeResetButtonID) {
            this.intakeResetButtonID = intakeResetButtonID;
        }

        public int getPivotResetButtonPort() {
            return intakeResetButtonPort;
        }

        public void setPivotResetButtonPort(int intakeResetButtonPort) {
            this.intakeResetButtonPort = intakeResetButtonPort;
        }

        public int getShiftButtonID() {
            return shiftButtonID;
        }

        public void setShiftButtonID(int shiftButtonID) {
            this.shiftButtonID = shiftButtonID;
        }

        public int getShiftButtonPort() {
            return shiftButtonPort;
        }

        public void setShiftButtonPort(int shiftButtonPort) {
            this.shiftButtonPort = shiftButtonPort;
        }

        public int getThrowButtonID() {
            return throwButtonID;
        }

        public void setThrowButtonID(int throwButtonID) {
            this.throwButtonID = throwButtonID;
        }

        public int getThrowButtonPort() {
            return throwButtonPort;
        }

        public void setThrowButtonPort(int throwButtonPort) {
            this.throwButtonPort = throwButtonPort;
        }

        public int getUnloadButtonID() {
            return unloadButtonID;
        }

        public void setUnloadButtonID(int unloadButtonID) {
            this.unloadButtonID = unloadButtonID;
        }

        public int getUnloadButtonPort() {
            return unloadButtonPort;
        }

        public void setUnloadButtonPort(int unloadButtonPort) {
            this.unloadButtonPort = unloadButtonPort;
        }

        public int getDriveArcadeXAxisID() {
            return driveArcadeXAxisID;
        }

        public void setDriveArcadeXAxisID(int driveArcadeXAxisID) {
            this.driveArcadeXAxisID = driveArcadeXAxisID;
        }

        public int getDriveArcadeXAxisPort() {
            return driveArcadeXPort;
        }

        public void setDriveArcadeXAxisPort(int driveArcadeXPort) {
            this.driveArcadeXPort = driveArcadeXPort;
        }

        public int getDriveArcadeYAxisID() {
            return driveArcadeYAxisID;
        }

        public void setDriveArcadeYAxisID(int driveArcadeYAxisID) {
            this.driveArcadeYAxisID = driveArcadeYAxisID;
        }

        public int getDriveArcadeYAxisPort() {
            return driveArcadeYPort;
        }

        public void setDriveArcadeYAxisPort(int driveArcadeYPort) {
            this.driveArcadeYPort = driveArcadeYPort;
        }

        public int getDriveTankLeftAxisID() {
            return driveTankLeftAxisID;
        }

        public void setDriveTankLeftAxisID(int driveTankLeftAxisID) {
            this.driveTankLeftAxisID = driveTankLeftAxisID;
        }

        public int getDriveTankLeftAxisPort() {
            return driveTankLeftPort;
        }

        public void setDriveTankLeftAxisPort(int driveTankLeftPort) {
            this.driveTankLeftPort = driveTankLeftPort;
        }

        public int getDriveTankRightAxisID() {
            return driveTankRightAxisID;
        }

        public void setDriveTankRightAxisID(int driveTankRightAxisID) {
            this.driveTankRightAxisID = driveTankRightAxisID;
        }

        public int getDriveTankRightAxisPort() {
            return driveTankRightPort;
        }

        public void setDriveTankRightPort(int driveTankRightPort) {
            this.driveTankRightPort = driveTankRightPort;
        }

        public int getDriveSensitivityAxisID() {
            return driveSensitivityAxisID;
        }

        public void setDriveSensitivityAxisID(int driveSensitivityAxisID) {
            this.driveSensitivityAxisID = driveSensitivityAxisID;
        }

        public int getDriveSensitivityPort() {
            return driveSensitivityPort;
        }

        public void setDriveSensitivityPort(int driveSensitivityPort) {
            this.driveSensitivityPort = driveSensitivityPort;
        }

        public int getPivotPIDButtonPort() {
            return pivotPIDButtonPort;
        }
        public void setPivotPIDButtonPort(int pivotPIDButtonPort) {
            this.pivotPIDButtonPort = pivotPIDButtonPort;
        }

        public int getPivotPIDButtonID() {
            return pivotPIDButtonID;
        }

        public void setPivotPIDButtonID(int pivotPIDButtonID) {
            this.pivotPIDButtonID = pivotPIDButtonID;
        }

        public void setAutoSwitchIncrementButtonID(int autoSwitchButtonID) {
            this.autoSwitchIncrementButtonID = autoSwitchButtonID;
        }

        public void setAutoSwitchIncrementButtonPort(int autoSwitchButtonPort) {
            this.autoSwitchIncrementButtonPort = autoSwitchButtonPort;
        }

        public int getAutoSwitchDecrementButtonID() {
            return autoSwitchDecrementButtonID;
        }

        public void setAutoSwitchDecrementButtonID(int autoSwitchDecrementButtonID) {
            this.autoSwitchDecrementButtonID = autoSwitchDecrementButtonID;
        }

        public int getAutoSwitchDecrementButtonPort() {
            return autoSwitchDecrementButtonPort;
        }

        public void setAutoSwitchDecrementButtonPort(int autoSwitchDecrementButtonPort) {
            this.autoSwitchDecrementButtonPort = autoSwitchDecrementButtonPort;
        }

        public int getAutoSwitchIncrementButtonID() {
            return autoSwitchIncrementButtonID;
        }

        public int getAutoSwitchIncrementButtonPort() {
            return autoSwitchIncrementButtonPort;
        }

        public int getAutoSwitchLaunchButtonID() {
            return autoSwitchLaunchButtonID;
        }

        public void setAutoSwitchLaunchButtonID(int autoSwitchLaunchButtonID) {
            this.autoSwitchLaunchButtonID = autoSwitchLaunchButtonID;
        }

        public int getAutoSwitchLaunchButtonPort() {
            return autoSwitchLaunchButtonPort;
        }

        public void setAutoSwitchLaunchButtonPort(int autoSwitchLaunchButtonPort) {
            this.autoSwitchLaunchButtonPort = autoSwitchLaunchButtonPort;
        }
    }
}