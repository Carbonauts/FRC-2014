/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.subsystems.Drive;
import com.carbonauts.frc2014.subsystems.Pickup;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Nick
 */
public abstract class CommandBase extends Command {
    
    /*
     * Instantiate all subsystems as static objects
     */
    public static Drive mDrive = new Drive();
    
    public static Pickup mPickup = new Pickup();
    
    /**
     * This method exists to ensure that CommandBase has been constructed
     * before the system tries to create the Commands (which are dependant
     * on CommandBase)
     */
    public static void init() {
        
    }
}