// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.util.PixyCam;
/** Add your docs here. */
public class RobotContainer {

    private final Command auto;

    public RobotContainer(){
        auto = new AutoSimple(3);
        //eat my jrms
    }

    public Command getAutonomousCommand(){
        return auto;
    }
}
