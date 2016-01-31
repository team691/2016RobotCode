// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc691.Demo1.subsystems;

import org.usfirst.frc691.Demo1.Robot;
import org.usfirst.frc691.Demo1.RobotMap;
import org.usfirst.frc691.Demo1.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController rightRear = RobotMap.driveTrainRightRear;
    private final SpeedController rightFront = RobotMap.driveTrainRightFront;
    private final SpeedController leftRear = RobotMap.driveTrainLeftRear;
    private final SpeedController leftFront = RobotMap.driveTrainLeftFront;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final AnalogInput distanceSensor = RobotMap.driveTrainDistanceSensor;
    private final DigitalInput driveMode = RobotMap.driveTrainDriveMode;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new StickDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void takeJoystickInput(Joystick stick1, Joystick stick2) {
    	if (Robot.useTankDrive) {
    		robotDrive.tankDrive(stick1, stick2, true);
    	} else {	
    		robotDrive.arcadeDrive(stick1, true);
    	}
    }
    
    public void stop() {
    	robotDrive.drive(0,0);
    }
    
    public void driveMe(double speed, double curve) {
    	robotDrive.drive(speed, curve);
    }
    
    public double getDistance() { 
    	double robotDistance = Robot.driveTrain.distanceSensor.getVoltage() / 0.0090;
    	return robotDistance;
    }
    
}
