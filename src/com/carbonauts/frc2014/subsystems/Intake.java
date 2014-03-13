/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Constants;
import com.carbonauts.frc2014.util.CarbonTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to manage the rollers on the pickup mechanism.  Separated from
 * PickupPivot so that commands may run simultaneously which affect both systems
 * @author Nick
 */
public class Intake extends Subsystem {

    private CarbonTalon intakeMotor;
    
    public Intake() {
        intakeMotor = new CarbonTalon(Constants.INTAKE);
    }
    
    protected void initDefaultCommand() {
        
    }
}