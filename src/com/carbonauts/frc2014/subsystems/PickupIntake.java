/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to manage the rollers on the pickup mechanism.  Separated from
 * PickupPivot so that commands may run simultaneously which affect both systems
 * @author Nick
 */
public class PickupIntake extends Subsystem {

    private Talon mIntakeMotor;
    
    public PickupIntake() {
        
    }
    
    protected void initDefaultCommand() {
        
    }
}
