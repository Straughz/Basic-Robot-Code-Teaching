/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.c_teleopDrive;



public class s_drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private static WPI_TalonSRX t1, t4;
  private static WPI_VictorSPX t2, t3, t5, t6;

  private static SpeedControllerGroup mGroupLeft, mGroupRight;
  private static DifferentialDrive mDrive;


  public void configureDrive () {
    t1 = new WPI_TalonSRX(RobotMap.leftMotort1);
    t4 = new WPI_TalonSRX(RobotMap.rightMotort4);

    /* t1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    // t4.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 100);
    

    t4.configRemoteFeedbackFilter(t1.getDeviceID(), //Device ID of Source
    RemoteSensorSource.TalonSRX_SelectedSensor,	//Remote Feedback Source
    0, //Source #
    100); //Configuration Timeout
                        
    t4.configSensorTerm(SensorTerm.Diff1, 
    FeedbackDevice.RemoteSensor0, 
    100);	// Feedback Device of Remote Talon

    t4.configSensorTerm(SensorTerm.Diff0, 
    FeedbackDevice.QuadEncoder, 
    100);		// Quadrature Encoder of current Talon

    t4.configSelectedFeedbackSensor(	FeedbackDevice.SensorDifference, 
    1, 
    100);

    t1.config_kF(0, 0, 100);
    t1.config_kP(0, 0.2, 100);
    t1.config_kI(0, 0, 100);
    t1.config_kD(0, 0, 100);

    t4.config_kF(0, 0, 100);
    t4.config_kP(0, 0.2, 100);
    t4.config_kI(0, 0, 100);
    t4.config_kD(0, 0, 100);
   */


    t2 = new WPI_VictorSPX(RobotMap.leftMotort2);
    t3 = new WPI_VictorSPX(RobotMap.leftMotort3);
    t5 = new WPI_VictorSPX(RobotMap.rightMotort5);
    t6 = new WPI_VictorSPX(RobotMap.rigthMotort6);
 

    mGroupLeft = new SpeedControllerGroup(t1, t2, t3);
    mGroupRight = new SpeedControllerGroup(t4, t5, t6);

    mDrive = new DifferentialDrive(mGroupLeft, mGroupRight);


  }


  public void startDrive (double speed, double turn) {

    mDrive.arcadeDrive(speed, turn);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new c_teleopDrive());
  }
}
