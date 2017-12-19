package com.nasa.marsprojects.marsrobot.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.domain.Position;
import com.nasa.marsprojects.marsrobot.model.Coordinate;
import com.nasa.marsprojects.marsrobot.model.Robot;

public class RightActionTest {
	
	private RightAction rightAction;

	@Before
	public void setUp() {
		rightAction = new RightAction();
	}

	@Test
	public void shouldReturnEastWhenNorth() {
		Robot robot = createRobot(Position.NORTH);
		rightAction.apply(robot);
		assertEquals(Position.EAST, robot.getPosition());
	}

	@Test
	public void shouldReturnWeastWhenSouth() {
		Robot robot = createRobot(Position.SOUTH);
		rightAction.apply(robot);
		assertEquals(Position.WEST, robot.getPosition());
	}

	@Test
	public void shouldReturnSouthWhenEast() {
		Robot robot = createRobot(Position.EAST);
		rightAction.apply(robot);
		assertEquals(Position.SOUTH, robot.getPosition());
	}

	@Test
	public void shouldReturNorthWhenWest() {
		Robot robot = createRobot(Position.WEST);
		rightAction.apply(robot);
		assertEquals(Position.NORTH, robot.getPosition());
	}

	private Robot createRobot(Position position) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Robot(null, position, coordinate, "Test");
	}
}
