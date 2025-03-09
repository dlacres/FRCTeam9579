package frc.robot.subsystem;

import com.revrobotics.*;
import com.revrobotics.Rev2mDistanceSensor.Port;
import com.revrobotics.Rev2mDistanceSensor.RangeProfile;

public class Distance {

    private Rev2mDistanceSensor _distanceSensor;

    public Distance() {
        _distanceSensor = new Rev2mDistanceSensor(Port.kOnboard);
        _distanceSensor.setRangeProfile(RangeProfile.kLongRange);
        _distanceSensor.setAutomaticMode(true);
        _distanceSensor.setEnabled(true);
    
        System.out.println("Distance");
    }

    public boolean isValid() {
        return _distanceSensor.isRangeValid();
    }

    public double getDistance() {
        return _distanceSensor.getRange();
    }
}
