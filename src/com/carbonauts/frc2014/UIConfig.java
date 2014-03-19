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

    public int getPivotForwardButtonID() {
        return pivotForwardButtonID;
    }

    public void setPivotForwardButtonID(int pivotForwardButtonID) {
        this.pivotForwardButtonID = pivotForwardButtonID;
    }

    public int getPivotForwardButtonPort() {
        return pivotForwardButtonPort;
    }

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