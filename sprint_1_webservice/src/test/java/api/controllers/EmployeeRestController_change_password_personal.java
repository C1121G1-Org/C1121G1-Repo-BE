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

    /*
         Test case 20: Change password without enter current password value.
         Data: currentPassword: "",
               newPassword: "123456",
               confirmNewPassword: "123456"
    */
    @Test
    public void change_password_curent_pasword_20() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("");
        changePasswordRequest.setNewPassword("123456");
        changePasswordRequest.setConfirmNewPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDk1NDU1LCJleHAiOjE2NTQxMDQwOTV9.D-moUrl8itiM1ORlvSGnqSLnsa8jX4PoBsw4Lox8aU8")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
         Test case 30: Change password with wrong password, correct password: "123456".
         Data: currentPassword: "123",
               newPassword: "654321",
               confirmNewPassword: "654321"
    */
    @Test
    public void change_password_curent_pasword_21() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setCurrentPassword("123");
        changePasswordRequest.setNewPassword("123456");
        changePasswordRequest.setConfirmNewPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/change-password")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDc0NDIyLCJleHAiOjE2NTQwODMwNjJ9.7eppPqXVDbB5zBhoFJu5O9h7G8e69BXipQYTJN9XTpk")
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
         Test case 24: Change password with correct password.
         Data: currentPassword: "123456",
               newPassword: "654321",
               confirmNewPassword: "654321"
    */
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

    /*
         Test case 20: Change password with correct password but no enter new password value.
         Data: currentPassword: "123456",
               newPassword: "",
               confirmNewPassword: "Codegym@123456"
    */
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
                .andExpect(status().is4xxClientError());
    }

    /*
         Test case 21: Change password with correct password but new password value don't match
                       comfirm new password value.
         Data: currentPassword: "123456",
               newPassword: "abc",
               confirmNewPassword: "Codegym@123456"
    */
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
                .andExpect(status().is4xxClientError());
    }

    /*
         Test case 20: Change password with correct password but no enter comfirm new password.
         Data: currentPassword: "123456",
               newPassword: "Codegym@1234",
               confirmNewPassword: ""
    */
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
                .andExpect(status().is4xxClientError());
    }

    /*
         Test case 21: Change password with correct password but comfirm new password value don't match
                       new password value,
               newPassword: "Codegym@1234",
               confirmNewPassword: ""
    */
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
                .andExpect(status().is4xxClientError());
    }
}
