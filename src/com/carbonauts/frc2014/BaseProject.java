/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.carbonauts.frc2014;

import com.carbonauts.frc2014.command.CommandBase;
import com.carbonauts.frc2014.command.ExampleAutonomousCommand;
import com.carbonauts.frc2014.command.OperatorDriveCommand;
import com.carbonauts.frc2014.command.ShootReloadCommand;
import com.carbonauts.frc2014.command.UnloadReloadCommand;
import com.carbonauts.frc2014.util.Latch;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BaseProject extends IterativeRobot {
    
    Command autonomousCommand; //Example autonomous command
    Command operatorDriveCommand;
    ShootReloadCommand shootReloadCommand;
    UnloadReloadCommand unloadReloadCommand;
    
    Console console;
    
    Latch shiftLatch;
    Latch shootLatch;
    Latch debugEnabledLatch;
    Latch unloadLatch;
    Latch pivotForwardLatch;
    Latch pivotReverseLatch;
    
    boolean debugMode = false;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        console = Console.getConsole();
        
        console.initNickUI();
        console.initUI().setConfig(console.nickConfig);
        
        autonomousCommand = new ExampleAutonomousCommand();
        operatorDriveCommand = new OperatorDriveCommand();
        shootReloadCommand = new ShootReloadCommand();
        unloadReloadCommand = new UnloadReloadCommand();
        
        shiftLatch = new Latch();
        shootLatch = new Latch();
        debugEnabledLatch = new Latch();
        unloadLatch = new Latch();
        pivotForwardLatch = new Latch();
        pivotReverseLatch = new Latch();
    }

    public void autonomousInit() {
        Scheduler.getInstance().add(autonomousCommand);
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
            
            if(!shootReloadCommand.isRunning()) {
                shootReloadCommand = new ShootReloadCommand();
                Scheduler.getInstance().add(shootReloadCommand);
            }
            
            System.out.println("Throw Button Pressed");
        }
        
        if(unloadLatch.onTrue(console.getUI().getUnloadButtonState())) {
            
            if(!unloadReloadCommand.isRunning()) {
                unloadReloadCommand = new UnloadReloadCommand();
                Scheduler.getInstance().add(unloadReloadCommand);
                System.out.println("unloadReloadCommand == null");
            }
            
            System.out.println("Unload Button Pressed");
        }
        
        /*System.out.println("1:" + (console.getJoystick().getArmForwardButtonState() ? "T" : "F") +
                           " 2:" + (console.getJoystick().getArmRestingButtonState() ? "T" : "F") +
                           " 2:" + (console.getJoystick().getArmReverseButtonState() ? "T" : "F") + 
                           " 3:" + (console.getJoystick().getInvertDriveButtonState() ? "T" : "F") + 
                           " 4:" + (console.getJoystick().getRollerButtonState() ? "T" : "F") + 
                           " 5:" + (console.getJoystick().getShiftButtonState() ? "T" : "F") +
                           " 6:" + (console.getJoystick().getThrowButtonState() ? "T" : "F"));*/
    }
}