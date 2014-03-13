/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.util;

import com.carbonauts.frc2014.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author Nick
 */
public class CarbonJoystick extends Joystick {
    public CarbonJoystick(int port) {
        super(port);
    }
    
    public boolean getArmForwardButtonState() {
        return this.getRawButton(Constants.BUTTON_ARM_FORWARD);
    }
    
    public JoystickButton getArmForwardButton() {
        return new JoystickButton(this, Constants.BUTTON_ARM_FORWARD);
    }
    
    public boolean getArmRestingButtonState() {
        return this.getRawButton(Constants.BUTTON_ARM_RESTING);
    }
    
    public JoystickButton getArmRestingButton() {
        return new JoystickButton(this, Constants.BUTTON_ARM_RESTING);
    }
    
    public boolean getArmReverseButtonState() {
        return this.getRawButton(Constants.BUTTON_ARM_REVERSE);
    }
    
    public JoystickButton getArmReverseButton() {
        return new JoystickButton(this, Constants.BUTTON_ARM_REVERSE);
    }
    
    public boolean getInvertDriveButtonState() {
        return this.getRawButton(Constants.BUTTON_INVERT_DRIVE);
    }
    
    public JoystickButton getInvertDriveButton() {
        return new JoystickButton(this, Constants.BUTTON_INVERT_DRIVE);
    }
    
    public boolean getRollerButtonState() {
        return this.getRawButton(Constants.BUTTON_ROLLERS_ON);
    }
    
    public JoystickButton getRollerButton() {
        return new JoystickButton(this, Constants.BUTTON_ROLLERS_ON);
    }
    
    public boolean getShiftButtonState() {
        return this.getRawButton(Constants.BUTTON_SHIFT);
    }
    
    public JoystickButton getShiftButton() {
        return new JoystickButton(this, Constants.BUTTON_SHIFT);
    }
    
    public boolean getThrowButtonState() {
        return this.getRawButton(Constants.BUTTON_THROW);
    }
    
    public JoystickButton getThrowButton() {
        return new JoystickButton(this, Constants.BUTTON_THROW);
    }
    
    public boolean getUnloadButtonState() {
        return this.getRawButton(Constants.BUTTON_UNLOAD);
    }
    
    public JoystickButton getUnloadButton() {
        return new JoystickButton(this, Constants.BUTTON_UNLOAD);
    }
}