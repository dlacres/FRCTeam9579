package org.firstinspires.ftc.teamcode;


public class Deadzone {
    double size=0.0;

    public Deadzone(double size){
        this.size = size;
    }
    double calc(double in){
        double out;

        out=in;
        if ((in<this.size && in>-this.size)) out=0;

        return(out);
    }
}
