/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.auto;

import com.carbonauts.frc2014.command.DriveForwardCommand;
import com.carbonauts.frc2014.command.ThrowerShootReloadCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Moves the robot forward for a time, then shoots the ball
 * @author Nick
 */
public class AutoMoveShoot extends CommandGroup {
    
    public AutoMoveShoot() {
        addSequential(new DriveForwardCommand(3000));
        addSequential(new WaitCommand(1000));
        addSequential(new ThrowerShootReloadCommand());
    }
}
