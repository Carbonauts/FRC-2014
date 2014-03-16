/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
    
    public boolean getArmForwardButtonState() {
        return getJoystick(getConfig().getForwardButtonPort()).getRawButton(getConfig().getForwardButtonID());
    }
    
    public JoystickButton getArmForwardButton() {
        return new JoystickButton(getJoystick(getConfig().getForwardButtonPort()), getConfig().getForwardButtonID());
    }
    
    public boolean getArmReverseButtonState() {
        return getJoystick(getConfig().getReverseButtonPort()).getRawButton(getConfig().getReverseButtonID());
    }
    
    public JoystickButton getArmReverseButton() {
        return new JoystickButton(getJoystick(getConfig().getReverseButtonPort()), getConfig().getReverseButtonID());
    }
    
    public boolean getInvertDriveButtonState() {
        return getJoystick(getConfig().getInvertDriveButtonID()).getRawButton(getConfig().getInvertDriveButtonID());
    }
    
    public JoystickButton getInvertDriveButton() {
        return new JoystickButton(getJoystick(getConfig().getInvertDriveButtonPort()), getConfig().getInvertDriveButtonID());
    }
    
    public boolean getIntakeButtonState() {
        return getJoystick(getConfig().getIntakeButtonPort()).getRawButton(getConfig().getIntakeButtonID());
    }
    
    public JoystickButton getIntakeButton() {
        return new JoystickButton(getJoystick(getConfig().getIntakeButtonPort()), getConfig().getIntakeButtonID());
    }
    
    public boolean getShiftButtonState() {
        return getJoystick(getConfig().getShiftButtonPort()).getRawButton(getConfig().getShiftButtonID());
    }
    
    public JoystickButton getShiftButton() {
        return new JoystickButton(getJoystick(getConfig().getShiftButtonPort()), getConfig().getShiftButtonID());
    }
    
    public boolean getThrowButtonState() {
        return getJoystick(getConfig().getThrowButtonPort()).getRawButton(getConfig().getThrowButtonID());
    }
    
    public JoystickButton getThrowButton() {
        return new JoystickButton(getJoystick(getConfig().getThrowButtonPort()), getConfig().getThrowButtonID());
    }
    
    public boolean getUnloadButtonState() {
        return getJoystick(getConfig().getUnloadButtonPort()).getRawButton(getConfig().getUnloadButtonID());
    }
    
    public JoystickButton getUnloadButton() {
        return new JoystickButton(getJoystick(getConfig().getUnloadButtonPort()), getConfig().getUnloadButtonID());
    }
    
    public double getDriveArcadeXAxis() {        
        return (Constants.AXIS_ARCADEX_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveArcadeXAxisPort())
                .getRawAxis(getConfig().getDriveArcadeXAxisID());
    }
    
    public double getDriveArcadeYAxis() {
        return (Constants.AXIS_ARCADEY_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveArcadeYAxisPort())
                .getRawAxis(getConfig().getDriveArcadeYAxisID());
    }
    
    public double getDriveTankLeftAxis() {
        return (Constants.AXIS_TANKLEFT_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveTankLeftAxisPort())
                .getRawAxis(getConfig().getDriveTankLeftAxisID());
    }
    
    public double getDriveTankRightAxis() {
        return (Constants.AXIS_TANKRIGHT_INVERTED ? -1.0 : 1.0) * 
                getJoystick(getConfig().getDriveTankRightAxisPort())
                .getRawAxis(getConfig().getDriveTankRightAxisID());
    }
}