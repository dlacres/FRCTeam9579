package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import com.revrobotics.spark.SparkMax;

public class Drive {
  private SlewRateLimiter m_rateLimitForward;
  private SlewRateLimiter m_rateLimitTurn;

  SparkMax m_driveLeftFt;
  SparkMax m_driveLeftBk;
  SparkMax m_driveRightFt;
  SparkMax m_driveRightBk;
  SparkMax m_gate;

  Drive() {
    
    m_driveLeftFt = new SparkMax(3, SparkMax.MotorType.kBrushless);
    m_driveLeftBk = new SparkMax(4, SparkMax.MotorType.kBrushless);
    m_driveRightFt = new SparkMax(7, SparkMax.MotorType.kBrushless);
    m_driveRightBk = new SparkMax(6, SparkMax.MotorType.kBrushless);
    m_gate = new SparkMax(8, SparkMax.MotorType.kBrushless);

    m_rateLimitForward = new SlewRateLimiter(6);
    m_rateLimitTurn = new SlewRateLimiter(6);
  }

  public void calc(double forwardCommand1, double turnCommand1){
    double forward = m_rateLimitForward.calculate(-forwardCommand1);
    double turn = m_rateLimitTurn.calculate(-turnCommand1);

    m_driveLeftBk.set(forward+turn);m_driveLeftFt.set(forward+turn);
    m_driveRightBk.set(-forward+turn);m_driveRightFt.set(-forward+turn);
  }
}
