
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.util.PixyCam;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SPI;

//testing github
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  //public static ClimbSystem cs; 
  //public static ShootSystem ss;
  public static DriveSystem ds;
  
  public static RedLayout rl;

  public static IntakeSystem is;
  public static PixyCam ballPixy;
  public static PixyCam goalPixy;

  public static boolean atSpeed = false;

  public static boolean inAuto = false;

  public static AHRS gyro;

  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    //ss = new ShootSystem();
    is = new IntakeSystem();
    ds = new DriveSystem();
    rl = new RedLayout();
    gyro = new AHRS(SPI.Port.kMXP); 
    ballPixy = new PixyCam();
    //goalPixy = new PixyCam();
    gyro.reset();
  }

  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    inAuto = true;
    gyro.reset();
    if(rl != null){} //we're going to need to write a start() or find one in the parents
      //rl.start();
  }

  public void autonomousPeriodic() {
  /*  switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }*/
    CommandScheduler.getInstance().run();
  }

  public void teleopInit() {
    inAuto = false;
    gyro.reset();//if robot is facing forwards at end of auto
    ds.setDefaultCommand(new Drive());
    is.setDefaultCommand(new Intake());
    //ss.setDefaultCommand(new Shoot());
  }

  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  public static double getAngle(){
    double gyAng = gyro.getAngle();

    while (gyAng < -180){
      gyAng += 360;
    }
    while (gyAng > 180){
      gyAng -= 360;
    }

    return gyAng;
    }

  public static double getDistance() {
    if(NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 1){
      double h1 = 1; //height of camera
      double h2 = 1; //height of goal
      double a1 = 1; //angle of camera from ground;
      double a2 = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0); // angle to target
      return (h2 - h1) / Math.tan(Math.toRadians(a1 + a2));
    }
    return -1; 
  }
}
