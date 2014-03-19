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
    private int activeModeIndex = 0;
    
    public CarbonAutoSwitcher() {
        autoModes = new Vector();
    }
    
    public void setMode(int index) {
        if(index < 0) {
            activeModeIndex = 0;
        } else if(index > autoModes.size() - 1) {
            activeModeIndex = autoModes.size() - 1;
        } else {
            activeModeIndex = index;
        }
    }
    
    public void increment() {
        activeModeIndex++;
        
        if(activeModeIndex >= autoModes.size()) {
            activeModeIndex = 0;
        }
    }
    
    public void decrement() {
        activeModeIndex--;
        
        if(activeModeIndex < 0) {
            activeModeIndex = autoModes.size() - 1;
        }
    }
    
    public Command getActiveCommand() {
        if(autoModes.isEmpty()) {
            System.err.println("No autonomous commands registered!");
            return null;
        } else {
            return (Command) autoModes.elementAt(activeModeIndex);
        }
    }
    
    public String getActiveCommandName() {
        if(getActiveCommand() != null) {
            return getActiveCommand().getName();
        } else {
            return "NULL COMMAND";
        }
    }
    
    public void registerAutoCommand(Command autoCommand) {
        System.out.println("[AutoSwitcher|RegisterAutoCommand]");
        if(!autoModes.contains(autoCommand)) {
            autoModes.addElement(autoCommand);
        } else {
            System.err.println("AutoSwitcher already contains command! " + autoCommand);
        }
    }
    
    public void unregisterAutoCommand(Command autoCommand) {
        System.out.println("[AutoSwitcher|UnregisterAutoCommand]");
        if(autoModes.contains(autoCommand)) {
            autoModes.removeElement(autoCommand);
        } else {
            System.err.println("AutoSwitcher does not contain command! " + autoCommand);
        }
    }
}