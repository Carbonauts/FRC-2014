/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.CarbonUI;

/**
 *
 * @author Nick Mosher
 */
public class OperatorDriveCommand extends CommandBase {
    
    CarbonUI ui;
    
    public OperatorDriveCommand() {
        requires(drive);
        setInterruptible(true);
        ui = CarbonUI.getUI();
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        drive.getRobotDrive().arcadeDrive(ui.getDriveArcadeYAxis(), 
                                          ui.getDriveArcadeXAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
