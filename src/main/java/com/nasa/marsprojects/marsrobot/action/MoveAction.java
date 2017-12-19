package com.nasa.marsprojects.marsrobot.action;

import com.nasa.marsprojects.marsrobot.model.Robot;

public class MoveAction implements IAction{

	@Override
	public void apply(Robot robot) {
		Integer oldXCoordinate = robot.getCoordinate().getX();
		Integer oldYCoordinate = robot.getCoordinate().getY();
		robot.getCoordinate().setX(oldXCoordinate + robot.getPosition().getValueToIncreaseX());
		robot.getCoordinate().setY(oldYCoordinate + robot.getPosition().getValueToIncreaseY());
	}

}
