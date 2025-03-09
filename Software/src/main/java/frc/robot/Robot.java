/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystem.Distance;
import frc.robot.subsystem.Elevator;
import frc.robot.subsystem.NavX;
import frc.robot.subsystem.OmniDrive;

public class Robot extends TimedRobot {
  private XboxController joystick = new XboxController(0);
  Elevator _elevator;
  NavX _navX;
  OmniDrive _omniDrive;
  Distance _distance;

  public Robot() {
    _elevator = new Elevator();

    _navX = new NavX();
    _omniDrive = new OmniDrive(Constants.kDrive.kLateralCommandScale, Constants.kDrive.kTurnCommandScale);
    _distance = new Distance();

    SmartDashboard.putNumber("posCmd", 0);
    SmartDashboard.putNumber("pos1", 0);
    SmartDashboard.putNumber("pos2", 0);
    SmartDashboard.putNumber("pos3", 0);
    SmartDashboard.putNumber("Yaw", 0);
    SmartDashboard.putNumber("Dist", 0);
  }

  @Override
  public void teleopPeriodic() {

      // Elevator Positioning
      if (joystick.getAButtonPressed()) {
        _elevator.setPositionCommand(Constants.kElevator.kPositionBottom);
      } else if (joystick.getBButtonPressed()) {
        _elevator.setPositionCommand(Constants.kElevator.kPosition1);
      } else if (joystick.getXButtonPressed()) {
        _elevator.setPositionCommand(Constants.kElevator.kPosition2);
      } else if (joystick.getYButtonPressed()) {
        _elevator.setPositionCommand(Constants.kElevator.kPosition3);
      } else if (joystick.getRightBumperButtonPressed()) {
        _elevator.setPositionCommand(Constants.kElevator.kPosition4);
      }

      // Elevator Slew
      if (joystick.getPOV() == 0) {
        _elevator.slewUp();
      } else if (joystick.getPOV() == 180) {
        _elevator.slewDn();
      }

      _elevator.run();
      _omniDrive.run(joystick.getLeftX(), joystick.getLeftY(), joystick.getRightX());
      _navX.run();

      SmartDashboard.putNumber("Yaw", _navX.getYaw());
      SmartDashboard.putNumber("isMv", _navX.isMoving() ? 1 : 0);
      SmartDashboard.putNumber("DistX", _navX.getDistanceX());
      SmartDashboard.putNumber("DistY", _navX.getDistanceY());
      SmartDashboard.putNumber("isConn", _navX.isConnected() ? 1 : 0);
      SmartDashboard.putNumber("Dist", _distance.getDistance());
      SmartDashboard.putNumber("Valid", _distance.isValid() ? 1 : 0);
  }

  @Override
  public void robotPeriodic() {
  }
}