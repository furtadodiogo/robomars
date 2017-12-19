package com.nasa.marsprojects.marsrobot.parse;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasa.marsprojects.marsrobot.action.IAction;
import com.nasa.marsprojects.marsrobot.factory.ActionFactory;

@Component
public class CommandParse {
	
	private ActionFactory actionFactory;
	
	public List<IAction> parseToActions(final String command) {
		return command.chars()
						.mapToObj(act -> actionFactory.get((char) act))
						.collect(Collectors.toList());
	}
	
	@Autowired
	public void setActionFactory(ActionFactory actionFactory) {
		this.actionFactory = actionFactory;
	}

}
