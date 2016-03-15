// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc691.RobotCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc691.RobotCode.Robot;
import org.usfirst.frc691.RobotCode.RobotMap;

// COMMAND FUNCTION: MOVE UNDER THE LOW BAR DURING AUTONOMOUS

public class AutoLowBar extends Command {
	
	// Variables created for this command.
	double m;
	boolean stop;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoLowBar() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Calls the downArm() function from the Arm class.
    	// Lowers the defense arm to prepare for the low bar.
    	Robot.arm.downArm();
    	
    	// Assigns initial values to the variables.
    	m = 0;
    	stop = false;
    	
    	// Sets the amount of time the command will run in seconds.
    	setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Ramps the drive motors up until they reach maximum.
    	if ((m < 1) && (stop == false)) {
    		m += 0.01;
    	}
    	
    	// Runs the drive motors at maximum until the time set
    	// in initialize() runs out.
    	if ((m >= 1) && (isTimedOut())) {
    		stop = true;
    	}
    	
    	// Ramps the drive motors down until they reach zero.
    	if ((m > 0) && (stop == true)) {
    		m -= 0.01;	
    	}
    	
    	// Sets the drive motor speed every time execute() is called.
    	RobotMap.driveTrainRobotDrive.arcadeDrive(-m, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	// Sets the drive motors to zero.
    	Robot.driveTrain.stop();
    } 

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
