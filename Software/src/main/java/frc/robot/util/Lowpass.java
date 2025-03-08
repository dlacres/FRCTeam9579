package frc.robot.util;

public class Lowpass {
    private double tau;
    private double lpOld=0;
    private double out=0;

    public Lowpass(double tau){
        this.tau=tau;
        out = 0;
    }
    public void setOld(double old){
        lpOld = old;
    }
    public double calculate(double in){
    
        lpOld = out = lpOld + tau * (in - lpOld);

    return(out);
    }
}
