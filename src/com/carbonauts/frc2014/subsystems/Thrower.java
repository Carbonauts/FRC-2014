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
    
    private CarbonTalon chooChoo;
    private CarbonDigitalInput reloadSwitch;
    private Latch reloadLatch;
    
    public Thrower() {
        chooChoo = new CarbonTalon(Constants.THROWER);
        reloadSwitch = new CarbonDigitalInput(Constants.THROWER_LIMIT, 
                                              Constants.THROWER_LIMIT_INVERTED);
        reloadLatch = new Latch();
    }
    
    public void setThrowerSpeed(double speed) {
        chooChoo.setRamp(speed);
    }
    
    public double getThrowerSpeed() {
        return chooChoo.getSpeed();
    }
    
    public void stopThrower() {
        chooChoo.stopMotor();
    }
    
    public boolean isAtLimit() {
        return reloadSwitch.get();
    }
    
    /**
     * Determines whether the shooter is reloaded
     * @return True if reloaded, false otherwise
     */
    public boolean isReloaded() {
        return reloadLatch.update(reloadSwitch.get());
    }
    
    public void initDefaultCommand() {
        
    }
}
