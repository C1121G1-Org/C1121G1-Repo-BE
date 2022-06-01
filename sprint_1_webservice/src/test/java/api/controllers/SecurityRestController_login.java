package api.controllers;

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
    Created by KhaiTT
    Date: 14:26 01/06/2022
    Function: Test login.
*/
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityRestController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void login_username_1() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_1() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khaipro");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_2() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_2() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khaipro");
        loginRequest.setPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_3() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khaivip");
        loginRequest.setPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_3() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khaipro");
        loginRequest.setPassword("12345678");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_password_4() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khaipro");
        loginRequest.setPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
