/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.auto;

import edu.wpi.first.wpilibj.command.Command;
import java.util.Vector;

/**
 * Class to manage the execution of autonomous modes
 * @author Nick
 */
public class CarbonAutoSwitcher {
    
    private Vector autoModes;
    private int activeModeIndex = -1;
    
    public CarbonAutoSwitcher() {
        autoModes = new Vector();
    }
    
    public void setMode(int index) {
        if(index < 0) {
            activeModeIndex = 0;
        } else if(index > autoModes.size()) {
            activeModeIndex = autoModes.size();
        } else {
            activeModeIndex = index;
        }
    }
    
    public void incrementMode() {
        activeModeIndex++;
        
        if(activeModeIndex > autoModes.size()) {
            activeModeIndex = 0;
        }
    }
    
    public void decrementMode() {
        activeModeIndex--;
        
        if(activeModeIndex < 0) {
            activeModeIndex = autoModes.size();
        }
    }
    
    public Command getActiveCommand() {
        if(activeModeIndex == -1) {
            System.err.println("No autonomous commands registered!");
            return null;
        } else {
            return (Command) autoModes.elementAt(activeModeIndex);
        }
    }
    
    public void registerAutoCommand(Command autoCommand) {
        if(!autoModes.contains(autoCommand)) {
            autoModes.addElement(autoCommand);
        } else {
            System.err.println("AutoSwitcher already contains command! " + autoCommand);
        }
    }
    
    public void unregisterAutoCommand(Command autoCommand) {
        if(autoModes.contains(autoCommand)) {
            autoModes.removeElement(autoCommand);
        } else {
            System.err.println("AutoSwitcher does not contain command! " + autoCommand);
        }
    }
}