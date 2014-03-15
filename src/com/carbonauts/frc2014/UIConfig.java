/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

/**
 * Template class to store values of Joystick button IDs and ports so that
 * buttons can be sorted by function regardless of which physical device
 * they're on
 * @author Nick
 */
public class UIConfig {

    private int forwardButtonID;
    private int forwardButtonPort;
    private int reverseButtonID;
    private int reverseButtonPort;
    private int invertDriveButtonID;
    private int invertDriveButtonPort;
    private int intakeButtonID;
    private int intakeButtonPort;
    private int shiftButtonID;
    private int shiftButtonPort;
    private int throwButtonID;
    private int throwButtonPort;
    private int unloadButtonID;
    private int unloadButtonPort;

    /**
     * Default configuration; Intended to be overridden and new values
     * set to reflect each joystick
     */
    public UIConfig() {
        
    }
    
    public void setDefaultUI() {
        forwardButtonID = Constants.BUTTON_DEFAULT_PIVOT_FORWARD;
        forwardButtonPort = 1;
        reverseButtonID = Constants.BUTTON_DEFAULT_PIVOT_REVERSE;
        reverseButtonPort = 1;
        invertDriveButtonID = Constants.BUTTON_DEFAULT_INVERT_DRIVE;
        invertDriveButtonPort = 1;
        intakeButtonID = Constants.BUTTON_DEFAULT_INTAKE;
        intakeButtonPort = 1;
        shiftButtonID = Constants.BUTTON_DEFAULT_SHIFT;
        shiftButtonPort = 1;
        throwButtonID = Constants.BUTTON_DEFAULT_THROW;
        throwButtonPort = 1;
        unloadButtonID = Constants.BUTTON_DEFAULT_UNLOAD;
        unloadButtonPort = 1;
    }

    public int getForwardButtonID() {
        return forwardButtonID;
    }

    public void setForwardButtonID(int forwardButtonID) {
        this.forwardButtonID = forwardButtonID;
    }

    public int getForwardButtonPort() {
        return forwardButtonPort;
    }

    public void setForwardButtonPort(int forwardButtonPort) {
        this.forwardButtonPort = forwardButtonPort;
    }

    public int getReverseButtonID() {
        return reverseButtonID;
    }

    public void setReverseButtonID(int reverseButtonID) {
        this.reverseButtonID = reverseButtonID;
    }

    public int getReverseButtonPort() {
        return reverseButtonPort;
    }

    public void setReverseButtonPort(int reverseButtonPort) {
        this.reverseButtonPort = reverseButtonPort;
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

    public int getIntakeButtonID() {
        return intakeButtonID;
    }

    public void setIntakeButtonID(int intakeButtonID) {
        this.intakeButtonID = intakeButtonID;
    }

    public int getIntakeButtonPort() {
        return intakeButtonPort;
    }

    public void setIntakeButtonPort(int intakeButtonPort) {
        this.intakeButtonPort = intakeButtonPort;
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
}