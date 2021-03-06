/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.subsystems.Drive;
import com.carbonauts.frc2014.subsystems.DriveShifter;
import com.carbonauts.frc2014.subsystems.Intake;
import com.carbonauts.frc2014.subsystems.Pivot;
import com.carbonauts.frc2014.subsystems.Thrower;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Keeps a static reference to every Subsystem, so that each command has access
 * to call methods from those Subsystems
 * @author Nick
 */
public abstract class CommandBase extends Command {
    
    public static Drive drive = new Drive();
    public static DriveShifter shifter = new DriveShifter();
    public static Pivot pivot = new Pivot();
    public static Intake intake = new Intake();
    public static Thrower thrower = new Thrower();
    
    /**
     * This method exists to ensure that CommandBase has been constructed
     * before the system tries to create the Commands (which are dependant
     * on CommandBase)
     */
    public static void init() {
        
    }
}