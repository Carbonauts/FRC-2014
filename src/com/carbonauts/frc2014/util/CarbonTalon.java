/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.util;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.command.StartRamp;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * 
 * @author Greg Armstrong
 */
public class CarbonTalon extends Talon {

    private double stepSize;
    private int stepTime;
    
    public CarbonTalon(int slot, int channel) {
        super(slot, channel);
        stepSize = Constants.DEFAULT_RAMP_STEP;
    }

    public CarbonTalon(int channel) {
        super(channel);
        stepTime = Constants.DEFAULT_RAMP_TIME;
    }

    /**
     * @return the size of each step
     */
    public double getStepSize() {
        return stepSize;
    }
    
    /**
     * 
     * @return the time between steps in ms
     */
    public int getStepTime() {
        return stepTime;
    }

    /**
     * @param stepSize the ramp step size to set
     * @param rampTime the ramp time to set in ms
     */
    public void setRampParameters(double stepSize, int rampTime) {
        this.stepSize = stepSize;
        this.stepTime = rampTime;
    }
    
    public void setRamp(double setPoint) {
        Scheduler.getInstance().add(new StartRamp(this, setPoint));
    }
    
    public void setNoRamp(double setPoint) {
        super.set(setPoint);
    }
}
