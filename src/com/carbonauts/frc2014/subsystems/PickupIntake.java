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
public class PickupIntake extends Subsystem {

    private CarbonTalon intakeMotor;
    
    public PickupIntake() {
        intakeMotor = new CarbonTalon(Constants.INTAKE_ROLLERS);
    }
    
    public void moveSpeed(double speed) {
        intakeMotor.setRamp(speed);
    }
    
    public void moveDirection(int direction) {
        if(direction == Pivot.DIRECTION_FORWARD) {
            moveSpeed(1.0);
        } else if(direction == Pivot.DIRECTION_REVERSE) {
            moveSpeed(-1.0);
        } else {
            moveSpeed(0.0);
        }
    }
    
    public CarbonTalon getMotor() {
        return intakeMotor;
    }
    
    protected void initDefaultCommand() {
        
    }
}
