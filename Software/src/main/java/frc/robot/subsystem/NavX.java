// Defines a subsystem for the 2025 robot
// Written by the Osage FRC Robotics Team Tech Devils
// This subsystem uses the NavX MXP Gyro to provide heading information
package frc.robot.subsystem;

import com.studica.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;

public class NavX {
    AHRS ahrs;
    Double _distanceX=0.0;
    Double _distanceY=0.0;

    public NavX() {
        System.out.println("Gyro Constructor");

        try {
          ahrs = new AHRS(AHRS.NavXComType.kMXP_SPI);
        }  catch (RuntimeException ex ) {
          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }
//        ahrs.zeroYaw();  TODO This can not be here. The calibration is not complete yet.

    }

    public void run() {
        //System.out.println("Gyro Run");
        _distanceX += ahrs.getVelocityX()*Constants.kUtility.kDT;
        _distanceY += ahrs.getVelocityY()*Constants.kUtility.kDT;
    }   

    public double getDistanceX() {
        return _distanceX;
    }

    public double getDistanceY() {
        return _distanceY;
    }

    public void zeroYaw() {
        ahrs.zeroYaw();
    }

    public void zeroDistance() {
        _distanceX = 0.0;
        _distanceY = 0.0;
    }   

    public double getYaw() {
        return ahrs.getYaw();
    }

    public double getPitch() {
        return ahrs.getPitch();
    }

    public double getRoll() {
        return ahrs.getRoll();
    }

    public boolean isMoving() {
        return ahrs.isMoving();
    }

    public double getVelocityX() {
        return ahrs.getVelocityX();
    }
    public double getVelocityY() {
        return ahrs.getVelocityY();
    }
    public boolean isConnected() {
        return ahrs.isConnected();
    }

}
