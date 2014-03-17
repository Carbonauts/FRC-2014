/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.util.CarbonTimer;

/**
 *
 * @author Nick
 */
public class ThrowerUnloadCommand extends CommandBase {

    private Console console;
    private CarbonTimer timer;
    private boolean finished;
    
    public ThrowerUnloadCommand() {
        requires(thrower);
        setInterruptible(false);
        console = Console.getConsole();
        finished = false;
    }
    
    protected void initialize() {
        timer = new CarbonTimer(Constants.THROWER_UNLOAD_TIME);
    }

    protected void execute() {
        if(!timer.isDone()) {
            thrower.spinThrowerReverse();
        } else {
            thrower.stopThrower();
            finished = true;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        thrower.stopThrower();
    }

    protected void interrupted() {
        System.err.println("ThrowerUnloadCommand: Got interrupted!");
    }
}