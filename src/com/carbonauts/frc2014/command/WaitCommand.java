/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.util.CarbonTimer;

/**
 * Command for use in a CommandGroup with sequential commands.  Other commands
 * added after this one will not trigger until the time has run out.
 * @author Nick
 */
public class WaitCommand extends CommandBase {

    private CarbonTimer timer;
    private long waitTime = 0;
    private boolean finished = false;
    
    public WaitCommand(long time) {
        waitTime = time;
        timer = new CarbonTimer(waitTime);
    }
    
    protected void initialize() {
        finished = false;
        timer.reset(waitTime);
    }

    protected void execute() {
        if(timer.isDone()) {
            finished = true;
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
