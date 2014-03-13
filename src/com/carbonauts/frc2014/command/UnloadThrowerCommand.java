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
public class UnloadThrowerCommand extends CommandBase {

    private Console console;
    private CarbonTimer timer;
    private boolean finished;
    
    public UnloadThrowerCommand() {
        requires(thrower);
        setInterruptible(true);
        console = Console.getConsole();
        finished = false;
    }
    
    protected void initialize() {
        timer = new CarbonTimer(Constants.THROWER_UNLOAD_TIME);
    }

    protected void execute() {
        if(!timer.isDone()) {
            thrower.spinThrowerReverse();
            if(Constants.DEBUG_MODE) {
                System.out.println("Thrower timer not done; Thrower spin forward");
            }
            
        } else {
            thrower.stopThrower();
            finished = true;
            if(Constants.DEBUG_MODE) {
                System.out.println("Thrower timer done; Thrower stopped");
            }
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        thrower.stopThrower();
    }

    protected void interrupted() {
        thrower.stopThrower();
    }
}
