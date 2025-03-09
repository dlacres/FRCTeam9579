package frc.robot;
public final class Constants {
    public final class kMotor {
        public static final int kElevatorMotor1 = 4; // The spark motor controller ID for the elevator
        public static final int kElevatorMotor2 = 2; // The spark motor controller ID for the elevator
        public static final int kWheel1 = 1;        // The spark motor controller ID for the first wheel
        public static final int kWheel2 = 3;        // The spark motor controller ID for the second wheel
        public static final int kWheel3 = 6;        // The spark motor controller ID for the third wheel
        public static final int kWheel4 = 5;        // The spark motor controller ID for the fourth wheel
        //public static final int kWheel1 = 3;        // The spark motor controller ID for the first wheel
        //public static final int kWheel2 = 9;        // The spark motor controller ID for the second wheel
        //public static final int kWheel3 = 6;        // The spark motor controller ID for the third wheel
        //public static final int kWheel4 = 4;        // The spark motor controller ID for the fourth wheel
    }   //TODO Fix the motor controller IDs
    public final class kDrive {
        public static final double kLateralCommandScale = .5;    // The scale factor for the side movement
        public static final double kTurnCommandScale = .25;    // The scale factor for the turn movement
        public static final double kJoystickFilter = 2; // The lowpass filter for the drive joystick in seconds
    }
    public final class kElevator {
        public static final double kP = .2;     // The proportional gain for the elevator
        public static final double kI = .0001;  // The integral gain for the elevator
        public static final double kD = 0;      // The derivative gain for the elevator
        public static final double kPositionBottom = 0;  // The position for the bottom of the elevator in inches
        public static final double kPosition1 = 2;       // The position for the first level of the elevator in inches
        public static final double kPosition2 = 3;      // The position for the second level of the elevator in inches
        public static final double kPosition3 = 4;      // The position for the third level of the elevator in inches
        public static final double kPosition4 = 5;      // The position for the fourth level of the elevator in inches
        public static final double kMmaxPosition = 6;   // The position for the top level of the elevator in inches 
        public static final double kSlewSpeedGoTo = 2;  // The slew speed when pressing a button to go to a position
        public static final double kSlewSpeedManual = .5; // The slew speed when using the top hat up/down
        public static final double kSlewLowpassFilter = 1;      // The elevator lowpass filter in seconds
    }
    public final class kUtility {
        public static final double kDT = .05; // 1 / 20Hz (The robot loop runs at 20Hz)
    }   
}
