/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Runs Unload then reload commands
 * @author Nick
 */
public class ThrowerUnloadReloadCommand extends CommandGroup {
    
    public ThrowerUnloadReloadCommand() {
        requires(CommandBase.thrower);
        setInterruptible(false);
        
        addSequential(new ThrowerUnloadCommand());
        addSequential(new ThrowerShootReloadCommand());
    }
}