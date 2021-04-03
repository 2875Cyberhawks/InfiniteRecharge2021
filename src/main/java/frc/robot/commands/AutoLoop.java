package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Robot;

public class AutoLoop extends CommandBase {
  public long startTime;
  public double goalAng;
  public long activeTime;
  public double lSpeed, rSpeed;
  public AutoLoop(long inputAng, double lS, double rS) {
    addRequirements(Robot.ds);
    goalAng = inputAng;

    lSpeed = lS;
    rSpeed = rS;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.nanoTime();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // long currentTime = System.nanoTime();
    // double scaler = MathUtil.clamp((currentTime - startTime)/1000000000, 0 , 1);
    Robot.ds.setSpeed(-lSpeed * 5700 ,rSpeed * 5700);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    long currentTime = System.nanoTime();
    if ((currentTime - startTime)/1000000000 >= 1){
      double error = goalAng - Robot.getAngle();
      return (Math.abs(error) < .5);
    }
    else{
      return false;
    }
  }
}