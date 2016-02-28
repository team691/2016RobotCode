// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc691.PrototypeCode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc691.PrototypeCode.commands.*;
import org.usfirst.frc691.PrototypeCode.subsystems.*;
import org.usfirst.frc691.PrototypeCode.Robot;
import org.usfirst.frc691.PrototypeCode.RobotMap;
import org.usfirst.frc691.PrototypeCode.commands.AutonomousCommand;
import org.usfirst.frc691.PrototypeCode.commands.AutonomousExperimental;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	CameraServer server;
    Command autonomousCommand;
    SendableChooser autoChooser;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static Keeper keeper;
    public static Shooter shooter;
    public static Arm arm;
    public static Climb climb;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Global variables created that are used in other classes.
    public static boolean useTankDrive;
    public static boolean keeperSwitch;
    
    public Robot() {
    	// This code creates a camera instance that will send a stream to the SmartDashboard.
        server = CameraServer.getInstance();
        server.setQuality(50);
        // The camera name (ex "cam0") can be found through the roborio web interface.
        server.startAutomaticCapture("cam0");
    }
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        intake = new Intake();
        keeper = new Keeper();
        shooter = new Shooter();
        arm = new Arm();
        climb = new Climb();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
    	// The SendableChooser allows the drive team to choose an autonomous
        // command from the SmartDashboard before the match.
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default Program", new AutonomousCommand());
        autoChooser.addObject("Experimental Program", new AutonomousExperimental());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        // Code required for the SendableChooser.
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        // This variable detects whether the digital input for the drive
        // mode is true or false. True indicates tank drive, false indicates
        // arcade drive.
        useTankDrive = RobotMap.driveTrainDriveSwitch.get();
        
        // This puts the true or false value to the SmartDashboard.
        SmartDashboard.putBoolean("Tank Drive Enabled", RobotMap.driveTrainDriveSwitch.get());
    }

    /**
     * This function is called periodically during operator control
     */
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        // This puts the true or false value returned by the hasBall()
        // function called from the Keeper class to the SmartDashboard.
        SmartDashboard.putBoolean("Has Ball", Robot.keeper.hasBall());
        
        // This puts the robot's distance returned by the getDistance()
        // function called from the DriveTrain class to the SmartDashboard.
        SmartDashboard.putNumber("Distance", Robot.driveTrain.getDistance());
    }

    /**
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}