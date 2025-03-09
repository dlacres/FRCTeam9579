// Defines a subsystem for the 2025 robot
// Written by the Osage FRC Robotics Team Tech Devils
// This subsystem uses 4 motor and 8 omni wheels to drive the robot in any direction
package frc.robot.subsystem;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import frc.robot.Constants;
import frc.robot.util.Lowpass;

import com.revrobotics.spark.SparkMax;

public class OmniDrive {
  private static SparkMax m_wheel_1;
  private static SparkMax m_wheel_2;
  private static SparkMax m_wheel_3;
  private static SparkMax m_wheel_4;

  Lowpass _filterForward = new Lowpass(Constants.kDrive.kJoystickFilter*Constants.kUtility.kDT);
  Lowpass _filterSide = new Lowpass(Constants.kDrive.kJoystickFilter*Constants.kUtility.kDT);
  Lowpass _filterTurn = new Lowpass(Constants.kDrive.kJoystickFilter*Constants.kUtility.kDT);
  
  double _scaleLateral = 0.5;
  double _scaleTurn = 0.5;


  public OmniDrive(double scaleLateral, double scaleTurn) {
    _scaleLateral = scaleLateral;
    _scaleTurn = scaleTurn; 
    m_wheel_1 = new SparkMax(Constants.kMotor.kWheel1, MotorType.kBrushless);
    m_wheel_2 = new SparkMax(Constants.kMotor.kWheel2, MotorType.kBrushless);
    m_wheel_3 = new SparkMax(Constants.kMotor.kWheel3, MotorType.kBrushless);
    m_wheel_4 = new SparkMax(Constants.kMotor.kWheel4, MotorType.kBrushless);
  }
  /** This function is called periodically during operator control. */
  public void run(double sideCommand, double forwardCommand, double turnCommand) {

    double _turnCommand = _filterTurn.calculate(turnCommand * _scaleTurn);
    double _sideCommand = _filterSide.calculate(sideCommand * _scaleLateral);
    double _forwardCommand = _filterSide.calculate(forwardCommand * _scaleLateral);;

    m_wheel_1.set(_forwardCommand + _turnCommand);
    m_wheel_3.set(_sideCommand + _turnCommand);
    m_wheel_2.set( - _forwardCommand + _turnCommand);
    m_wheel_4.set( - _sideCommand + _turnCommand);
  }

  public double getFowardDistance() { // TODO forward distance
    double _forwardDistance=0;

    return _forwardDistance;
  }
  public double getSideDistance() { // TODO side distance
    double _sideDistance=0;

    return _sideDistance;
  }
}
