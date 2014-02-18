/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.util.CarbonRamp;

/**
 *
 * @author Nick
 */
public class CarbonRampCommand extends CommandBase {

    private CarbonRamp ramp;
    
    private boolean finished = false;
    
    public CarbonRampCommand(CarbonRamp ramp) {
        this.ramp = ramp;
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        ramp.tick();
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
