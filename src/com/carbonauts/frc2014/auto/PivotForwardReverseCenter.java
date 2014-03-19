/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.auto;

import com.carbonauts.frc2014.command.PivotFloatCenterCommand;
import com.carbonauts.frc2014.command.PivotMoveForwardCommand;
import com.carbonauts.frc2014.command.PivotMoveReverseCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Nick
 */
public class PivotForwardReverseCenter extends CommandGroup {
    
    public PivotForwardReverseCenter() {
        addSequential(new PivotMoveForwardCommand());
        addSequential(new PivotMoveReverseCommand());
        addSequential(new PivotFloatCenterCommand());
    }
}
