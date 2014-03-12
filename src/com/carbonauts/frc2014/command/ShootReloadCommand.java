/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;

/**
 * Command which both shoots and reloads the throwing mechanism by rotating
 * the 'Choo choo' mechanism one revolution
 * @author Nick
 */
public class ShootReloadCommand extends CommandBase {
    
    private Console console;
    private boolean finished;
    
    public ShootReloadCommand() {
        requires(thrower);
        setInterruptible(false); 
        console = Console.getConsole();
        finished = false;
    }
    
    public void initialize() {
        console.getLCDManager().setThrowerInterrupted(false);
    }

    /**
     * Runs the thrower motor at full speed unless the reload point has been reached
     */
    protected void execute() {
        if(thrower.isReloaded()) {
            thrower.stopThrower();
            console.getLCDManager().setThrowerReloaded(true);
            finished = true;
        } else {
            thrower.setThrowerSpeed(1.0);
            console.getLCDManager().setThrowerReloaded(false);
        }
    }

    protected boolean isFinished() {
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
        console.getLCDManager().setThrowerInterrupted(true);
    }
}
