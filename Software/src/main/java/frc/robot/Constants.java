package frc.robot;
public final class Constants {
    public final class ElevatorConstants {
        public static final double kP = .2;
        public static final double kI = .0001;
        public static final double kD = 0;
        public static final double kPositionBottom = 0;
        public static final double kPosition1 = 2;  
        public static final double kPosition2 = 3;  
        public static final double kPosition3 = 4;  
        public static final double kPosition4 = 5;  
        public static final double kMmaxPosition = 6;  
        public static final double kSlewSpeedGoTo = 2;  // The slew speed when pressing a button to go to a position
        public static final double kSlewSpeedManual = .5; // The slew speed when using the top hat up/down
    }
    public final class Utilities {
        public static final double kDT = .05; // 1 / 20Hz (The robot loop runs at 20Hz)
    }   
}
