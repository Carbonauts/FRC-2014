/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.subsystems;

import com.carbonauts.frc2014.Constants;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to control the pneumatic shifter on the Drive gearbox
 * @author Nick
 */
public class DriveShifter extends Subsystem {
    
    private Solenoid shifterSolenoid;
    private boolean isHigh = true;
    
    public DriveShifter() {
        shifterSolenoid = new Solenoid(Constants.SHIFTER_SOLENOID);
    }
    
    public void setHighGear(boolean gear) {
        isHigh = gear;
        shifterSolenoid.set(isHigh);
    }
    
    public void toggleHighGear() {
        isHigh = !isHigh;
        shifterSolenoid.set(isHigh);
    }
    
    public boolean isHighGear() {
        return shifterSolenoid.get();
    }
    
    protected void initDefaultCommand() {
        
    }
}