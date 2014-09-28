/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.carbonauts.frc2014;

import com.carbonauts.frc2014.command.CommandBase;
import com.carbonauts.frc2014.command.OperatorDriveCommand;
import com.carbonauts.frc2014.command.OperatorPivotSimpleCommand;
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
    OperatorPivotSimpleCommand operatorPivotSimpleCommand;
    ThrowerShootReloadCommand shootReloadCommand;
    ThrowerUnloadReloadCommand unloadReloadCommand;
    
    CarbonUI ui;
    
    Latch shiftLatch;
    Latch shootLatch;
    Latch debugEnabledLatch;
    Latch unloadLatch;
    Latch pivotForwardLatch;
    Latch pivotReverseLatch;
    Latch pivotResetLatch;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        
        ui = CarbonUI.getUI();
        ui.initUIConfigs();
        ui.setConfig(CarbonUI.nickXboxConfig);
        
        /*
         * These commands are instances which are stored in BaseProject to be
         * reused as needed.  The Operator Drive Command remains active as long
         * as there are no autonomous routines which require the Drive system.
         * The Shoot/Reload and Unload/Reload commands are stored so that the 
         * progress of the command can be monitored from these object 
         * references.
         */
        operatorDriveCommand = new OperatorDriveCommand();
        operatorPivotSimpleCommand = new OperatorPivotSimpleCommand();
        shootReloadCommand = new ThrowerShootReloadCommand();
        unloadReloadCommand = new ThrowerUnloadReloadCommand();
        
        /*
         * Define Latches to use in the BaseProject.  These are made for
         * different purposes, and will detect whether a dedicated state has
         * flipped true, flipped false, or flipped either.
         */
        shiftLatch = new Latch();
        shootLatch = new Latch();
        debugEnabledLatch = new Latch();
        unloadLatch = new Latch();
        pivotForwardLatch = new Latch();
        pivotReverseLatch = new Latch();
        pivotResetLatch = new Latch();
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
        operatorPivotSimpleCommand.start();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        /*
         * If the Throw button has been pressed, and if the Shoot/Reload
         * Command is not currently running, and if the Pivot arms are out of
         * the way of the Thrower, then start the Shoot/Reload command.
         */
        if(shootLatch.onTrue(ui.getThrowButtonState())) {
            if(!shootReloadCommand.isRunning() && 
                    CommandBase.pivot.isAtSafeZone()) {
                shootReloadCommand.start();
            }
        }
        
        /*
         * If the Unload button has been pressed, and if the Unload/Reload
         * Command is not currently running, and if the thrower is currently
         * in its retracted state, then start the Unload/Reload command.
         */
        if(unloadLatch.onTrue(ui.getUnloadButtonState())) {
            if(!unloadReloadCommand.isRunning() && CommandBase.thrower.isRetractLimit()) {
                unloadReloadCommand.start();
            }
        }
        
        /*
         * If the Shift button has been pressed, then toggle the state of the
         * Drive gear.
         */
        if(shiftLatch.onTrue(ui.getShiftButtonState())) {
            CommandBase.shifter.toggleHighGear();
        }
    }
    
    /**
     * When the robot is disabled, reset the Pivot, Intake, and Thrower
     * subsystems, and cancel the Shoot/Reload command (if active) and cancel
     * the Unload/Reload command (if active).
     */
    public void disabledInit() {
        CommandBase.pivot.reset();
        CommandBase.intake.reset();
        CommandBase.thrower.reset();
        shootReloadCommand.cancel();
        unloadReloadCommand.cancel();
    }
    
    /**
     * Runs periodically while the robot is disabled
     */
    public void disabledPeriodic() {
        
    }
}