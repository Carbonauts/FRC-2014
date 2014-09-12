/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.CarbonUI;

/**
 *
 * @author Nick
 */
public class OperatorShiftCommand extends CommandBase {

    private CarbonUI ui;
    private boolean finished = false;
    
    public OperatorShiftCommand() {
        requires(shifter);
        setInterruptible(true);
        ui = CarbonUI.getUI();
        finished = false;
    }
    
    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        shifter.setHighGear(ui.getShiftButtonState());
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}