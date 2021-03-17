// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import java.util.Timer;

public class AutoSimple extends CommandBase {
  public static long startTime;
  public long activeTime;
  public AutoSimple(long inputTime) {
    addRequirements(Robot.ds);
    activeTime = inputTime;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.nanoTime();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.ds.setSpeed(-.5,.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.ds.setSpeed(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    long currentTime = System.nanoTime();
    return (currentTime - startTime)/1000000000 >= activeTime;
  }
}