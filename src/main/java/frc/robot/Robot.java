// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


import edu.wpi.first.wpilibj.PowerDistribution;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

// pdp
private final PowerDistribution m_pdp = new PowerDistribution();


	private Command m_autonomousCommand;

	private RobotContainer m_robotContainer;

	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {
		// Instantiate our RobotContainer.  This will perform all our button bindings, and put our
		// autonomous chooser on the dashboard.
		m_robotContainer = new RobotContainer();

		SmartDashboard.putData("Swerve Odometry", m_robotContainer.getField());		
	}

	/**
	 * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
	 * that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before LiveWindow and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		// Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
		// commands, running already-scheduled commands, removing finished or interrupted commands,
		// and running subsystem periodic() methods.  This must be called from the robot's periodic
		// block in order for anything in the Command-based framework to work.
		CommandScheduler.getInstance().run();
	}

	/** This function is called once each time the robot enters Disabled mode. */
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {

		updateToSmartDash();
	}

	/** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_robotContainer.getAutonomousCommand();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.schedule();
		}
	}

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {

		updateToSmartDash();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {

		updateToSmartDash();
	}

	public void updateToSmartDash()
	{
       /*
     * Get the current going through channel 7, in Amperes. The PDP returns the
     * current in increments of 0.125A. At low currents
     * the current readings tend to be less accurate.
     */
    SmartDashboard.putNumber("Current Channel 1", m_pdp.getCurrent(1));
    SmartDashboard.putNumber("Current Channel 2", m_pdp.getCurrent(2));
    SmartDashboard.putNumber("Current Channel 3", m_pdp.getCurrent(3));
    SmartDashboard.putNumber("Current Channel 4", m_pdp.getCurrent(4));
    SmartDashboard.putNumber("Current Channel 5", m_pdp.getCurrent(5));
    SmartDashboard.putNumber("Current Channel 6", m_pdp.getCurrent(6));
    SmartDashboard.putNumber("Current Channel 7", m_pdp.getCurrent(7));
    SmartDashboard.putNumber("Current Channel 8", m_pdp.getCurrent(8));
    SmartDashboard.putNumber("Current Channel 9", m_pdp.getCurrent(9));
    SmartDashboard.putNumber("Current Channel 10", m_pdp.getCurrent(10));
    SmartDashboard.putNumber("Current Channel 11", m_pdp.getCurrent(11));
    SmartDashboard.putNumber("Current Channel 12", m_pdp.getCurrent(12));
    SmartDashboard.putNumber("Current Channel 13", m_pdp.getCurrent(13));
    SmartDashboard.putNumber("Current Channel 14", m_pdp.getCurrent(14));
    SmartDashboard.putNumber("Current Channel 15", m_pdp.getCurrent(15));
    /*
     * Get the voltage going into the PDP, in Volts.
     * The PDP returns the voltage in increments of 0.05 Volts.
     */
    SmartDashboard.putNumber("Voltage", m_pdp.getVoltage());
    /*
     * Retrieves the temperature of the PDP, in degrees Celsius.
     */
    SmartDashboard.putNumber("Temperature", m_pdp.getTemperature());

		SmartDashboard.putNumber("FrontLeftDrivingEncoderPosition", m_robotContainer.getDrive().getFrontLeftModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("FrontLeftTurningEncoderPosition", m_robotContainer.getDrive().getFrontLeftModule().getTurningEncoder().getPosition());
		
		SmartDashboard.putNumber("RearLeftDrivingEncoderPosition", m_robotContainer.getDrive().getRearLeftModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("RearLeftTurningEncoderPosition", m_robotContainer.getDrive().getRearLeftModule().getTurningEncoder().getPosition());
		
		SmartDashboard.putNumber("FrontRightDrivingEncoderPosition", m_robotContainer.getDrive().getFrontRightModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("FrontRightTurningEncoderPosition", m_robotContainer.getDrive().getFrontRightModule().getTurningEncoder().getPosition());
		
		SmartDashboard.putNumber("RearRightDrivingEncoderPosition", m_robotContainer.getDrive().getRearRightModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("RearRightTurningEncoderPosition", m_robotContainer.getDrive().getRearRightModule().getTurningEncoder().getPosition());
	
		SmartDashboard.putNumber("FrontLeftTurningAbsoluteEncoderPosition", m_robotContainer.getDrive().getFrontLeftModule().getTurningAbsoluteEncoder().getPosition());
		SmartDashboard.putNumber("RearLeftTurningAbsoluteEncoderPosition", m_robotContainer.getDrive().getRearLeftModule().getTurningAbsoluteEncoder().getPosition());
		SmartDashboard.putNumber("FrontRightTurningAbsoluteEncoderPosition", m_robotContainer.getDrive().getFrontRightModule().getTurningAbsoluteEncoder().getPosition());
		SmartDashboard.putNumber("RearRightTurningAbsoluteEncoderPosition", m_robotContainer.getDrive().getRearRightModule().getTurningAbsoluteEncoder().getPosition());

		SmartDashboard.putNumber("FrontLeftTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrive().getFrontLeftModule().getTurningAbsoluteEncoder().getVirtualPosition());
		SmartDashboard.putNumber("RearLeftTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrive().getRearLeftModule().getTurningAbsoluteEncoder().getVirtualPosition());
		SmartDashboard.putNumber("FrontRightTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrive().getFrontRightModule().getTurningAbsoluteEncoder().getVirtualPosition());
		SmartDashboard.putNumber("RearRightTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrive().getRearRightModule().getTurningAbsoluteEncoder().getVirtualPosition());
	
		SmartDashboard.putNumber("FrontLeftTurningDesiredState", m_robotContainer.getDrive().getFrontLeftModule().getDesiredState().angle.getRadians());
		SmartDashboard.putNumber("RearLeftTurningDesiredState", m_robotContainer.getDrive().getRearLeftModule().getDesiredState().angle.getRadians());
		SmartDashboard.putNumber("FrontRightTurningDesiredState", m_robotContainer.getDrive().getFrontRightModule().getDesiredState().angle.getRadians());
		SmartDashboard.putNumber("RearRightTurningDesiredState", m_robotContainer.getDrive().getRearRightModule().getDesiredState().angle.getRadians());

		/* Display 6-axis Processed Angle Data                                      */
		SmartDashboard.putBoolean(  "IMU_Connected",        m_robotContainer.getDrive().getImu().isConnected());
		SmartDashboard.putBoolean(  "IMU_IsCalibrating",    m_robotContainer.getDrive().getImu().isCalibrating());
		SmartDashboard.putNumber(   "IMU_Yaw",              m_robotContainer.getDrive().getImu().getYaw());
		SmartDashboard.putNumber(   "IMU_Pitch",            m_robotContainer.getDrive().getImu().getPitch());
		SmartDashboard.putNumber(   "IMU_Roll",             m_robotContainer.getDrive().getImu().getRoll());
		SmartDashboard.putNumber(   "IMU_CompassHeading",   m_robotContainer.getCompassHeading());

		m_robotContainer.getField().setRobotPose(m_robotContainer.getDrive().getPose());
	}

	@Override
	public void testInit() {
		// Cancels all running commands at the start of test mode.
		CommandScheduler.getInstance().cancelAll();
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {}
}