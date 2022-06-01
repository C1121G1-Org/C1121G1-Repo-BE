package api.controllers;

import api.payload.request.ChangePasswordRequest;
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
    Date: 18:53 01/06/2022
    Function: Test view and change personal information
*/
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_change_password_personal {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void change_password_curent_pasword_14() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("");
        changePasswordRequest.setNewPassword("123456");
        changePasswordRequest.setConfirmNewPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
        Test case 30: check if the password sent by the client matches the password stored in the DB
    */
    @Test
    public void change_password_curent_pasword_30() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123");
        changePasswordRequest.setNewPassword("123456");
        changePasswordRequest.setConfirmNewPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDc0NDIyLCJleHAiOjE2NTQwODMwNjJ9.7eppPqXVDbB5zBhoFJu5O9h7G8e69BXipQYTJN9XTpk")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void change_password_curent_pasword_24() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123456");
        changePasswordRequest.setNewPassword("Codegym@123456");
        changePasswordRequest.setConfirmNewPassword("Codegym@123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void change_password_new_password_20() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123456");
        changePasswordRequest.setNewPassword("");
        changePasswordRequest.setConfirmNewPassword("Codegym@123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void change_password_new_password_21() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123456");
        changePasswordRequest.setNewPassword("abc");
        changePasswordRequest.setConfirmNewPassword("Codegym@123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void change_password_comfirm_new_password_20() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123456");
        changePasswordRequest.setNewPassword("Codegym@1234");
        changePasswordRequest.setConfirmNewPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void change_password_comfirm_new_password_21() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123456");
        changePasswordRequest.setNewPassword("Codegym@1234");
        changePasswordRequest.setConfirmNewPassword("abc");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }
}
