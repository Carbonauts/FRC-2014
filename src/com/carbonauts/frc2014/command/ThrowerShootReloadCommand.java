/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.CarbonUI;
import com.carbonauts.frc2014.util.Latch;

/**
 * Command which both shoots and reloads the throwing mechanism by rotating
 * the 'Choo choo' mechanism one revolution
 * @author Nick
 */
public class ThrowerShootReloadCommand extends CommandBase {
    
    private CarbonUI ui;
    private boolean finished = false;
    private Latch stopLatch;
    
    public ThrowerShootReloadCommand() {
        requires(thrower);
        setInterruptible(false); 
        ui = CarbonUI.getUI();
        stopLatch = new Latch();
    }
    
    public void initialize() {
        finished = false;
    }

    /**
     * Runs the thrower motor at full speed unless the reload point has been reached
     */
    protected void execute() {
        
        if(stopLatch.onTrue(ui.getUnloadButtonState())) {
            finished = true;
        } else if(!thrower.isRetracted()) {
            thrower.spinThrowerForward();
            //console.getLCDManager().setThrowerReloaded(false);
        } else {
            thrower.hardStopThrower();
            //console.getLCDManager().setThrowerReloaded(true);
            finished = true;
        }
    }

    public boolean isFinished() {
        System.out.println("ShootReloadCommand.isFinished()" + finished);
        return finished;
    }

    protected void end() {
        thrower.stopThrower();
    }

    /**
     * Stop the thrower motor if interrupted
     */
    protected void interrupted() {
        thrower.stopThrower();
        finished = true;
    }
}
