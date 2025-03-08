/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystem;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.util.Limit;
import frc.robot.util.Lowpass;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;


public class Elevator extends TimedRobot {
  private SparkMax motor;
  private SparkMax motorFollower;
  private SparkMaxConfig motorConfig;
  private SparkMaxConfig motorFollowerConfig;
  private SparkClosedLoopController closedLoopController;
  private RelativeEncoder encoder;
  SlewRateLimiter slewRateLimiter = new SlewRateLimiter(Constants.ElevatorConstants.kSlewSpeedGoTo);
  SlewRateLimiter slewManual = new SlewRateLimiter(Constants.ElevatorConstants.kSlewSpeedManual);
  Limit _limit = new Limit(0.0, Constants.ElevatorConstants.kMmaxPosition);
  Lowpass lowpass = new Lowpass(1*Constants.Utilities.kDT);

  double _positionCommand = 0;

  public Elevator() {
    /*
     * Initialize the SPARK MAX and get its encoder and closed loop controller
     * objects for later use.
     */
    motor = new SparkMax(4, MotorType.kBrushless);
    closedLoopController = motor.getClosedLoopController();
    encoder = motor.getEncoder();

    motorFollower = new SparkMax(2, MotorType.kBrushless);
    /*
     * Create a new SPARK MAX configuration object. This will store the
     * configuration parameters for the SPARK MAX that we will set below.
     */
    motorConfig = new SparkMaxConfig();
    motorFollowerConfig = new SparkMaxConfig();

    motorFollowerConfig
      .follow(motor,true);

    /*
     * Configure the encoder. For this specific example, we are using the
     * integrated encoder of the NEO, and we don't need to configure it. If
     * needed, we can adjust values like the position or velocity conversion
     * factors.
     */
    motorConfig.encoder
        .positionConversionFactor(1)
        .velocityConversionFactor(1);

    /*
     * Configure the closed loop controller. We want to make sure we set the
     * feedback sensor as the primary encoder.
     */
    motorConfig.closedLoop
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        // Set PID values for position control. We don't need to pass a closed loop
        // slot, as it will default to slot 0.
        .p(Constants.ElevatorConstants.kP)
        .i(Constants.ElevatorConstants.kI)
        .d(Constants.ElevatorConstants.kD)
        .outputRange(-1, 1);
    /*
     * Apply the configuration to the SPARK MAX.
     *
     * kResetSafeParameters is used to get the SPARK MAX to a known state. This
     * is useful in case the SPARK MAX is replaced.
     *
     * kPersistParameters is used to ensure the configuration is not lost when
     * the SPARK MAX loses power. This is useful for power cycles that may occur
     * mid-operation.
     */
    motor.configure(motorConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
    motorFollower.configure(motorFollowerConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

    /*
     * Set the encoder position to 0. This is a good practice when you are
     * starting a closed loop control application.
     */
    encoder.setPosition(0);
  }

  public void run(){
    double position1 = slewRateLimiter.calculate(_positionCommand);
    double position2 = _limit.calculate(position1);
    double position3 = lowpass.calculate(position2); 
    closedLoopController.setReference(position3, ControlType.kPosition, ClosedLoopSlot.kSlot0);

    slewManual.reset(position2);

    SmartDashboard.putNumber("posCmd", _positionCommand);
    SmartDashboard.putNumber("pos1", position1);
    SmartDashboard.putNumber("pos2", position2);
    SmartDashboard.putNumber("pos3", position3);
  }

  public void setPositionCommand(double positionCommand) {
    _positionCommand = positionCommand;
  }

  public void slewUp() {
    _positionCommand = slewManual.calculate(_positionCommand+1);
  }
  public void slewDn() {
    _positionCommand = slewManual.calculate(_positionCommand-1);
  }
}
