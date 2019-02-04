/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.SubSystems;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * Add your docs here.
 */
public class Sonar
{
    Ultrasonic sonar;
    public Sonar(int OutputChannel, int InputChannel)
    {
        sonar = new Ultrasonic(OutputChannel, InputChannel);
        //SetupSonar();
    }
   
    public void SetupSonar()
    {
        sonar.setAutomaticMode(true);
        sonar.setDistanceUnits(Unit.kInches);
    }

    public double getInches()
    {
        return sonar.getRangeInches();
    }
}
