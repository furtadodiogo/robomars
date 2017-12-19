package com.nasa.marsprojects.marsrobot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.marsprojects.marsrobot.model.Robot;
import com.nasa.marsprojects.marsrobot.service.RobotService;

@RestController
@RequestMapping("/mars")
public class RobotController {
	
	@Autowired
    private RobotService robotService;

    @RequestMapping(value = "{command}", method = RequestMethod.POST)
    public ResponseEntity<?> moveTo(@PathVariable final String command) {
        Robot robot = robotService.moveTo(command);
        return ResponseEntity.ok(robot.toString());
    }
}
