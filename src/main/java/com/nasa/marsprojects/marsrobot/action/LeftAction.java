package com.nasa.marsprojects.marsrobot.action;

import com.nasa.marsprojects.marsrobot.model.Robot;

public class LeftAction implements IAction{

	@Override
	public void apply(Robot robot) {
		robot.setPosition(robot.getPosition().getLeft());
	}
}
