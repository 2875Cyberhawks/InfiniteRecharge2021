
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Spark;

public class IntakeSystem extends SubsystemBase {
  
  public static final int[] M_PORTS = {7, 8, 6};

  public static TalonSRX angle = new TalonSRX(M_PORTS[0]);
  public static VictorSPX intake = new VictorSPX(M_PORTS[1]);
  public static VictorSPX elevator = new VictorSPX(M_PORTS[2]);

  private static final double P = 0;

  private static final double I = 0;
  
  private static final double D = 0;

  public static final int MIN_POS = 0;
  public static final int MAX_POS = 0;

  //private boolean limited = true;

  public double setpoint = 0;
  public double inSpeed = 0;
  public double eSpeed = 0;
  public int curCount = 0;
  //public boolean spedUp = false;
  public double prevCur = 0;
  public double prevVel = 0;

  public IntakeSystem() {
   setpoint = 0;
   eSpeed = 0;
   inSpeed = 0;
   /*angle.configFactoryDefault();
 
   angle.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
 
   angle.configContinuousCurrentLimit(40);
   angle.enableCurrentLimit(true);
   
   angle.configNominalOutputForward(0);
   angle.configNominalOutputReverse(0);
   angle.configPeakOutputForward(1);
   angle.configPeakOutputReverse(-1);
   angle.setIntegralAccumulator(0);
   angle.config_IntegralZone(0, 60);
 
   angle.config_kP(0, P);
   angle.config_kI(0, I); 
   angle.config_kD(0, D);
   angle.config_kF(0, 0);*/
 
   //angle.setSelectedSensorPosition(MAX_POS); 
  }

  public void setSetpoint(int pos){
    setpoint = pos == 0 ? 0 : MAX_POS / pos == 1 ? 2 : 1;
  }

  public void setIntake(double input){
    inSpeed = input;
  }

  public void setElevator(double input){
    eSpeed = input;
  }

  public void disable(){
   // angle.set(ControlMode.PercentOutput, 0);
    elevator.set(ControlMode.PercentOutput, 0);
    intake.set(ControlMode.PercentOutput, 0);
  }
  
  /*public void moveInc(double diff){
    diff = limited && ((angle.getSelectedSensorPosition() > (MAX_POS) && diff > 0) 
    || (angle.getSelectedSensorPosition() < (MIN_POS) && diff < 0)) ? 0 : diff;
    setSetpoint(setpoint + diff);
  }*/

  public void periodic(){
    //angle.set(ControlMode.MotionMagic, setpoint);
    intake.set(ControlMode.PercentOutput, inSpeed);
    elevator.set(ControlMode.PercentOutput, eSpeed);

    //if(setpoint == 0){
     // if(Math.abs(angle.getStatorCurrent() - prevCur) > 5 /*&& Math.abs(angle.getSelectedSensorVelocity()) < 2*/ && angle.getSelectedSensorVelocity() - prevVel <= 0)
       // angle.setSelectedSensorPosition(0);
    
    //prevCur = angle.getStatorCurrent();
    //prevVel = angle.getSelectedSensorVelocity();
    }
  }

