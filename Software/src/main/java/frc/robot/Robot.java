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
import frc.robot.subsystem.Elevator;

public class Robot extends TimedRobot {
  private XboxController joystick = new XboxController(0);
  Elevator _elevator;

  public Robot() {
    _elevator = new Elevator();

    SmartDashboard.putNumber("posCmd", 0);
    SmartDashboard.putNumber("pos1", 0);
    SmartDashboard.putNumber("pos2", 0);
    SmartDashboard.putNumber("pos3", 0);
    SmartDashboard.putNumber("JS X", 0);
    SmartDashboard.putNumber("JS Y", 0);
    SmartDashboard.putNumber("JS A", 0);
    SmartDashboard.putNumber("JS B", 0);
  }

  @Override
  public void teleopPeriodic() {

      if (joystick.getAButtonPressed()) {
        _elevator.setPositionCommand(Constants.ElevatorConstants.kPositionBottom);
      } else if (joystick.getBButtonPressed()) {
        _elevator.setPositionCommand(Constants.ElevatorConstants.kPosition1);
      } else if (joystick.getXButtonPressed()) {
        _elevator.setPositionCommand(Constants.ElevatorConstants.kPosition2);
      } else if (joystick.getYButtonPressed()) {
        _elevator.setPositionCommand(Constants.ElevatorConstants.kPosition3);
      } else if (joystick.getRightBumperButtonPressed()) {
        _elevator.setPositionCommand(Constants.ElevatorConstants.kPosition4);
      }

      if (joystick.getPOV() == 0) {
        _elevator.slewUp();
      } else if (joystick.getPOV() == 180) {
        _elevator.slewDn();
      }

      _elevator.run();
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("JS X", joystick.getLeftX());
    SmartDashboard.putNumber("JS Y", joystick.getLeftY());
    SmartDashboard.putNumber("JS A", joystick.getAButton() ? 1 : 0);
    SmartDashboard.putNumber("JS B", joystick.getBButton() ? 1 : 0);
  }
}