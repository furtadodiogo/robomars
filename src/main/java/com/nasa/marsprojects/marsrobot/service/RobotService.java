package com.nasa.marsprojects.marsrobot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasa.marsprojects.marsrobot.factory.RobotFactory;
import com.nasa.marsprojects.marsrobot.model.Robot;
import com.nasa.marsprojects.marsrobot.parse.CommandParse;
import com.nasa.marsprojects.marsrobot.validator.BoundaryValidator;

@Component
public class RobotService {

	private CommandParse commandParse;
	
	private BoundaryValidator boundaryValidator;
	
	private RobotFactory robotFactory;
	
	public Robot moveTo(final String command) {
		Robot robot = robotFactory.create();
			commandParse.parseToActions(command)
						.forEach(action ->{
							action.apply(robot);
							boundaryValidator.validateBoundary(robot.getArea(), robot.getCoordinate());
						});
		return robot;
	}
	
	@Autowired
	public void setBoundaryValidator(BoundaryValidator boundaryValidator) {
		this.boundaryValidator = boundaryValidator;
	}
	
	@Autowired
	public void setCommandParse(CommandParse commandParse) {
		this.commandParse = commandParse;
	}
	
	@Autowired
	public void setRobotFactory(RobotFactory robotFactory) {
		this.robotFactory = robotFactory;
	}
}
