/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.util;

import com.carbonauts.frc2014.Constants;

/**
 * 
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
        this(target, Constants.DEFAULT_RAMP_STEP, Constants.DEFAULT_RAMP_TIME);
    }
    
    public CarbonRamp(double target, double stepSize, long stepTime) {
        this.stepSize = stepSize;
        this.stepTime = stepTime;
        this.target = target;
        
        delayTimer = new CarbonTimer(0);
    }
    
    public void tick() {
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
    }
    
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
    
    public void setTarget(double target) {
        this.target = target;
    }
    
    public double getTarget() {
        return this.target;
    }
}