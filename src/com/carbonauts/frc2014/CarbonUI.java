/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Custom Joystick class with adjustable configuration
 * @author Nick
 */
public class CarbonUI {
    
    private final UIConfig defaultConfig = new UIConfig();
    private UIConfig loadedConfig;
    
    private Joystick joystick1;
    private Joystick joystick2;
    private Joystick joystick3;
    private Joystick joystick4;
    
    public CarbonUI() {
        defaultConfig.setDefaultUI();
        loadedConfig = defaultConfig;
        
        joystick1 = new Joystick(Constants.JOYSTICK1);
        joystick2 = new Joystick(Constants.JOYSTICK2);
        joystick3 = new Joystick(Constants.JOYSTICK3);
        joystick4 = new Joystick(Constants.JOYSTICK4);
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
        
        if(usb == Constants.JOYSTICK1) {
            return joystick1;
            
        } else if(usb == Constants.JOYSTICK2) {
            return joystick2;
            
        } else if(usb == Constants.JOYSTICK3) {
            return joystick3;
            
        } else if(usb == Constants.JOYSTICK4) {
            return joystick4;
            
        } else {
            System.err.println("CarbonUI: Created out-of-bounds Joystick!" + usb);
            return null;
        }
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
}