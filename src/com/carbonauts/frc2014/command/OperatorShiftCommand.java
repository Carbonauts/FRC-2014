/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Console;
import com.carbonauts.frc2014.Constants;

/**
 *
 * @author Nick
 */
public class OperatorShiftCommand extends CommandBase {

    private Console console;
    private boolean finished = false;
    
    public OperatorShiftCommand() {
        requires(shifter);
        setInterruptible(true);
        console = Console.getConsole();
        finished = false;
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        shifter.setHighGear(console.getUI().getShiftButtonState());
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        shifter.setHighGear(Constants.SHIFTER_HIGH_GEAR);
    }
}