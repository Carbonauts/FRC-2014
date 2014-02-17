/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonauts.frc2014;

import com.carbonauts.frc2014.util.CarbonJoystick;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Class to contain all of the user input devices (Joysticks, gamepads) and
 * to manage the logging and interface with the SmartDashboard and Driver
 * Station
 * @author Nick
 */
public class Console {

    /**
     * Driver Station object to transfer data to and from the DS
     */
    private DriverStation mDriverStation;
    
    /**
     * The object for writing data to the "User Messages" box on the Driver
     * Station.  Can be used for debugging or state conditions.
     */
    private static DriverStationLCD lcd;
    
    /*
     * TODO rename controls and use constants
     */
    private static final CarbonJoystick joystick = new CarbonJoystick(Constants.JOYSTICK);
    private static Button button1 = new JoystickButton(getJoystick(), 1);
    private static Button button2 = new JoystickButton(getJoystick(), 2);
    private static Button button3 = new JoystickButton(getJoystick(), 3);
    private static Button button4 = new JoystickButton(getJoystick(), 3);
    private static Button button5 = new JoystickButton(getJoystick(), 3);
    private static Button button6 = new JoystickButton(getJoystick(), 3);
    private static Button button7 = new JoystickButton(getJoystick(), 3);
    private static Button button8 = new JoystickButton(getJoystick(), 3);
    private static Button button9 = new JoystickButton(getJoystick(), 3);
    private static Button button10 = new JoystickButton(getJoystick(), 3);
    private static Button button11 = new JoystickButton(getJoystick(), 3);
    private static Button button12 = new JoystickButton(getJoystick(), 3);
    
    public static void updateLCD() {
        lcd.println(DriverStationLCD.Line.kUser1, 1, "THIS IS EXAMPLE");
        lcd.updateLCD();
    }
    
    /**
     * @return the joystick
     */
    public static CarbonJoystick getJoystick() {
        return joystick;
    }
    
    /**
     * @return the button1
     */
    public static Button getButton1() {
        return button1;
    }

    /**
     * @return the button2
     */
    public static Button getButton2() {
        return button2;
    }

    /**
     * @return the button3
     */
    public static Button getButton3() {
        return button3;
    }

    /**
     * @return the button4
     */
    public static Button getButton4() {
        return button4;
    }

    /**
     * @return the button5
     */
    public static Button getButton5() {
        return button5;
    }

    /**
     * @return the button6
     */
    public static Button getButton6() {
        return button6;
    }

    /**
     * @return the button7
     */
    public static Button getButton7() {
        return button7;
    }

    /**
     * @return the button8
     */
    public static Button getButton8() {
        return button8;
    }

    /**
     * @return the button9
     */
    public static Button getButton9() {
        return button9;
    }

    /**
     * @return the button10
     */
    public static Button getButton10() {
        return button10;
    }

    /**
     * @return the button11
     */
    public static Button getButton11() {
        return button11;
    }

    /**
     * @return the button12
     */
    public static Button getButton12() {
        return button12;
    }
}