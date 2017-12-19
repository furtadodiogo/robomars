package com.nasa.marsprojects.marsrobot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.nasa.marsprojects.marsrobot.MarsRobotApplication;
import com.nasa.marsprojects.marsrobot.service.RobotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarsRobotApplication.class)
@WebAppConfiguration
public class RobotControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private RobotService robotService;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    public void shouldMoveTo2X0South() throws Exception{
        mockMvc.perform(post("/mars/MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void shouldMoveTo0x2West() throws Exception{
        mockMvc.perform(post("/mars/MML"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void shouldValidateInvalidCommand() throws Exception{
        String messageError = messageSource.getMessage("error.command_invalid", null, null);

        mockMvc.perform(post("/mars/AAA"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }

    @Test
    public void shouldValidateExceedBondaryLimite() throws Exception {
        String messageError = messageSource.getMessage("error.exceeded_boundary", null, null);

        mockMvc.perform(post("/mars/MMMMMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }
    
    @Test
    public void shouldValidateInternalServerErrorException() throws Exception {
        String messageError = messageSource.getMessage("error.unexpected", null, null);
        robotService.setBoundaryValidator(null);
        mockMvc.perform(post("/mars/MM"))
        		.andExpect(status().isInternalServerError())
                .andExpect(content().string(messageError));
    }
}
