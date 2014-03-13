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
    private CarbonDigitalInput throwerSwitch;
    private Latch reloadLatch;
    
    public Thrower() {
        chooChoo = new CarbonTalon(Constants.THROWER);
        throwerSwitch = new CarbonDigitalInput(Constants.THROWER_LIMIT, 
                                               Constants.THROWER_LIMIT_INVERTED);
        reloadLatch = new Latch();
    }
    
    public void setThrowerSpeed(double speed) {
        chooChoo.setRamp(speed);
    }
    
    public void spinThrowerForward() {
        setThrowerSpeed(1.0);
    }
    
    public void spinThrowerReverse() {
        setThrowerSpeed(-1.0);
    }
    
    public double getThrowerSpeed() {
        return chooChoo.getSpeed();
    }
    
    public void stopThrower() {
        chooChoo.stopMotor();
    }
    
    public void hardStopThrower() {
        chooChoo.hardStopMotor();
    }
    
    public boolean isAtLimit() {
        return throwerSwitch.get();
    }
    
    /**
     * Determines whether the shooter is reloaded
     * @return True if reloaded, false otherwise
     */
    public boolean isReloaded() {
        return reloadLatch.update(throwerSwitch.get());
    }
    
    public void initDefaultCommand() {
        
    }
}
