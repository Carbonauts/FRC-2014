/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1829.frc2014.command;

import com.team1829.frc2014.subsystems.DriveGearbox;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Nick
 */
public abstract class CommandBase extends Command {
    
    public static DriveGearbox mDriveGearbox = new DriveGearbox();
    
    /**
     * This method exists to ensure that CommandBase has been constructed
     * before the system tries to create the Commands (which are dependant
     * on CommandBase)
     */
    public static void init() {
        
    }
}