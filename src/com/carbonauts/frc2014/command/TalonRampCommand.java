/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.util.CarbonTalon;
import com.carbonauts.frc2014.util.CarbonTimer;

/**
 * Takes a setpoint to ramp the output of a Talon to
 * @author Greg Armstrong
 * @author Nick
 */
public class TalonRampCommand extends CommandBase{
    private boolean finished = false;
    private CarbonTalon talon;
    private double currentSpeed;
    private CarbonTimer delayTimer;
    
    /**
     * Takes a Talon and a setpoint for parameters, and ramps the output of the
     * Talon until the setpoint is reached
     * @param talon The talon whose speed to ramp
     */
    public TalonRampCommand(CarbonTalon talon) {
        this.setInterruptible(true);
        this.talon = talon;
    }
    
    protected void initialize() {
        delayTimer = new CarbonTimer(0);    //Run the first time without a delay
    }

    protected void execute() {
        if (delayTimer.isDone()) {      //if it has been at least getStepTime() ms since the last run
            delayTimer.reset(talon.getStepTime());  //reset the timer
            currentSpeed = talon.get();
            boolean isUp = (currentSpeed < talon.getTargetSpeed());
            double step = isUp ? talon.getStepSize() : -talon.getStepSize();

            if ((isUp && (currentSpeed+step >= talon.getTargetSpeed())) 
                    || (!isUp && (currentSpeed+step <= talon.getTargetSpeed()))) {
                talon.set(talon.getTargetSpeed());
                finished = true;
            } else {
                talon.set(currentSpeed + step);
            }
            System.out.println("Goal: " + talon.getTargetSpeed() + "Current: " + currentSpeed + " isUp: " + isUp + " step: " + step + " delay: " + talon.getStepTime());
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
