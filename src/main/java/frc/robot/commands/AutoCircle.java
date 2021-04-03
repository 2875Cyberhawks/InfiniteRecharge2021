// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.*;

public class AutoCircle extends CommandBase {
  public long startTime;
  public long activeTime;
  public double lSpeed, rSpeed;
  public  double goalAng;
  public PIDController control;
  public double P = .01;
  public double error;
  public AutoCircle(long inputAng) {
    addRequirements(Robot.ds);
    goalAng = inputAng;

    control = new PIDController(P,0,0);
    
      }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.nanoTime();
    control.enableContinuousInput(-180, 180);// A domain of [-180, 180]
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // long currentTime = System.nanoTime();
    control.setSetpoint(goalAng);
    double product = control.calculate(Robot.getAngle());
    // SmartDashboard.putNumber("autocircle motors", product);
    Robot.ds.setSpeed((-.6 + product) * 5700 ,( .6 + product) * 5700);
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
    return ((currentTime - startTime)/1000000000 >= .5 && control.getPositionError() < 10);
  }
}
