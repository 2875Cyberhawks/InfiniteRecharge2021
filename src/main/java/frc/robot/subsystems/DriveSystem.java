package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.controller.PIDController;

public class DriveSystem extends SubsystemBase {

  public static final int[][] D_PORTS = {{1, 4},
                                         {2, 5},
                                         {3, 6}};

  public static final int[][] E_PORTS = {{6, 7},
                                         {8, 9}};

  public static final double P = .2;
  public static final double I = 0;
  public static final double D = .00025;
  public static PIDController lcontroller;
  public static PIDController rcontroller;
  public static final double MAX_CORR = .5;
  public static final double V = 0; //kVolts
  public static final double VSpM = 0; //kVoltSecondsPerMeter
  public static final double VS2pM = 0; //kVoltSeconds^2PerMeter

  /*private TalonSRX right = new TalonSRX(D_PORTS[0][1]);
  private VictorSPX rf1 = new VictorSPX(D_PORTS[1][1]);
  private VictorSPX rf2 = new VictorSPX(D_PORTS[2][1]);
  
  private TalonSRX left = new TalonSRX(D_PORTS[0][0]);
  private VictorSPX lf1 = new VictorSPX(D_PORTS[1][0]);
  private VictorSPX lf2 = new VictorSPX(D_PORTS[2][0]);*/

  private CANSparkMax right = new CANSparkMax(D_PORTS[0][1], MotorType.kBrushless);
  private CANSparkMax rf1 = new CANSparkMax(D_PORTS[1][1], MotorType.kBrushless);
  private CANSparkMax rf2 = new CANSparkMax(D_PORTS[2][1], MotorType.kBrushless);
  
  private CANSparkMax left = new CANSparkMax(D_PORTS[0][0], MotorType.kBrushless);
  private CANSparkMax lf1 = new CANSparkMax(D_PORTS[1][0], MotorType.kBrushless);
  private CANSparkMax lf2 = new CANSparkMax(D_PORTS[2][0], MotorType.kBrushless);

  private Encoder leftEnc = new Encoder(E_PORTS[0][0], E_PORTS[0][1]);
  private Encoder rightEnc = new Encoder(E_PORTS[1][0], E_PORTS[1][1]);


  public static final double WHEEL_BASE_M = .66675; //26.25 in?

  //private DifferentialDriveKinematics kine = new DifferentialDriveKinematics(WHEEL_BASE_M);

  //private double[] AUTO_POS = {0, 0}; //start position in meters

  //private DifferentialDriveOdometry odo = new DifferentialDriveOdometry(new Rotation2d(Math.toRadians(Robot.getAngle())), new Pose2d(AUTO_POS[0], AUTO_POS[1], new Rotation2d()));



  public DriveSystem() {
    //leftEnc.setDistancePerPulse(1.0/2048.0);
    //rightEnc.setDistancePerPulse(1.0/2048.0); // * diameter in meters
    rf1.follow(right);
    rf2.follow(right);

    lf1.follow(left);
    lf2.follow(left);

    /*right.setInverted(true);
    rf1.setInverted(InvertType.FollowMaster);
    rf2.setInverted(InvertType.FollowMaster);

    right.configFactoryDefault();
    rf1.configFactoryDefault();
    rf2.configFactoryDefault();

    right.configNominalOutputForward(0);
    rf1.configNominalOutputForward(0);
    rf2.configNominalOutputForward(0);

    right.configNominalOutputReverse(0);
    rf1.configNominalOutputReverse(0);
    rf2.configNominalOutputReverse(0);

    right.configPeakOutputForward(1.0);
    rf1.configPeakOutputForward(1.0);
    rf2.configPeakOutputForward(1.0);

    right.configPeakOutputReverse(-1.0);
    rf1.configPeakOutputReverse(-1.0);
    rf2.configPeakOutputReverse(-1.0);

    right.configPeakCurrentLimit(40);
    right.enableCurrentLimit(true);

    left.configFactoryDefault();
    lf1.configFactoryDefault();
    lf2.configFactoryDefault();

    left.configNominalOutputForward(0);
    lf1.configNominalOutputForward(0);
    lf2.configNominalOutputForward(0);

    left.configNominalOutputReverse(0);
    lf1.configNominalOutputReverse(0);
    lf2.configNominalOutputReverse(0);

    left.configPeakOutputForward(1.0);
    lf1.configPeakOutputForward(1.0);
    lf2.configPeakOutputForward(1.0);

    left.configPeakOutputReverse(-1.0);
    lf1.configPeakOutputReverse(-1.0);
    lf2.configPeakOutputReverse(-1.0);

    left.configPeakCurrentLimit(40);
    left.enableCurrentLimit(true);*/
    lcontroller = new PIDController(P, I, D);
    rcontroller = new PIDController(P, I, D);
  }

  public void periodic(){
    SmartDashboard.putNumber("leftMotorInput", lcontroller.calculate(right.getEncoder().getVelocity())/1000);
    SmartDashboard.putNumber("rightMotorInput", rcontroller.calculate(right.getEncoder().getVelocity())/1000);
    SmartDashboard.putNumber("lEnc", left.getEncoder().getVelocity());
    SmartDashboard.putNumber("rEnc", right.getEncoder().getVelocity());
    left.set(lcontroller.calculate(left.getEncoder().getVelocity())/1000);
    right.set(rcontroller.calculate(right.getEncoder().getVelocity())/1000);
    //odo.update(new Rotation2d(Math.toRadians(Robot.getAngle())), rightEnc.getDistance(), leftEnc.getDistance());
  }

  public void setSpeed(double lSpeed, double rSpeed){
    SmartDashboard.putNumber("lSetPoint", lSpeed);
    SmartDashboard.putNumber("rSetPoint", rSpeed);
    if (Math.abs(lSpeed) < 800)
      lSpeed = 0;
    if (Math.abs(rSpeed) < 800)
      rSpeed = 0;
    lcontroller.setSetpoint(lSpeed);
    rcontroller.setSetpoint(rSpeed);
  }

  public double[] getPositions() {
    double[] d = {leftEnc.getDistance(), rightEnc.getDistance()};
    return d;
  }

  public double avgSpeed() {
    return (leftEnc.getRate() + rightEnc.getRate()) / 2;
  }

  public void setVolts(double l, double r){
    left.setVoltage(l);
    right.setVoltage(r);
  }
  
  /*public Pose2d getPose() {
    return odo.getPoseMeters();
  }
  
  public DifferentialDriveKinematics getKine(){
    return kine;
  }
  
  public DifferentialDriveWheelSpeeds getSpeeds() {
    return new DifferentialDriveWheelSpeeds(leftEnc.getRate(), rightEnc.getRate());
  }*/

}
