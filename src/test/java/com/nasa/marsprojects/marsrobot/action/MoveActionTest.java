package com.nasa.marsprojects.marsrobot.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.domain.Position;
import com.nasa.marsprojects.marsrobot.model.Coordinate;
import com.nasa.marsprojects.marsrobot.model.Robot;

public class MoveActionTest {

	private MoveAction moveAction;
	
	@Before
    public void setUp() {
        moveAction = new MoveAction();
    }
	
	@Test
	public void shouldWhenNorthIncreaseY() {
		Robot robot = createRobot(Position.NORTH);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(1), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldWhenEastIncreaseX() {
		Robot robot = createRobot(Position.EAST);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(1), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldWhenSouthDecrementY() {
		Robot robot = createRobot(Position.SOUTH);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(-1), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldWhenWestDecrementX() {
		Robot robot = createRobot(Position.WEST);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(-1), robot.getCoordinate().getX());
	}
	
	private Robot createRobot(Position position) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Robot(null, position,coordinate, "Test");
	}
}
