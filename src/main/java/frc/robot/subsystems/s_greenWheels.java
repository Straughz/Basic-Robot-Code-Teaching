/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.c_intakeGreenWheels;

/**
 * Add your docs here.
 */
public class s_greenWheels extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX greenWheelTop;
  private VictorSPX greenWheelBottom;


  public synchronized void configureWheels () {
    greenWheelTop = new TalonSRX(RobotMap.greenWheelTop);
    // greenWheelTop.configFactoryDefault();
    greenWheelTop.setInverted(true);


    greenWheelBottom = new VictorSPX(RobotMap.greenWheelBottom);
    // greenWheelBottom.configFactoryDefault();
    greenWheelBottom.setInverted(true);

  }



  public synchronized void greenWheelsDefault (double speed) {
    greenWheelTop.set(ControlMode.PercentOutput, speed);
    greenWheelBottom.set(ControlMode.PercentOutput, speed);
    
    // System.out.println(speed);
  }


  public synchronized void setGreenWheels (double topSpeed, double bottomSpeed) {
    greenWheelTop.set(ControlMode.PercentOutput, topSpeed);
    greenWheelTop.set(ControlMode.PercentOutput, bottomSpeed);
  }

  public synchronized void stopGreenWheels () {
    greenWheelTop.set(ControlMode.PercentOutput, 0);
    greenWheelTop.set(ControlMode.PercentOutput, 0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new c_intakeGreenWheels());
  }
}
