/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PWMVictorSPX;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.SubSystems.DriveTrain;
import frc.robot.SubSystems.Sonar;

/**
* This is a demo program showing how to use Mecanum control with the RobotDrive
* class.
*/
public class Robot extends TimedRobot {

 private static final int kJoystickChannel = 0;

 public static final DriveTrain driveTrain = new DriveTrain();
 public static MecanumDrive m_robotDrive;
 public static Joystick m_stick = new Joystick(kJoystickChannel);;

 public static Sonar rightSonar = new Sonar(0,1);
 public static Sonar leftSonar = new Sonar(4,3);
 
 @Override
 public void robotInit() {
   rightSonar.SetupSonar();
   leftSonar.SetupSonar();
   CameraServer.getInstance().addAxisCamera("Camera", "10.11.65.3");
   
   // Invert the left side motors.
   // You may need to change or remove this to match your robot.
   //frontRight.setInverted(true);
   //rearRight.setInverted(true);
 }

 @Override
 public void teleopPeriodic() {
  //  // Use the joystick X axis for lateral movement, Y axis for forward
  //  // movement, and Z axis for rotation.
  
  double x = m_stick.getX();
    if ((x < 0.2) && (x > -0.2)) x = 0;
    x *= 0.5;
    double y = m_stick.getY();
    if ((y < 0.2) && (y > -0.2)) y = 0;
    //y *= 0.5;
    double z = m_stick.getZ();
    if ((z < 0.3) && (z > -0.3)) z = 0;
    z *= 0.5;
  //  //System.out.println(z);
  
    
   //SmartDashboard.updateValues();
   //if (m_stick.getRawButtonPressed(7))
  //{
    //System.out.print(rightSonar.getInches() + " , " + leftSonar.getInches() + " , " + specialSonar.getInches());
    //SmartDashboard.putString("Sonar",Double.toString(leftSonar.getInches()) + " , " + Double.toString(rightSonar.getInches()));
    //SmartDashboard.putString("Sonar",Double.toString(leftSonar.getInches()) + " , " + Double.toString(rightSonar.getInches()));
    SmartDashboard.putNumber("Left Sonar", (int)leftSonar.getInches());
    SmartDashboard.putNumber("Right Sonar", (int)rightSonar.getInches());
    //driveTrain.driveCartesian(x, y, twist, gyroAngle);
    driveTrain.driveCartesian(x, y, z, 0.0);
  }
}


