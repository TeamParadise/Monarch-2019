package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.SubSystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoystick extends Command
{

	public DriveWithJoystick()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		// Reducing sensitivity of Joystick
		double x = Robot.m_stick.getX(); // * Robot.oi.stick.getX() * Robot.oi.stick.getX();
		double y = Robot.m_stick.getY(); // * Robot.oi.stick.getY() * Robot.oi.stick.getY();
		double z = Robot.m_stick.getZ();
			 if ((x < 0.2) && (x > -0.2)) x = 0;
			 x *= 0.5;
			 if ((y < 0.2) && (y > -0.2)) y = 0;
			 y *= 0.5;
			 if ((z < 0.3) && (z > -0.3)) z = 0;
			 z *= 0.5;
		Robot.driveTrain.driveCartesian(x, y, z, 0);
		

		Robot.driveTrain.report();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}