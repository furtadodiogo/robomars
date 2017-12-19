package com.nasa.marsprojects.marsrobot.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nasa.marsprojects.marsrobot.model.Area;
import com.nasa.marsprojects.marsrobot.model.Coordinate;

@Component
public class AreaFactory {
	
	private Integer maxYCoordinate;
	
	private Integer maxXCoordinate;
	
	private Integer minYCoordinate;
	
	private Integer minXCoordinate;

	public Area create(){
		Coordinate top = new Coordinate(maxXCoordinate, maxYCoordinate);
		Coordinate base = new Coordinate(minXCoordinate, minYCoordinate);
		return new Area(top, base);
	}
	
	@Value("${area.max_x_coordinate_size}")
	public void setMaxXCoordinate(Integer maxXCoordinate) {
		this.maxXCoordinate = maxXCoordinate;
	}
	
	@Value("${area.max_y_coordinate_size}")
	public void setMaxYCoordinate(Integer maxYCoordinate) {
		this.maxYCoordinate = maxYCoordinate;
	}
	
	@Value("${area.min_x_coordinate_size}")
	public void setMinXCoordinate(Integer minXCoordinate) {
		this.minXCoordinate = minXCoordinate;
	}
	
	@Value("${area.min_y_coordinate_size}")
	public void setMinYCoordinate(Integer minYCoordinate) {
		this.minYCoordinate = minYCoordinate;
	}
}
