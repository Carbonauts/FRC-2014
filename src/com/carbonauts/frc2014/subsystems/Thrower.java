/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.util.CarbonDigitalInput;
import com.carbonauts.frc2014.util.CarbonTalon;
import com.carbonauts.frc2014.util.Latch;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem which manages the launching and reloading of the throwing arm and
 * all of its related mechanisms.
 * @author Nick
 */
public class Thrower extends Subsystem {
    
    private CarbonTalon throwerMotor;
    private CarbonDigitalInput retractSwitch;
    private CarbonDigitalInput loadedSwitch;
    private Latch retractLatch;
    
    public Thrower() {
        throwerMotor = new CarbonTalon(Constants.THROWER);
        retractSwitch = new CarbonDigitalInput(Constants.THROWER_RETRACT_LIMIT, 
                                               Constants.THROWER_RETRACT_LIMIT_INVERTED);
        loadedSwitch = new CarbonDigitalInput(Constants.THROWER_LOADED_LIMIT,
                                              Constants.THROWER_LOADED_LIMIT_INVERTED);
        retractLatch = new Latch();
    }
    
    public void setThrowerSpeed(double speed) {
        throwerMotor.setRamp(speed);
    }
    
    public void spinThrowerForward() {
        setThrowerSpeed(1.0);
    }
    
    public void spinThrowerReverse() {
        setThrowerSpeed(-1.0);
    }
    
    public double getThrowerSpeed() {
        return throwerMotor.getSpeed();
    }
    
    public void stopThrower() {
        throwerMotor.stopMotor();
    }
    
    public void hardStopThrower() {
        throwerMotor.hardStopMotor();
    }
    
    public boolean isRetractLimit() {
        return retractSwitch.get();
    }
    
    public boolean isLoaded() {
        return loadedSwitch.get();
    }
    
    public void reset() {
        throwerMotor.reset();
    }
    
    /**
     * Determines whether the shooter is retracted
     * @return True if retracted, false otherwise
     */
    public boolean isRetracted() {
        return retractLatch.onTrue(retractSwitch.get());
    }
    
    public void initDefaultCommand() {
        
    }
}