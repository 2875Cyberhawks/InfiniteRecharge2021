// package frc.robot.commands;
// import io.github.pseudoresonance.pixy2api.links.SPILink;
// import io.github.pseudoresonance.pixy2api.Pixy2;
// import io.github.pseudoresonance.pixy2api.Pixy2CCC;
// import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
// import edu.wpi.first.wpiutil.math.MathUtil;
// import frc.robot.subsystems.DriveSystem;
// import frc.robot.commands.TurnTo;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Robot;

// public class GetBall extends CommandBase {
//   private Block ball;
//   private static final double XGOAL = 360;
//   private static final double AREAGOAL = 100; //get these number later
//   public GetBall() {
//     addRequirements(Robot.ds);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     double error = 0;
//     ball = Robot.ballPixy.getBlock();
//     if (ball.getX() < XGOAL){
    
//     }
//     if ((ball.getHeight() * ball.getWidth()) == AREAGOAL){
      
//     }
    

//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     Robot.ballPixy.getBlock();
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
