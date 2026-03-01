package frc.robot;
import com.revrobotics.spark.SparkMax;

public class DriveSide {

    SparkMax m_front;
    SparkMax m_back;
    boolean m_inverted;

    DriveSide(SparkMax front, SparkMax back, boolean inverted) {
        m_front = front;
        m_back = back;
        m_inverted = inverted;
    }

    void driveSide(double speed) {

        double speedCmd = 0.0;
        if (m_inverted) {
            speedCmd = -speed;
        } else {
            speedCmd = speed;
        }
    
        m_front.set(speedCmd);
        m_back.set(speedCmd);

    }
    
}
