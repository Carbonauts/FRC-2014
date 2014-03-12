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
import com.carbonauts.frc2014.subsystems.Pivot;
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
    
    Console console;
    
    Latch shiftLatch;
    Latch shootLatch;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        console = Console.getConsole();
        autonomousCommand = new ExampleAutonomousCommand();
        operatorDriveCommand = new OperatorDriveCommand();
        shiftLatch = new Latch();
        shootLatch = new Latch();
    }

    public void autonomousInit() {
        autonomousCommand.start();
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
        
        if(console.getJoystick().getArmForwardButtonState()) {
            CommandBase.pickupPivot.moveDirection(Pivot.DIRECTION_FORWARD);
        } else if(console.getJoystick().getArmReverseButtonState()) {
            CommandBase.pickupPivot.moveDirection(Pivot.DIRECTION_REVERSE);
        } else {
            CommandBase.pickupPivot.stopPivot();
        }
        
        /*
         * TODO sanity check on logic
         */
        if(console.getJoystick().getRollerButtonState()) {
            /*
            if(CommandBase.pickupPivot.getPosition() != Constants.PIVOT_POSITION_UNKNOWN ||
                    CommandBase.pickupPivot.getPositionTarget() != Constants.PIVOT_POSITION_UNKNOWN) { //If the current position or target position is not unknown
                if(CommandBase.pickupPivot.getPosition() == Constants.PIVOT_POSITION_FORWARD ||
                        CommandBase.pickupPivot.getPositionTarget() == Constants.PIVOT_POSITION_FORWARD) { //Position (or target) must be forward
                    CommandBase.pickupIntake.moveDirection(Constants.PIVOT_DIRECTION_FORWARD); //Spin rollers correct direction for 'forward'
                } else if(CommandBase.pickupPivot.getPosition() == Constants.PIVOT_POSITION_REVERSE ||
                        CommandBase.pickupPivot.getPositionTarget() == Constants.PIVOT_POSITION_REVERSE) { //Position (or target) must be reverse
                    CommandBase.pickupIntake.moveDirection(Constants.PIVOT_DIRECTION_REVERSE); //Spin rollers correct direction for 'reverse'
                } else {
                    //Position must be resting, no direction
                }
            }*/
            
            CommandBase.pickupIntake.moveDirection(Pivot.DIRECTION_FORWARD);
        }
        
        if(shootLatch.update(console.getJoystick().getThrowButtonState())) {
            Scheduler.getInstance().add(new ShootReloadCommand());
        }
        
        //If the shift button switched from off to on (button press)
        if(shiftLatch.update(console.getJoystick().getShiftButtonState())) {
            CommandBase.shifter.toggleHighGear();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
}