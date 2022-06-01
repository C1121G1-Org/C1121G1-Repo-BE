package api.controllers;

import api.dto.PersonalDto;
import api.payload.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
    Created by Trinh Khai
    Date: 14:59 01/06/2022
    Function: Test view and change personal information
*/
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_personal_information {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void view_personal_information_1() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        loginRequest.setPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
