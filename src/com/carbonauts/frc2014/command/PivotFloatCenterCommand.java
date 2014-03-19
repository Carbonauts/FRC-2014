/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014.command;

import com.carbonauts.frc2014.Constants;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

/**
 *
 * @author Nick
 */
public class PivotFloatCenterCommand extends CommandBase implements PIDOutput {

    private PIDController controller;
    private boolean finished = false;
    
    public PivotFloatCenterCommand() {
        requires(pivot);
        setInterruptible(true);
    }
    
    protected void initialize() {
        finished = false;
        controller = new PIDController(Constants.PIVOT_PID_P, 
                                       Constants.PIVOT_PID_I, 
                                       Constants.PIVOT_PID_D, 
                                       pivot, 
                                       this);
        controller.setInputRange(Constants.PIVOT_PID_MIN, Constants.PIVOT_PID_MAX);
        controller.setAbsoluteTolerance(Constants.PIVOT_POSITION_TOLERANCE);
        controller.setSetpoint(0.0);
        controller.enable();
    }

    protected void execute() {
        if(controller.onTarget()) {
            finished = true;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }

    public void pidWrite(double output) {
        pivot.setPivotSpeed(output);
    }
}
