/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Class to manage writing status messages to the Driver Station
 * @author Nick
 */
public class LogHelper {
    
    public LogHelper() {
        
    }    
    
    private static String line1 = null, 
            line2 = null,
            line3 = null,
            line4 = null, 
            line5 = null,
            line6 = null;
    
    private DriverStationLCD mDriverStationLCD = DriverStationLCD.getInstance();
    
    public void log(String text) {
        line6 = line5;
        line5 = line4;
        line4 = line3;
        line3 = line2;
        line2 = line1;
        line1 = text;
        
        updateDriverStation();
    }
    
    private void updateDriverStation() {
        mDriverStationLCD.println(DriverStationLCD.Line.kUser1, 0, line1);
        mDriverStationLCD.println(DriverStationLCD.Line.kUser2, 0, line2);
        mDriverStationLCD.println(DriverStationLCD.Line.kUser3, 0, line3);
        mDriverStationLCD.println(DriverStationLCD.Line.kUser4, 0, line4);
        mDriverStationLCD.println(DriverStationLCD.Line.kUser5, 0, line5);
        mDriverStationLCD.println(DriverStationLCD.Line.kUser6, 0, line6);
        
        mDriverStationLCD.updateLCD();
    }
}
