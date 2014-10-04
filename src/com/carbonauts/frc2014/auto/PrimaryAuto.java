/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carbonauts.frc2014.auto;

import com.carbonauts.frc2014.command.IntakeSpinForwardCommand;
import com.carbonauts.frc2014.command.IntakeSpinReverseCommand;
import com.carbonauts.frc2014.command.IntakeStopCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * This class is going to be the main setup for the Autonomous Mode.
 * @author Nick Mosher
 */
public class PrimaryAuto extends CommandGroup {
    
    public PrimaryAuto() {
        addSequential(new IntakeSpinForwardCommand(), 5.0);
        addSequential(new WaitCommand(5.0), 5.0);
        addSequential(new IntakeSpinReverseCommand(), 5.0);
        addSequential(new WaitCommand(5.0), 5.0);
        addSequential(new IntakeStopCommand());
    }
}
