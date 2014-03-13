/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;

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
        
    }

    /**
     * Runs the thrower motor at full speed unless the reload point has been reached
     */
    protected void execute() {
        if(!thrower.isReloaded()) {
            thrower.spinThrowerForward();
            //console.getLCDManager().setThrowerReloaded(false);
            if(Constants.DEBUG_MODE) {
                System.out.println("Thrower not reloaded; Thrower spin forward");
            }
        } else {
            thrower.stopThrower();
            //console.getLCDManager().setThrowerReloaded(true);
            finished = true;
            if(Constants.DEBUG_MODE) {
                System.out.println("Thrower reloaded; Thrower stopped");
            }
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
    }
}