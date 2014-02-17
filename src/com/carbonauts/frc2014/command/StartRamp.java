/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.util.CarbonTalon;

/**
 *
 * @author Greg Armstrong
 */
public class StartRamp extends CommandBase{
    private boolean finished = false;
    private CarbonTalon target;
    private double wantSpeed;
    private double currentSpeed;
 
    public StartRamp(CarbonTalon target, double setPoint) {
        setInterruptible(true);
        this.target = target;
        this.wantSpeed = setPoint;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        try {
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
            Thread.sleep(target.getStepTime()); //Check to make sure this doesn't pause the whole program
            //wait(target.getStepTime());       //This might make the whole program pause
        } catch (Exception ex) {
            //Do something
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
