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
    
    /**
     * Value which represents an unassigned control element
     */
    private static final int UNINITIALIZED = -1;
    
    /**
     * USB port for Joystick 1
     */
    public static final int JOYSTICK1 = 1;
    
    /**
     * USB port for Joystick 2
     */
    public static final int JOYSTICK2 = 2;
    
    /**
     * USB port for Joystick 3
     */
    public static final int JOYSTICK3 = 3;
    
    /**
     * USB port for Joystick 4
     */
    public static final int JOYSTICK4 = 4;
    
    /**
     * Joystick object for Joystick 1
     */
    private final Joystick j1;
    
    /**
     * Joystick object for Joystick 2
     */
    private final Joystick j2;
    
    /**
     * Joystick object for Joystick 3
     */
    private final Joystick j3;
    
    /**
     * Joystick object for Joystick 4
     */
    private final Joystick j4;
    
    /**
     * UIConfig object which holds default values to use in the case that
     * no custom values are assigned.
     */
    private final UIConfig defaultConfig = new UIConfig();
    
    /**
     * A UIConfig object which holds the values of the current controller
     * values to use.  This is initialized as an equivalent object to
     * 'defaultConfig'.
     */
    private UIConfig loadedConfig;
    
    /**
     * Nick's personal favorite configuration for use with a joystick.
     */
    public static UIConfig nickJoystickConfig;
    
    /**
     * Nick's personal favorite configuration for use with a gamepad.
     */
    public static UIConfig nickGamepadConfig;
    
    /**
     * Nick's personal favorite configuration for use with an Xbox controller.
     */
    public static UIConfig nickXboxConfig;
    
    /**
     * A static reference to THIS class.  This class uses the "Singleton"
     * pattern of instantiation, where only one static object is created and it
     * is stored by the class itself as a static reference (in this case, 'ui').
     * All references to this object are obtained through 'getUI()'.
     */
    private static CarbonUI ui;
    
    /**
     * A private constructor which is called by the 'getUI()' method if an
     * instance of 'ui' does not already exist.  This initializes the 
     * 'defaultConfig' to the default settings and then assigns that value to
     * the 'loadedConfig', which is retained through execution until it is
     * explicitly changed.
     */
    private CarbonUI() {
        defaultConfig.setDefaultUI();
        loadedConfig = defaultConfig;
        
        j1 = new Joystick(JOYSTICK1);
        j2 = new Joystick(JOYSTICK2);
        j3 = new Joystick(JOYSTICK3);
        j4 = new Joystick(JOYSTICK4);
    }
    
    /**
     * Creates an instance of THIS class and stores it in a static reference
     * unless the static reference already exists.  If this is the case, then
     * this method returns the existing static reference. (Singleton pattern)
     * @return The static reference to THIS class.
     */
    public static CarbonUI getUI() {
        if(ui == null) {
            ui = new CarbonUI();
        }
        return ui;
    }
    
    /**
     * Overwrites the currently 'loadedConfig' with a new instance of UIConfig,
     * thus implementing new settings as defined by the new instance.
     * @param config The new configuration for the User Interface.
     */
    public void setConfig(UIConfig config) {
        if(config != null) {
            this.loadedConfig = config;
        }
    }
    
    /**
     * Sets the currently 'loadedConfig' back to the default configuration.
     */
    public void setConfigDefault() {
        loadedConfig = defaultConfig;
    }
    
    /**
     * Returns the instance of the currently 'loadedConfig' object from which
     * settings are currently being read.
     * @return The currently 'loadedConfig' object from which settings are
     * currently being read.
     */
    public UIConfig getConfig() {
        return loadedConfig;
    }
    
    /**
     * Method which returns a Joystick object reference based on the USB port
     * of the Joystick.
     * @param usb The USB port of the Joystick.
     * @return The Joystick object reference of the Joystick at USB port 'usb'.
     */
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
    
    /**
     * Prints an error when a control has an undefined USB port or ID.
     * @param control The name of the control (and the undefined property).
     */
    public void undefinedError(String control) {
        if(Constants.DEBUG_UI) {
            System.err.println("[CarbonUI|ERROR] " + control + " not defined for current config!");
        }
    }
    
    /**
     * Prints the status of all buttons on the controller at the specified USB
     * port.
     * @param port The USB port of the controller to read.
     */
    public void readControllerButtons(int port) {
        if(port < 0 || port > 4) {
            System.out.println("Port out of bounds!");
            return;
        }
        System.out.print("P:" + port);
        System.out.print(" Buttons:");
        for(int i = 1; i <= 12; i++) {
            System.out.print(" " + i + ":");
            System.out.print(getJoystick(port).getRawButton(i) ? "T" : "F");
        }
        System.out.println();
    }
    
    /**
     * Prints the status of all axes on the controller at the specified USB
     * port.
     * @param port The USB port of the controller to read.
     */
    public void readControllerAxes(int port) {
        if(port < 0 || port > 4) {
            System.out.println("Port out of bounds!");
            return;
        }
        System.out.print("P:" + port);
        System.out.println(" Axes:");
        for(int i = 1; i <= 6; i++) {
            System.out.print(" " + i + ":");
            System.out.print(getJoystick(port).getRawAxis(i));
        }
        System.out.println();
    }
    
    /**
     * Since the UIConfig class is defined inside of CarbonUI, UIConfig objects
     * cannot be constructed until the CarbonUI object has completed its own
     * construction.  Because of this, instances of UIConfig cannot be created
     * in the constructor of CarbonUI and therefore need a separate place to be
     * initiated (which is here).
     */
    public void initUIConfigs() {
        /*
         * NICK JOYSTICK CONFIG
         */
        nickJoystickConfig = new UIConfig();
        nickJoystickConfig.getThrow().set(JOYSTICK1, 1);
        nickJoystickConfig.getUnload().set(JOYSTICK1, 2);
        nickJoystickConfig.getShift().set(JOYSTICK1, 6);
        nickJoystickConfig.getPivotForward().set(JOYSTICK1, 8);
        nickJoystickConfig.getPivotReverse().set(JOYSTICK1, 7);
        nickJoystickConfig.getZeroPivotEncoder().set(JOYSTICK1, 5);
        nickJoystickConfig.getArcadeX().set(JOYSTICK1, 3);
        nickJoystickConfig.getArcadeY().set(JOYSTICK1, 2);
        nickJoystickConfig.getTankLeft().set(JOYSTICK1, 3);
        nickJoystickConfig.getTankRight().set(JOYSTICK1, 4);
        
        /*
         * NICK GAMEPAD CONFIG
         */
        nickGamepadConfig = new UIConfig();
        nickGamepadConfig.getThrow().set(JOYSTICK1, 1);
        nickGamepadConfig.getUnload().set(JOYSTICK1, 4);
        nickGamepadConfig.getPivotForward().set(JOYSTICK1, 8);
        nickGamepadConfig.getPivotReverse().set(JOYSTICK1, 7);
        nickGamepadConfig.getIntakeForward().set(JOYSTICK1, 6);
        nickGamepadConfig.getIntakeReverse().set(JOYSTICK1, 5);
        nickGamepadConfig.getAutoLaunch().set(JOYSTICK1, 9);
        nickGamepadConfig.getArcadeX().set(JOYSTICK1, 3);
        nickGamepadConfig.getArcadeY().set(JOYSTICK1, 2);
        
        /*
         * NICK XBOX CONFIG
         */
        nickXboxConfig = new UIConfig();
        nickXboxConfig.getThrow().set(JOYSTICK1, 1);
        nickXboxConfig.getUnload().set(JOYSTICK1, 3);
        nickXboxConfig.getPivotForward().set(JOYSTICK1, 6);
        nickXboxConfig.getPivotReverse().set(JOYSTICK1, 5);
        nickXboxConfig.getIntakeForward().set(JOYSTICK1, 4);
        nickXboxConfig.getIntakeReverse().set(JOYSTICK1, 2);
        nickXboxConfig.getArcadeX().set(JOYSTICK1, 4);
        nickXboxConfig.getArcadeY().set(JOYSTICK1, 2);
    }
    
    /**
     * Returns the boolean state of the Pivot Forward button.
     * @return The boolean state of the Pivot Forward button.
     */
    public boolean getPivotForwardButtonState() {
        if(getConfig().getPivotForward().getPort() == UNINITIALIZED) {
            undefinedError("Pivot Forward Button Port");
            return false;
        } else if(getConfig().getPivotForward().getID() == UNINITIALIZED) {
            undefinedError("Pivot Forward Button ID");
            return false;
        }
        return getJoystick(getConfig().getPivotForward().getPort()).getRawButton(getConfig().getPivotForward().getID());
    }
    
    /**
     * Returns the boolean state of the Pivot Reverse button.
     * @return The boolean state of the Pivot Reverse button.
     */
    public boolean getPivotReverseButtonState() {
        if(getConfig().getPivotReverse().getPort() == UNINITIALIZED) {
            undefinedError("Pivot Reverse Button Port");
            return false;
        } else if(getConfig().getPivotReverse().getID() == UNINITIALIZED) {
            undefinedError("Pivot Reverse Button ID");
            return false;
        }
        return getJoystick(getConfig().getPivotReverse().getPort()).getRawButton(getConfig().getPivotReverse().getID());
    }
    
    /**
     * Returns the boolean state of the Pivot PID button.
     * @return The boolean state of the Pivot PID button.
     */
    public boolean getZeroPivotEncoderButtonState() {
        if(getConfig().getZeroPivotEncoder().getPort() == UNINITIALIZED) {
            undefinedError("Pivot PID Button Port");
            return false;
        } else if(getConfig().getZeroPivotEncoder().getID() == UNINITIALIZED) {
            undefinedError("Pivot PID Button ID");
            return false;
        }
        return getJoystick(getConfig().getZeroPivotEncoder().getPort()).getRawButton(getConfig().getZeroPivotEncoder().getID());
    }
    
    /**
     * Returns the boolean state of the Invert Drive button.
     * @return The boolean state of the Invert Drive button.
     */
    public boolean getInvertDriveButtonState() {
        if(getConfig().getInvertDrive().getPort() == UNINITIALIZED) {
            undefinedError("Invert Drive Button Port");
            return false;
        } else if(getConfig().getInvertDrive().getID() == UNINITIALIZED) {
            undefinedError("Invert Drive Button ID");
            return false;
        }
        return getJoystick(getConfig().getInvertDrive().getPort()).getRawButton(getConfig().getInvertDrive().getID());
    }
    
    /**
     * Returns the boolean state of the Intake Forward button.
     * @return The boolean state of the Intake Forward button.
     */
    public boolean getIntakeForwardButtonState() {
        if(getConfig().getIntakeForward().getPort() == UNINITIALIZED) {
            undefinedError("Intake Forward Button Port");
            return false;
        } else if(getConfig().getIntakeForward().getID() == UNINITIALIZED) {
            undefinedError("Intake Forward Button ID");
            return false;
        }
        return getJoystick(getConfig().getIntakeForward().getPort()).getRawButton(getConfig().getIntakeForward().getID());
    }
    
    /**
     * Returns the boolean state of the Intake Reverse button.
     * @return The boolean state of the Intake Reverse button.
     */
    public boolean getIntakeReverseButtonState() {
        if(getConfig().getIntakeReverse().getPort() == UNINITIALIZED) {
            undefinedError("Intake Reverse Button Port");
            return false;
        } else if(getConfig().getIntakeReverse().getID() == UNINITIALIZED) {
            undefinedError("Intake Reverse Button ID");
            return false;
        }
        return getJoystick(getConfig().getIntakeReverse().getPort()).getRawButton(getConfig().getIntakeReverse().getID());
    }
    
    /**
     * Returns the boolean state of the Shift button.
     * @return The boolean state of the Shift button.
     */
    public boolean getShiftButtonState() {
        if(getConfig().getShift().getPort() == UNINITIALIZED) {
            undefinedError("Shift Button Port");
            return false;
        } else if(getConfig().getShift().getID() == UNINITIALIZED) {
            undefinedError("Shift Button ID");
            return false;
        }
        return getJoystick(getConfig().getShift().getPort()).getRawButton(getConfig().getShift().getID());
    }
    
    /**
     * Returns the boolean state of the Throw button.
     * @return The boolean state of the Throw button.
     */
    public boolean getThrowButtonState() {
        if(getConfig().getThrow().getPort() == UNINITIALIZED) {
            undefinedError("Throw Button Port");
            return false;
        } else if(getConfig().getThrow().getID() == UNINITIALIZED) {
            undefinedError("Throw Button ID");
            return false;
        }
        return getJoystick(getConfig().getThrow().getPort()).getRawButton(getConfig().getThrow().getID());
    }
    
    /**
     * Returns the boolean state of the Unload button.
     * @return The boolean state of the Unload button.
     */
    public boolean getUnloadButtonState() {
        if(getConfig().getUnload().getPort() == UNINITIALIZED) {
            undefinedError("Unload Button Port");
            return false;
        } else if(getConfig().getUnload().getID() == UNINITIALIZED) {
            undefinedError("Unload Button ID");
            return false;
        }
        return getJoystick(getConfig().getUnload().getPort()).getRawButton(getConfig().getUnload().getID());
    }
    
    public boolean getAutoLaunchButtonState() {
        if(getConfig().getAutoLaunch().getPort() == UNINITIALIZED) {
            undefinedError("AutoLaunch Button Port");
            return false;
        } else if(getConfig().getAutoLaunch().getID() == UNINITIALIZED) {
            undefinedError("AutoLaunch Button ID");
            return false;
        }
        return getJoystick(getConfig().getAutoLaunch().getPort()).getRawButton(getConfig().getAutoLaunch().getID());
    }
    
    /**
     * Returns the raw axis value of the Arcade X axis.
     * @return The raw axis value of the Arcade X axis.
     */
    public double getDriveArcadeXAxis() {
        if(getConfig().getArcadeX().getPort() == UNINITIALIZED) {
            undefinedError("Arcade X Port");
            return 0.0;
        } else if(getConfig().getArcadeX().getID() == UNINITIALIZED) {
            undefinedError("Arcade X ID");
            return 0.0;
        }
        return (Constants.AXIS_ARCADEX_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getArcadeX().getPort())
                .getRawAxis(getConfig().getArcadeX().getID());
    }
    
    /**
     * Returns the raw axis value of the Arcade Y axis.
     * @return The raw axis value of the Arcade Y axis.
     */
    public double getDriveArcadeYAxis() {
        if(getConfig().getArcadeY().getPort() == UNINITIALIZED) {
            undefinedError("Arcade Y Port");
            return 0.0;
        } else if(getConfig().getArcadeY().getID() == UNINITIALIZED) {
            undefinedError("Arcade Y ID");
            return 0.0;
        }
        return (Constants.AXIS_ARCADEY_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getArcadeY().getPort())
                .getRawAxis(getConfig().getArcadeY().getID());
    }
    
    /**
     * Returns the raw axis value of the Tank Left axis.
     * @return The raw axis value of the Tank Left axis.
     */
    public double getDriveTankLeftAxis() {
        if(getConfig().getTankLeft().getPort() == UNINITIALIZED) {
            undefinedError("Tank Left Port");
            return 0.0;
        } else if(getConfig().getTankLeft().getID() == UNINITIALIZED) {
            undefinedError("Tank Left ID");
            return 0.0;
        }
        return (Constants.AXIS_TANKLEFT_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getTankLeft().getPort())
                .getRawAxis(getConfig().getTankLeft().getID());
    }
    
    /**
     * Returns the raw axis value of the Tank Right axis.
     * @return The raw axis value of the Tank Right axis.
     */
    public double getDriveTankRightAxis() {
        if(getConfig().getTankRight().getPort() == UNINITIALIZED) {
            undefinedError("Tank Right Port");
            return 0.0;
        } else if(getConfig().getTankRight().getID()== UNINITIALIZED) {
            undefinedError("Tank Right ID");
            return 0.0;
        }
        return (Constants.AXIS_TANKRIGHT_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getTankRight().getPort())
                .getRawAxis(getConfig().getTankRight().getID());
    }
    
    /**
     * Returns the raw axis value of the Drive Sensitivity axis.
     * @return The raw axis value of the Drive Sensitivity axis.
     */
    public double getDriveSensitivity() {
        if(getConfig().getDriveSensitivity().getPort() == UNINITIALIZED) {
            undefinedError("Drive Sensitivity Port");
            return 1.0;
        } else if(getConfig().getDriveSensitivity().getID() == UNINITIALIZED) {
            undefinedError("Drive Sensitivity ID");
            return 1.0;
        }
        return getJoystick(getConfig().getDriveSensitivity().getPort())
                .getRawAxis(getConfig().getDriveSensitivity().getID());
    }
    
    /**
     * Template class to store values of Joystick button IDs and ports so that
     * buttons can be sorted by function regardless of which physical device
     * they're on.
     * @author Nick
     */
    public class UIConfig {
        public static final int UNINITIALIZED = CarbonUI.UNINITIALIZED;
        
        public static final int PORT1 = 1;
        public static final int PORT2 = 2;
        public static final int PORT3 = 3;
        public static final int PORT4 = 4;
        
        public static final int DEFAULT_PIVOT_FORWARD = 8;
        public static final int DEFAULT_PIVOT_REVERSE = 7;
        public static final int DEFAULT_PIVOT_PID = -1;
        public static final int DEFAULT_INVERT_DRIVE = 7;
        public static final int DEFAULT_INTAKE_FORWARD = 6;
        public static final int DEFAULT_INTAKE_REVERSE = 5;
        public static final int DEFAULT_INTAKE_RESET = 9;
        public static final int DEFAULT_SHIFT = -1;
        public static final int DEFAULT_TOSS = 1;
        public static final int DEFAULT_UNLOAD = 4;
        
        public static final int DEFAULT_ARCADEX = 3;
        public static final int DEFAULT_ARCADEY = 2;
        public static final int DEFAULT_TANK_RIGHT = 4;
        public static final int DEFAULT_TANK_LEFT = 2;
        public static final int DEFAULT_SENSITIVITY = 4;

        private final UIElement pivotForward;
        private final UIElement pivotReverse;
        private final UIElement zeroPivotEncoder;
        private final UIElement invertDrive;
        private final UIElement intakeForward;
        private final UIElement intakeReverse;
        private final UIElement intakeReset;
        private final UIElement shift;
        private final UIElement toss; //Can't call this 'throw' because of java keyword
        private final UIElement unload;
        private final UIElement autoLaunch;
        private final UIElement arcadeX;
        private final UIElement arcadeY;
        private final UIElement tankLeft;
        private final UIElement tankRight;
        private final UIElement driveSensitivity;

        /**
         * All control elements are constructed with an 'UNINITIALIZED' port
         * and ID, that way if a particular control is not defined for a 
         * specific controller, the program can catch that at execution.
         */
        public UIConfig() {
            pivotForward = new UIElement(UNINITIALIZED, UNINITIALIZED);
            pivotReverse = new UIElement(UNINITIALIZED, UNINITIALIZED);
            zeroPivotEncoder = new UIElement(UNINITIALIZED, UNINITIALIZED);
            invertDrive = new UIElement(UNINITIALIZED, UNINITIALIZED);
            intakeForward = new UIElement(UNINITIALIZED, UNINITIALIZED);
            intakeReverse = new UIElement(UNINITIALIZED, UNINITIALIZED);
            intakeReset = new UIElement(UNINITIALIZED, UNINITIALIZED);
            shift = new UIElement(UNINITIALIZED, UNINITIALIZED);
            toss = new UIElement(UNINITIALIZED, UNINITIALIZED);
            unload = new UIElement(UNINITIALIZED, UNINITIALIZED);
            autoLaunch = new UIElement(UNINITIALIZED, UNINITIALIZED);
            
            arcadeX = new UIElement(UNINITIALIZED, UNINITIALIZED);
            arcadeY = new UIElement(UNINITIALIZED, UNINITIALIZED);
            tankLeft = new UIElement(UNINITIALIZED, UNINITIALIZED);
            tankRight = new UIElement(UNINITIALIZED, UNINITIALIZED);
            driveSensitivity = new UIElement(UNINITIALIZED, UNINITIALIZED);
        }

        /**
         * Loads the values specified by the constants in UIConfig into the
         * UIElement objects.  The UIElement objects hold the values which are
         * actively referenced for control information, so setting these to 
         * match the default values in effect resets the controls to the 
         * default.
         */
        public void setDefaultUI() {
            pivotForward.set(PORT1, DEFAULT_PIVOT_FORWARD);
            pivotReverse.set(PORT1, DEFAULT_PIVOT_REVERSE);
            zeroPivotEncoder.set(PORT1, DEFAULT_PIVOT_PID);
            invertDrive.set(PORT1, DEFAULT_INVERT_DRIVE);
            intakeForward.set(PORT1, DEFAULT_INTAKE_FORWARD);
            intakeReverse.set(PORT1, DEFAULT_INTAKE_REVERSE);
            intakeReset.set(PORT1, DEFAULT_INTAKE_RESET);
            shift.set(PORT1, DEFAULT_SHIFT);
            toss.set(PORT1, DEFAULT_TOSS);
            unload.set(PORT1, DEFAULT_UNLOAD);
            
            arcadeX.set(PORT1, DEFAULT_ARCADEX);
            arcadeY.set(PORT1, DEFAULT_ARCADEY);
            tankLeft.set(PORT1, DEFAULT_TANK_LEFT);
            tankRight.set(PORT1, DEFAULT_TANK_RIGHT);
            driveSensitivity.set(PORT1, DEFAULT_SENSITIVITY);
        }
        
        /**
         * Returns the Pivot Forward UIElement.
         * @return The Pivot Forward UIElement.
         */
        public UIElement getPivotForward() {
            return pivotForward;
        }
        
        /**
         * Returns the Pivot Reverse UIElement.
         * @return The Pivot Reverse UIElement.
         */
        public UIElement getPivotReverse() {
            return pivotReverse;
        }
        
        /**
         * Returns the Pivot PID UIElement.
         * @return The Pivot PID UIElement.
         */
        public UIElement getZeroPivotEncoder() {
            return zeroPivotEncoder;
        }
        
        /**
         * Returns the Invert Drive UIElement.
         * @return The Invert Drive UIElement.
         */
        public UIElement getInvertDrive() {
            return invertDrive;
        }
        
        /**
         * Returns the Intake Forward UIElement.
         * @return The Intake Forward UIElement.
         */
        public UIElement getIntakeForward() {
            return intakeForward;
        }
        
        /**
         * Returns the Intake Reverse UIElement.
         * @return The Intake Reverse UIElement.
         */
        public UIElement getIntakeReverse() {
            return intakeReverse;
        }
        
        /**
         * Returns the Intake Reset UIElement.
         * @return The Intake Reset UIElement.
         */
        public UIElement getIntakeReset() {
            return intakeReset;
        }
        
        /**
         * Returns the Shift UIElement.
         * @return The Shift UIElement.
         */
        public UIElement getShift() {
            return shift;
        }
        
        /**
         * Returns the Throw UIElement.
         * @return The Throw UIElement.
         */
        public UIElement getThrow() {
            return toss;
        }
        
        /**
         * Returns the Unload UIElement.
         * @return The Unload UIElement.
         */
        public UIElement getUnload() {
            return unload;
        }
        
        /**
         * Returns the AutoLaunch UIElement.
         * @return the AutoLaunch UIElement.
         */
        public UIElement getAutoLaunch() {
            return autoLaunch;
        }
        
        /**
         * Returns the Arcade X UIElement.
         * @return The Arcade X UIElement.
         */
        public UIElement getArcadeX() {
            return arcadeX;
        }
        
        /**
         * Returns the Arcade Y UIElement.
         * @return The Arcade Y UIElement.
         */
        public UIElement getArcadeY() {
            return arcadeY;
        }
        
        /**
         * Returns the Tank Left UIElement.
         * @return The Tank Left UIElement.
         */
        public UIElement getTankLeft() {
            return tankLeft;
        }
        
        /**
         * Returns the Tank Right UIElement.
         * @return 
         */
        public UIElement getTankRight() {
            return tankRight;
        }
        
        /**
         * Returns the Drive Sensitivity UIElement.
         * @return The Drive Sensitivity UIElement.
         */
        public UIElement getDriveSensitivity() {
            return driveSensitivity;
        }
        
        /**
         * A UIElement represents a source of data from a controller.
         * Each UIElement has a USB port which identifies which controller 
         * the control data originates from, and a controller ID which tells
         * which specific button, thumbstick, slider, or other physical 
         * input from that controller in question.
         */
        public class UIElement {                        
            private int mPort;
            private int mID;
            
            /**
             * @param port The USB port of the controller that this piece of
             * control data is originating from (UIElement.PORT1 through
             * UIElement.PORT4).
             * @param ID The ID of the physical input on the controller that
             * this piece of data is originating from.
             */
            public UIElement (int port, int ID) {
                mPort = port;
                mID = ID;
            }
            
            /**
             * Sets the USB port and the ID of this control element.
             * @param port The USB port of this control element.
             * @param ID  The ID of this control element.
             */
            public void set(int port, int ID) {
                mPort = port;
                mID = ID;
            }

            /**
             * @return The USB port of the control element this object
             * represents.
             */
            public int getPort() {
                return mPort;
            }

            /**
             * @param port The new USB port to which this control element is
             * assigned.
             */
            public void setPort(int port) {
                mPort = port;
            }

            /**
             * @return The ID of the control element this object represents.
             */
            public int getID() {
                return mID;
            }

            /**
             * @param ID The new ID of this control element
             */
            public void setID(int ID) {
                mID = ID;
            }
        }
    }
}