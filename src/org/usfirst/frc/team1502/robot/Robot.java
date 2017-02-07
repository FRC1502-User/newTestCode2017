
package org.usfirst.frc.team1502.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1502.robot.commands.ExampleCommand;
import org.usfirst.frc.team1502.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	Joystick leftStick;
	Joystick rightStick;
	Joystick manipStick;
	CANTalon rightFrontWheel;
	CANTalon rightBackWheel;
	CANTalon leftFrontWheel;
	CANTalon leftBackWheel;
	CANTalon addTalonOne;
	CANTalon addTalonTwo;
//    Command autonomousCommand;
//    SendableChooser chooser;
    RobotDrive drive;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
//        chooser = new SendableChooser();
//        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
//        SmartDashboard.putData("Auto mode", chooser);
        leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		manipStick = new Joystick(2);
		rightFrontWheel = new CANTalon(1);
		rightBackWheel = new CANTalon(2);
		leftFrontWheel = new CANTalon(3);
        leftBackWheel = new CANTalon(4);
        addTalonOne = new CANTalon(5);
        addTalonTwo = new CANTalon(6);
        drive = new RobotDrive(rightFrontWheel, rightBackWheel, leftFrontWheel, leftBackWheel);
		
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
//    public void autonomousInit() {
//        autonomousCommand = (Command) chooser.getSelected();
//        
//        if (autonomousCommand != null) autonomousCommand.start();
//    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
		// this line or comment it out.
//        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.mecanumDrive_Cartesian(rightStick.getX(), rightStick.getY(), leftStick.getX(), 0);

        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
