/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.SubSystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PistonTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  DoubleSolenoid exampleDouble = new DoubleSolenoid(0, 1);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void extend() {
    exampleDouble.set(DoubleSolenoid.Value.kForward);
  }
  public void retract() {
    exampleDouble.set(DoubleSolenoid.Value.kReverse);
  }
}
