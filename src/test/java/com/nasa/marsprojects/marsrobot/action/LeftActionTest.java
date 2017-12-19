package com.nasa.marsprojects.marsrobot.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.domain.Position;
import com.nasa.marsprojects.marsrobot.model.Coordinate;
import com.nasa.marsprojects.marsrobot.model.Robot;

public class LeftActionTest {

	private LeftAction leftAction;

	@Before
	public void setUp() {
		leftAction = new LeftAction();
	}

	@Test
	public void shouldReturnWestWhenNorth() {
		Robot robot = createRobot(Position.NORTH);
		leftAction.apply(robot);
		assertEquals(Position.WEST, robot.getPosition());
	}

	@Test
	public void shouldReturnEastWhenSouth() {
		Robot robot = createRobot(Position.SOUTH);
		leftAction.apply(robot);
		assertEquals(Position.EAST, robot.getPosition());
	}

	@Test
	public void shouldReturnNorthWhenEast() {
		Robot robot = createRobot(Position.EAST);
		leftAction.apply(robot);
		assertEquals(Position.NORTH, robot.getPosition());
	}

	@Test
	public void shouldReturnSouthWhenWeast() {
		Robot robot = createRobot(Position.WEST);
		leftAction.apply(robot);
		assertEquals(Position.SOUTH, robot.getPosition());
	}

	private Robot createRobot(Position position) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Robot(null, position, coordinate, "Test");
	}
}
