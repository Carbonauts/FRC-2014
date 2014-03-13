/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.util;

/**
 * Interface to allow objects to be rampable.  To be used with CarbonRampCommand,
 * and any motor controllers we'd like to use.  This expands the ramp's
 * compatibility beyond just the CarbonTalon.
 * @author Nick
 */
public interface CarbonRampable {
    
    public void hardSet(double setpoint);
}