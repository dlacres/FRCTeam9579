package frc.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limit {
    private double max = 0;
    private double min = 0;

    public Limit(double min, double max) {
        this.max = max;
        this.min = min;
        if (min > max) {
            System.out.println("*** ERROR Limit Min is greater than LIMIT Max ***");
        }
    }

    public Limit(double max) {
        this.max = max;
        this.min = -max;
    }

    public double calculate(double in) {
        double out;

        SmartDashboard.putNumber("in", in);

        out = in;
        if (in > this.max) out = this.max;
        if (in < this.min) out = this.min;

        return (out);
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
