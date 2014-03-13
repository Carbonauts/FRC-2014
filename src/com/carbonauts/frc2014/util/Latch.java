/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.util;

/**
 * Boolean latch function directly copied from Team 254's FRC-2013 code 
 * @author Nick
 */
public class Latch {
    private boolean lastBool;
    
    public Latch() {
        lastBool = true;
    }
    
    public boolean update(boolean nowBool) {
        boolean result = nowBool && !lastBool;
        lastBool = nowBool;
        return result;
    }
}