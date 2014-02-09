/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.util;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Carbonaut's own DigitalInput object, with added constructors to invert 'get'
 * @author Nick
 */
public class CarbonDigitalInput extends DigitalInput {
    
    private boolean mInverted = false;
    
    public CarbonDigitalInput(int channel) {
        super(channel);
    }
    
    public CarbonDigitalInput(int moduleNumber, int channel) {
        super(moduleNumber, channel);
    }
    
    public CarbonDigitalInput(int channel, boolean inverted) {
        super(channel);
        mInverted = inverted;
    }
    
    public CarbonDigitalInput(int moduleNumber, int channel, boolean inverted) {
        super(moduleNumber, channel);
        mInverted = inverted;
    }
    
    public boolean get() {
        if(mInverted) {
            return !super.get();
        }
        return super.get();
    }
}