// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc691.PrototypeCode.subsystems;

import org.usfirst.frc691.PrototypeCode.RobotMap;
import org.usfirst.frc691.PrototypeCode.commands.*;
import org.usfirst.frc691.PrototypeCode.Robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climb extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController climbMotor = RobotMap.climbClimbMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    // This system runs the climb motor at a set speed.
    public void runClimb() {
    	climbMotor.set(1);
    }
    
    // This system runs the climb motor reversely at a set speed.
    public void reverseClimb() {
    	climbMotor.set(-1);
    }
    
    // This system stops the climb motor.
    public void stopClimb() {
    	climbMotor.set(0);
    }
    
    // This function increases the climb motor slowly to full speed.
    public void rampClimb(double speed) {
    	if (speed < 1) {
    		speed += 0.001;
    		climbMotor.set(speed);
    		rampClimb(speed);
    	}
    }
}

