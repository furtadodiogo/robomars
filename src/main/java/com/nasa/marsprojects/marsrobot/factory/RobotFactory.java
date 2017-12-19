package com.nasa.marsprojects.marsrobot.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nasa.marsprojects.marsrobot.domain.Position;
import com.nasa.marsprojects.marsrobot.model.Area;
import com.nasa.marsprojects.marsrobot.model.Coordinate;
import com.nasa.marsprojects.marsrobot.model.Robot;

@Component
public class RobotFactory {
	
	private AreaFactory areaFactory;
	
	private Integer coordinateXInit;
	
	private Integer coordinateYInit;
	
	private String id;
	
	private Position position;
	
	public Robot create() {
		Coordinate coordinate = new  Coordinate(coordinateXInit, coordinateYInit);
		Area area = areaFactory.create();
		return new Robot(area, position, coordinate, id);
	}
	
	@Autowired
	public void setAreaFactory(AreaFactory areaFactory) {
		this.areaFactory = areaFactory;
	}
	
	@Value("${robot.coordinate_x_init}")
	public void setCoordinateXInit(Integer coordinateXInit) {
		this.coordinateXInit = coordinateXInit;
	}
	
	@Value("${robot.coordinate_y_init}")
	public void setCoordinateYInit(Integer coordinateYInit) {
		this.coordinateYInit = coordinateYInit;
	}
	
	@Value("${robot.id}")
	public void setId(String id) {
		this.id = id;
	}
	
	@Value("${robot.init_position}")
	public void setPosition(Position position) {
		this.position = position;
	}
}
