/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.subsystems.Drive;
import com.carbonauts.frc2014.subsystems.DriveShifter;
import com.carbonauts.frc2014.subsystems.PickupIntake;
import com.carbonauts.frc2014.subsystems.PickupPivot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Keeps a static reference to every Subsystem, so that each command has access
 * to call methods from those Subsystems
 * @author Nick
 */
public abstract class CommandBase extends Command {
    
    /*
     * Instantiate all subsystems as static objects
     */
    public static Drive mDrive = new Drive();
    public static DriveShifter mShifter = new DriveShifter();
    public static PickupPivot mPickupPivot = new PickupPivot();
    public static PickupIntake mPickupIntake = new PickupIntake();
    
    /**
     * This method exists to ensure that CommandBase has been constructed
     * before the system tries to create the Commands (which are dependant
     * on CommandBase)
     */
    public static void init() {
        
    }
}