// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.*;

/** Add your docs here. */
public class RobotContainer {

    private final Command auto;

    public RobotContainer(){
        auto = new AutoCircle(12,.5,.85); //3,.5,.85 for quarter circle
    }

    public Command getAutonomousCommand(){
        return auto;
    }
}
