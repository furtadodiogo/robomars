package com.nasa.marsprojects.marsrobot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.domain.Position;
import com.nasa.marsprojects.marsrobot.exception.CommandInvalidException;
import com.nasa.marsprojects.marsrobot.exception.ExceededBoundaryException;
import com.nasa.marsprojects.marsrobot.factory.ActionFactory;
import com.nasa.marsprojects.marsrobot.factory.AreaFactory;
import com.nasa.marsprojects.marsrobot.factory.RobotFactory;
import com.nasa.marsprojects.marsrobot.model.Robot;
import com.nasa.marsprojects.marsrobot.parse.CommandParse;
import com.nasa.marsprojects.marsrobot.validator.BoundaryValidator;

public class RobotServiceTest {
	
	private static final Integer MAX_X_COORDINATE = 5;
	private static final Integer MAX_Y_COORDINATE = 5;
	private static final Integer COORDINATE_X_INIT = 0;
	private static final Integer COORDINATE_Y_INIT = 0;
	
	private RobotService robotService;
	
	@Before
	public void setUp() {
		robotService = new RobotService();
		setCommandParse();
		setBoundaryValidator();
		setRobotFactory();
	}
	
	@Test
	public void shouldMoveTo0X2SouthPosition() {
		String command = "MMRMMRMM";
		Robot robot = robotService.moveTo(command);
		assertEquals("(2, 0, S)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo0X2WestPosition() {
		String command = "MML";
		Robot robot = robotService.moveTo(command);
		assertEquals("(0, 2, W)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo1X3NorthPosition() {
		String command = "MMRMLM";
		Robot robot = robotService.moveTo(command);
		assertEquals("(1, 3, N)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo5X3SouthPosition() {
		String command = "MMRMLMMMRMMMMRMM";
		Robot robot = robotService.moveTo(command);
		assertEquals("(5, 3, S)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo5X0SouthPosition() {
		String command = "MMRMLMMMRMMMMRMMMMM";
		Robot robot = robotService.moveTo(command);
		assertEquals("(5, 0, S)", robot.toString());
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldThrowExceededBoundaryExceptionOnlyMoving() {
		String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
		robotService.moveTo(command);
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldThrowExceededBoundaryException() {
		String command = "MMRMLMMMLMM";
		robotService.moveTo(command);
	}
	
	@Test(expected = CommandInvalidException.class)
	public void shouldThrowCommandInvalidException() {
		String command = "AAA";
		robotService.moveTo(command);
	}

	private void setRobotFactory() {
		RobotFactory robotFactory = new RobotFactory();
		robotFactory.setCoordinateXInit(COORDINATE_X_INIT);
		robotFactory.setCoordinateYInit(COORDINATE_Y_INIT);
		robotFactory.setPosition(Position.NORTH);
		robotFactory.setId("Test");
		robotFactory.setAreaFactory(createAreaFactory());
		robotService.setRobotFactory(robotFactory);
	}

	private AreaFactory createAreaFactory() {
		AreaFactory areaFactory = new AreaFactory();
		areaFactory.setMaxXCoordinate(MAX_X_COORDINATE);
		areaFactory.setMaxYCoordinate(MAX_Y_COORDINATE);
		areaFactory.setMinXCoordinate(COORDINATE_X_INIT);
		areaFactory.setMinYCoordinate(COORDINATE_Y_INIT);
		return areaFactory;
	}

	private void setBoundaryValidator() {
		BoundaryValidator boundaryValidator = new BoundaryValidator();
		robotService.setBoundaryValidator(boundaryValidator);
	}

	private void setCommandParse() {
		CommandParse commandParse = new CommandParse();
		ActionFactory actionFactory= new ActionFactory();
		commandParse.setActionFactory(actionFactory);
		robotService.setCommandParse(commandParse);
	}
	
}
