package com.nasa.marsprojects.marsrobot.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.nasa.marsprojects.marsrobot.action.IAction;
import com.nasa.marsprojects.marsrobot.action.LeftAction;
import com.nasa.marsprojects.marsrobot.action.MoveAction;
import com.nasa.marsprojects.marsrobot.action.RightAction;
import com.nasa.marsprojects.marsrobot.exception.CommandInvalidException;

@Component
public class ActionFactory {
	
	private static final Character LEFT = 'L';
	private static final Character MOVE = 'M';
	private static final Character RIGHT = 'R';
	
	private static Map<Character, IAction> actions = registerActions();
	
	public ActionFactory() {
	}

	public IAction get(final char code) {
		IAction action = actions.get(code);
		if(ObjectUtils.isEmpty(action)) {
			throw new CommandInvalidException();
		}
		return action;
	}
	
	private static Map<Character, IAction> registerActions() {
		actions = new HashMap<>();
		actions.put(LEFT, new LeftAction());
		actions.put(RIGHT, new RightAction());
		actions.put(MOVE, new MoveAction());
		return actions;
	}
}
