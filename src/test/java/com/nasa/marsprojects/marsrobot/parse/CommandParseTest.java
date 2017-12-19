package com.nasa.marsprojects.marsrobot.parse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nasa.marsprojects.marsrobot.action.IAction;
import com.nasa.marsprojects.marsrobot.action.LeftAction;
import com.nasa.marsprojects.marsrobot.action.MoveAction;
import com.nasa.marsprojects.marsrobot.action.RightAction;
import com.nasa.marsprojects.marsrobot.exception.CommandInvalidException;
import com.nasa.marsprojects.marsrobot.factory.ActionFactory;

public class CommandParseTest {
	
	private CommandParse commandParse; 
	
	@Before
	public void setUp() {
		commandParse = new CommandParse();
		commandParse.setActionFactory(new ActionFactory());
	}
	
	@Test
    public void shouldBeAnInstanceOfLeftAction(){
        List<IAction> actions = commandParse.parseToActions("L");
        assertTrue(actions.get(0) instanceof LeftAction);
    }

    @Test
    public void shouldBeAnInstanceOfRightAction(){
        List<IAction> actions = commandParse.parseToActions("R");
        assertTrue(actions.get(0) instanceof RightAction);
    }

    @Test
    public void shouldBeAnInstanceOfMoveAction() throws Exception {
        List<IAction> actions = commandParse.parseToActions("M");
        assertTrue(actions.get(0) instanceof MoveAction);
    }

    @Test
    public void shouldContainThreeActions() throws Exception {
        List<IAction> actions = commandParse.parseToActions("MLR");
        assertEquals(actions.size(), 3);
    }

    @Test(expected = CommandInvalidException.class)
    public void shouldValidateInvalidCommand() throws Exception {
    	commandParse.parseToActions("MLARM");
    }
}
