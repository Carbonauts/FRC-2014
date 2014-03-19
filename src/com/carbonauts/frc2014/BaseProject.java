/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.carbonauts.frc2014;

import com.carbonauts.frc2014.auto.CarbonAutoSwitcher;
import com.carbonauts.frc2014.command.CommandBase;
import com.carbonauts.frc2014.command.OperatorDriveCommand;
import com.carbonauts.frc2014.command.ThrowerShootReloadCommand;
import com.carbonauts.frc2014.command.ThrowerUnloadReloadCommand;
import com.carbonauts.frc2014.util.Latch;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BaseProject extends IterativeRobot {
    
    OperatorDriveCommand operatorDriveCommand;
    ThrowerShootReloadCommand shootReloadCommand;
    ThrowerUnloadReloadCommand unloadReloadCommand;
    
    CarbonAutoSwitcher autoSwitcher;
    
    Console console;
    
    Latch shiftLatch;
    Latch shootLatch;
    Latch debugEnabledLatch;
    Latch unloadLatch;
    Latch pivotForwardLatch;
    Latch pivotReverseLatch;
    Latch autoSwitchIncrementLatch;
    Latch autoSwitchDecrementLatch;
    Latch autoSwitchLaunchLatch;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        console = Console.getConsole();
        
        console.initUIConfigs();
        console.initUI().setConfig(console.nickJoystickConfig);
        
        operatorDriveCommand = new OperatorDriveCommand();
        shootReloadCommand = new ThrowerShootReloadCommand();
        unloadReloadCommand = new ThrowerUnloadReloadCommand();
        
        shiftLatch = new Latch();
        shootLatch = new Latch();
        debugEnabledLatch = new Latch();
        unloadLatch = new Latch();
        pivotForwardLatch = new Latch();
        pivotReverseLatch = new Latch();
        autoSwitchIncrementLatch = new Latch();
        autoSwitchDecrementLatch = new Latch();
        autoSwitchLaunchLatch = new Latch();
        
        autoSwitcher = new CarbonAutoSwitcher();
        autoSwitcher.registerAutoCommand(new ThrowerShootReloadCommand());
        autoSwitcher.registerAutoCommand(new ThrowerUnloadReloadCommand());
    }

    public void autonomousInit() {
        
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        if(shootLatch.onTrue(console.getUI().getThrowButtonState())) {
            if(!shootReloadCommand.isRunning() && 
                    CommandBase.pivot.isAtSafeZone() &&
                    CommandBase.thrower.isLoaded()) {
                shootReloadCommand.start();
            }
        }
        
        if(unloadLatch.onTrue(console.getUI().getUnloadButtonState())) {
            if(!unloadReloadCommand.isRunning() && CommandBase.thrower.isRetractLimit()) {
                unloadReloadCommand.start();
            }
        }
        
        
        
        /*if(autoSwitchLaunchLatch.onTrue(console.getUI().getAutoSwitchLaunchButtonState())) {
            autoSwitcher.getActiveCommand().start();
            System.out.println("Launched " + autoSwitcher.getActiveCommandName());
            
        } else if(autoSwitchIncrementLatch.onTrue(console.getUI().getAutoSwitchIncrementButtonState())) {
            autoSwitcher.increment();
            System.out.println("Current Auto Mode: " + autoSwitcher.getActiveCommandName());
            
        } else if(autoSwitchDecrementLatch.onTrue(console.getUI().getAutoSwitchDecrementButtonState())) {
            autoSwitcher.decrement();
            System.out.println("Current Auto Mode: " + autoSwitcher.getActiveCommandName());
        }*/
    }
    
    public void disabledInit() {
        CommandBase.pivot.reset();
        CommandBase.intake.reset();
        CommandBase.thrower.reset();
        shootReloadCommand.cancel();
        unloadReloadCommand.cancel();
    }
    
    public void disabledPeriodic() {
        if(autoSwitchIncrementLatch.onTrue(console.getUI().getAutoSwitchIncrementButtonState())) {
            autoSwitcher.increment();
            System.out.println("Current Auto Mode: " + autoSwitcher.getActiveCommandName());
        } else if(autoSwitchDecrementLatch.onTrue(console.getUI().getAutoSwitchDecrementButtonState())) {
            autoSwitcher.decrement();
            System.out.println("Current Auto Mode: " + autoSwitcher.getActiveCommandName());
        }
    }
}