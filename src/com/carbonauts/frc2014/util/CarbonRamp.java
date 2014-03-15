/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.util;

import com.carbonauts.frc2014.Constants;

/**
 * This class provides a means to set a target value to slowly ramp up or down
 * to.  The ramp speed is dependent upon the delay between updates and the
 * magnitude of the steps at each interval.  The ramp will slowly increment
 * from it's current value to the target value.
 * @author Nick
 */
public class CarbonRamp {
    
    private double stepSize;
    private long stepTime;
    private double target = 0;
    private double currentOutput = 0;
    
    private CarbonTimer delayTimer;
    
    public CarbonRamp() {
        this(0);
    }
    
    public CarbonRamp(double target) {
        this(target, Constants.RAMP_DEFAULT_STEPSIZE, Constants.RAMP_DEFAULT_STEPTIME);
    }
    
    public CarbonRamp(double target, double stepSize, long stepTime) {
        this.stepSize = stepSize;
        this.stepTime = stepTime;
        this.target = target;
        
        delayTimer = new CarbonTimer(0);
    }
    
    /**
     * This is the logic function which needs to be run continuously in order to
     * be effective (in a loop).  This function measures the time at each
     * iteration, and checks if the time elapsed from the last iteration is
     * greater than the stepTime.  If it is, it will increment this ramp's value
     * by the stepSize, reset the timer, and continue.
     */
    public void tick() {
        if(Constants.RAMPS_ENABLED) {
            if(delayTimer.isDone()) {
                delayTimer.reset(stepTime);
                boolean isUp = (currentOutput < target);
                double step = isUp ? stepSize : -stepSize;

                if((isUp && (currentOutput + step >= target)) || 
                        (!isUp && (currentOutput + step <= target))) {
                    currentOutput = target;
                } else {
                    currentOutput += step;
                }
            }
        } else { //Ramps not enabled
            currentOutput = target;
        }
    }
    
    public void setOutput(double output) {
        this.currentOutput = output;
    }
    
    /**
     * Returns the current value of this ramp.
     * @return The value of the ramp.
     */
    public double getOutput() {
        return currentOutput;
    }
    
    public void setStepTime(long time) {
        if(time > 0) {
            this.stepTime = time;
        }
    }
    
    public long getStepTime() {
        return this.stepTime;
    }
    
    public void setStepSize(double size) {
        if(size >= 0) {
            this.stepSize = size;
        } else {
            this.stepSize = -size;
        }
    }
    
    public double getStepSize() {
        return this.stepSize;
    }
    
    /**
     * Sets a new target for this ramp to increment toward.
     * @param target Target for the ramp to approach.
     */
    public void setTarget(double target) {
        this.target = target;
    }
    
    /**
     * Reads the currently set target for this ramp.
     * @return The current target.
     */
    public double getTarget() {
        return this.target;
    }
}