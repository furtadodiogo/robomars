package com.nasa.marsprojects.marsrobot.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.domain.Position;
import com.nasa.marsprojects.marsrobot.model.Area;
import com.nasa.marsprojects.marsrobot.model.Coordinate;
import com.nasa.marsprojects.marsrobot.model.Robot;

public class RobotFactoryTest {
	
	private RobotFactory robotFactory;
	
	@Before
	public void setUp() {
		initRobotFactory();
	}
	
	@Test
	public void shouldCreateARobot() {
		assertNotNull(robotFactory.create());
	}
	
	@Test
	public void shouldCreateARobotWithXAndYInitAsZero() {
		Robot robot = robotFactory.create();
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
	}
	
	
	@Test
	public void shouldCreateARobotWithPositionNorth() {
		Robot robot = robotFactory.create();
		assertEquals(Position.NORTH, robot.getPosition());
	}
	
	@Test
	public void shouldCreateARobotWithAreaWithBaseAsZero() {
		Robot robot = robotFactory.create();
		assertEquals(Integer.valueOf(0), robot.getArea().getBaseOfArea().getX());
		assertEquals(Integer.valueOf(0), robot.getArea().getBaseOfArea().getY());
	}
	
	@Test
	public void shouldCreateARobotWithAreaWithTopAsFive() {
		Robot robot = robotFactory.create();
		assertEquals(Integer.valueOf(5), robot.getArea().getTopOfArea().getX());
		assertEquals(Integer.valueOf(5), robot.getArea().getTopOfArea().getY());
	}
	
	@Test
	public void shouldCreateARobotWithIdEqualTest() {
		Robot robot = robotFactory.create();
		assertEquals("Test", robot.getId());
	}

	private void initRobotFactory() {
		robotFactory = new RobotFactory();
		robotFactory.setId("Test");
		robotFactory.setCoordinateXInit(0);
		robotFactory.setCoordinateYInit(0);
		robotFactory.setPosition(Position.NORTH);
		robotFactory.setAreaFactory(createMockAreaFactory());
	}

	private AreaFactory createMockAreaFactory() {
		AreaFactory areaFactory = mock(AreaFactory.class);
		Coordinate topOfArea = new Coordinate(5, 5);
		Coordinate baseOfArea = new Coordinate(0, 0);
		when(areaFactory.create()).thenReturn(new Area(topOfArea, baseOfArea));
		return areaFactory;
	}
	
}
