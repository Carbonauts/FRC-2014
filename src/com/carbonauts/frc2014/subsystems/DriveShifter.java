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
    
    private Solenoid mShifterSolenoid;
    
    public DriveShifter() {
        mShifterSolenoid = new Solenoid(Constants.SHIFTER_SOLENOID);
    }
    
    public void setHighGear(boolean gear) {
        mShifterSolenoid.set(gear);
    }
    
    public boolean isHighGear() {
        return mShifterSolenoid.get();
    }
    
    protected void initDefaultCommand() {
        
    }
}