Carbonauts/FRC-2014
===================

This project is the result of the Carbonauts' first year programming with Java.  We're using the Command based approach for maximum modularity and (we hope) performance.  Many thanks to FRC Team 254 for their public repository on GitHub (https://github.com/Team254/FRC-2013), without it we never would have learned (or even learned of) the Command system.

That being said, here's the anatomy of this project:

com.carbonauts.frc2014.BaseProject
----------------------------------
The highest-level execution class.  All other code on the robot is stemmed from here.  We extend IterativeRobot to give us the main execution loops.

com.carbonauts.frc2014.Console
------------------------------
All code which is involved in interfacing with the user goes here.  This includes Joystick or other controller references, as well as any calls to the Driver Station (virtual inputs/outputs or "User Messages") or the SmartDashboard.

com.carbonauts.frc2014.Constants
--------------------------------
We've abstracted all of our constants to this class to avoid the need to chase down or repeat any constants.  This includes references to the physical robot (i.e. PWM ports, DIO ports) as well as state-based constants.

com.carbonauts.frc2014.command.CommandBase
------------------------------------------
Extends Command, and is a hub for making reference calls to the subsystems (which are all stored as static references).  CommandBase.init() must be called before beginning any commands, seeing as all commands extend CommandBase, not Command, and so CommandBase must be constructed before any Commands are.

com.carbonauts.frc2014.subsystems
---------------------------------
Package of all subsystems of our robot.  The subsystems contain all object references to physical devices (i.e. motors, sensors), as well as necessary and useful methods for use in executing commands or reading subsystem status.

com.carbonauts.frc2014.util
---------------------------
Useful classes for facilitating calculations or functions throughout the rest of the code.