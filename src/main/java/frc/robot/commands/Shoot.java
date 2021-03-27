

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.util.IO;

public class Shoot extends CommandBase {
  public static final double FSPEED = -15;
  public static double tempSpeed;
  public Shoot() {
    addRequirements(Robot.ss);
  }

  
  public void initialize() {
    Robot.ss.setSetpointS(0);
    Robot.ss.setSetpointF(0);
    Robot.ss.stop();
    tempSpeed = 60;
  }


  public void execute() {
    int status = IO.getShoot();
    if (IO.getTrigger()){
      Robot.ss.setSetpointF(FSPEED);
    }
    if(status == 1){
      Robot.ss.setSetpointS(sOfD(Robot.getDistance()));
      Robot.ss.setBackwardsS(false);
      Robot.ss.setBackwardsF(false);
    }
    else if(status == -1){
      //Robot.ss.setBackwardsS(true);
      Robot.ss.setBackwardsF(true);
    }
    else{
      Robot.ss.setBackwardsS(false);
      Robot.ss.setBackwardsF(false);
      Robot.ss.setSetpointS(0);
      Robot.ss.setSetpointF(0);
    }

    if (IO.getX()){
      tempSpeed-= .5;
    }
    if (IO.getY()){
      tempSpeed += .5;
    }
    SmartDashboard.putNumber("ShootSpeed ", tempSpeed);
  }

  public void end(boolean interrupted) {
    Robot.ss.stop();
  }

  public boolean isFinished() {
    return false;
  }

  public double sOfD(double d){
    
    return tempSpeed; //s(d): speed function wrt distance
  }
}
