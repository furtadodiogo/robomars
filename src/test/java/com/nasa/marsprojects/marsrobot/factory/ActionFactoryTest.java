package com.nasa.marsprojects.marsrobot.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.action.IAction;
import com.nasa.marsprojects.marsrobot.action.LeftAction;
import com.nasa.marsprojects.marsrobot.action.MoveAction;
import com.nasa.marsprojects.marsrobot.action.RightAction;
import com.nasa.marsprojects.marsrobot.exception.CommandInvalidException;

public class ActionFactoryTest {
	
	private static final Character LEFT = 'L';
	private static final Character MOVE = 'M';
	private static final Character RIGHT = 'R';
	private static final Character UNKNOW_COMMAND = 'A';
	
	private ActionFactory actionFactory;
	
	@Before
	public void setUp() {
		actionFactory = new ActionFactory();
	}
	
	@Test
	public void shouldReturnLeftActionInstance() {
		IAction action = actionFactory.get(LEFT);
		assertEquals(Boolean.TRUE, (action instanceof LeftAction));
	}
	
	@Test
	public void shouldReturnRightActionInstance() {
		IAction action = actionFactory.get(RIGHT);
		assertEquals(Boolean.TRUE, (action instanceof RightAction));
	}
	
	@Test
	public void shouldReturnMoveActionInstance() {
		IAction action = actionFactory.get(MOVE);
		assertEquals(Boolean.TRUE, (action instanceof MoveAction));
	}
	
	@Test(expected = CommandInvalidException.class)
	public void shouldThrowCommandInvalidException() {
		actionFactory.get(UNKNOW_COMMAND);
	}
}
