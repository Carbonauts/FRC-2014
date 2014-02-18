/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.util;

import com.carbonauts.frc2014.command.CarbonRampCommand;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * 
 * @author Greg Armstrong
 * @author Nick
 */
public class CarbonTalon extends Talon {
    
    private CarbonRamp ramp;
    private CarbonRampCommand rampCommand;
    
    public CarbonTalon(int channel) {
        super(channel);
        ramp = new CarbonRamp();
        rampCommand = new CarbonRampCommand(ramp);
        Scheduler.getInstance().add(rampCommand);
    }
    
    public CarbonTalon(int slot, int channel) {
        super(slot, channel);
        ramp = new CarbonRamp();
        rampCommand = new CarbonRampCommand(ramp);
        Scheduler.getInstance().add(rampCommand);
    }
    
    public CarbonTalon(int channel, double stepSize, long stepTime) {
        super(channel);
        ramp = new CarbonRamp(0, stepSize, stepTime);
        rampCommand = new CarbonRampCommand(ramp);
        Scheduler.getInstance().add(rampCommand);
    }
    
    public CarbonTalon(int slot, int channel, double stepSize, long stepTime) {
        super(slot, channel);
        ramp = new CarbonRamp(0, stepSize, stepTime);
        rampCommand = new CarbonRampCommand(ramp);
        Scheduler.getInstance().add(rampCommand);
    }

    public double getStepSize() {
        return ramp.getStepSize();
    }
    
    public void setStepSize(double stepSize) {
        ramp.setStepSize(stepSize);
    }
    
    public long getStepTime() {
        return ramp.getStepTime();
    }
    
    public void setStepTime(long stepTime) {
        ramp.setStepTime(stepTime);
    }
    
    public void setRamp(double setPoint) {
        ramp.setTarget(setPoint);
    }
    
    public double getTargetSpeed() {
        return ramp.getTarget();
    }
}
