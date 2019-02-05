package frc.robot.SubSystems;

import frc.robot.Robot;
import frc.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends Subsystem
{
  public static final int kFrontLeftChannel = 0;//0
  public static final int kRearLeftChannel = 1;//1
  public static final int kFrontRightChannel = 3;//3
  public static final int kRearRightChannel = 2;//2

  WPI_TalonSRX frontLeft = new WPI_TalonSRX(kFrontLeftChannel);
  WPI_TalonSRX rearLeft = new WPI_TalonSRX(kRearLeftChannel);
  WPI_TalonSRX frontRight = new WPI_TalonSRX(kFrontRightChannel);
  WPI_TalonSRX rearRight = new WPI_TalonSRX(kRearRightChannel);
 
	private int rearLeftVal = 0;
	private int rearRightVal = 1;

	private static final double Kp = 0.3;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	private static final int kMaxNumberOfMotors = 2;
	
	private static final double maxOutput = 0.85;

	public RobotDrive robotDrive;
	
	private boolean isRunning = false;
	
 	public DriveTrain()
	{
		robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		
		//Fix Output Not Enabled Error
		robotDrive.setSafetyEnabled(false);
		frontLeft.setSafetyEnabled(false);
		frontRight.setSafetyEnabled(false);
		rearRight.setSafetyEnabled(false);
		rearLeft.setSafetyEnabled(false);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
	}

	public void arcadeDrive(Joystick stick, boolean squaredInputs)
	{
		robotDrive.arcadeDrive(stick,squaredInputs);
	}
	
	public boolean isRunning()
	{
		return isRunning;
	}	
	public void report()
	{
  
  }
}