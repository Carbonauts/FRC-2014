/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.util.CarbonTalon;

/**
 * Takes a setpoint to ramp the output of a Talon to
 * @author Greg Armstrong
 * @author Nick
 */
public class TalonRampCommand extends CommandBase{
    private boolean finished = false;
    private CarbonTalon talon;
    private double wantSpeed;
    private double currentSpeed;
    
    /**
     * Takes a Talon and a setpoint for parameters, and ramps the output of the
     * Talon until the setpoint is reached
     * @param talon The talon whose speed to ramp
     * @param speedTarget The point which needs to be reached
     */
    public TalonRampCommand(CarbonTalon talon, double speedTarget) {
        setInterruptible(true);
        this.talon = talon;
        this.wantSpeed = speedTarget;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        try {
            currentSpeed = talon.get();
            boolean isUp = (currentSpeed < wantSpeed);
            double step = isUp ? talon.getStepSize():-talon.getStepSize();

            if ((isUp && (currentSpeed+step > wantSpeed)) 
                    || (!isUp && (currentSpeed+step < wantSpeed)) 
                    || (currentSpeed == wantSpeed)) {
                talon.set(wantSpeed);
                finished = true;
            } else {
                talon.set(currentSpeed + step);
            }
            Thread.sleep(talon.getStepTime()); //Check to make sure this doesn't pause the whole program
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
