/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.util.CarbonTalon;
import com.carbonauts.frc2014.util.CarbonTimer;

/**
 *
 * @author Greg Armstrong
 */
public class StartRamp extends CommandBase{
    private boolean finished = false;
    private CarbonTalon target;
    private double wantSpeed;
    private double currentSpeed;
    private CarbonTimer rampTimer;
 
    public StartRamp(CarbonTalon target, double setPoint) {
        setInterruptible(true);
        this.target = target;
        this.wantSpeed = setPoint;
    }
    
    protected void initialize() {
        rampTimer = new CarbonTimer(target.getStepTime());
    }

    protected void execute() {
        if (rampTimer.isDone()) {
            currentSpeed = target.get();
            boolean isUp = (currentSpeed < wantSpeed);
            double step = isUp ? target.getStepSize():-target.getStepSize();

            if ((isUp && (currentSpeed+step > wantSpeed)) 
                    || (!isUp && (currentSpeed+step < wantSpeed)) 
                    || (currentSpeed == wantSpeed)) {
                target.set(wantSpeed);
                finished = true;
            } else {
                target.set(currentSpeed + step);
            }
            rampTimer.reset(target.getStepTime());
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
    }
}
