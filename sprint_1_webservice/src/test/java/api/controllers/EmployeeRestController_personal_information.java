package api.controllers;

import api.dto.PersonalDto;
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
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/personal/information")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void view_personal_information_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/personal/information")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDc0NDIyLCJleHAiOjE2NTQwODMwNjJ9.7eppPqXVDbB5zBhoFJu5O9h7G8e69BXipQYTJN9XTpk")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void update_personal_information_name_20() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        personalDto.setId(1L);
        personalDto.setEmployeeName("");
        personalDto.setDateOfBirth("2001-12-21");
        personalDto.setAddress("");
        personalDto.setIdCard("");
        personalDto.setImage("");
        personalDto.setPhoneNumber("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/information/update")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDgxOTYxLCJleHAiOjE2NTQwOTA2MDF9.nbfktcgCI_oMx3KljKBflb3eBz7HgoDM5hm0Nxxyd_0")
                        .content(this.objectMapper.writeValueAsString(personalDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void update_personal_information_name_24() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        personalDto.setId(1L);
        personalDto.setEmployeeName("Khai");
        personalDto.setDateOfBirth("2001-12-21");
        personalDto.setAddress("");
        personalDto.setIdCard("");
        personalDto.setImage("");
        personalDto.setPhoneNumber("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/information/update")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDgxOTYxLCJleHAiOjE2NTQwOTA2MDF9.nbfktcgCI_oMx3KljKBflb3eBz7HgoDM5hm0Nxxyd_0")
                        .content(this.objectMapper.writeValueAsString(personalDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void update_personal_information_date_of_birth_20() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        personalDto.setId(1L);
        personalDto.setEmployeeName("Khai");
        personalDto.setDateOfBirth("");
        personalDto.setAddress("");
        personalDto.setIdCard("");
        personalDto.setImage("");
        personalDto.setPhoneNumber("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/information/update")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDgxOTYxLCJleHAiOjE2NTQwOTA2MDF9.nbfktcgCI_oMx3KljKBflb3eBz7HgoDM5hm0Nxxyd_0")
                        .content(this.objectMapper.writeValueAsString(personalDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void update_personal_information_date_of_birth_21() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        personalDto.setId(1L);
        personalDto.setEmployeeName("Khai");
        personalDto.setDateOfBirth("2001/12/21");
        personalDto.setAddress("");
        personalDto.setIdCard("");
        personalDto.setImage("");
        personalDto.setPhoneNumber("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/information/update")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDgxOTYxLCJleHAiOjE2NTQwOTA2MDF9.nbfktcgCI_oMx3KljKBflb3eBz7HgoDM5hm0Nxxyd_0")
                        .content(this.objectMapper.writeValueAsString(personalDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void update_personal_information_date_of_birth_24() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        personalDto.setId(1L);
        personalDto.setEmployeeName("Khai");
        personalDto.setDateOfBirth("2001-12-21");
        personalDto.setAddress("");
        personalDto.setIdCard("");
        personalDto.setImage("");
        personalDto.setPhoneNumber("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/information/update")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDgxOTYxLCJleHAiOjE2NTQwOTA2MDF9.nbfktcgCI_oMx3KljKBflb3eBz7HgoDM5hm0Nxxyd_0")
                        .content(this.objectMapper.writeValueAsString(personalDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void update_personal_information_date_of_birth() throws Exception {
        PersonalDto personalDto = new PersonalDto();
        personalDto.setId(1L);
        personalDto.setEmployeeName("Khai");
        personalDto.setDateOfBirth("2001-12-21");
        personalDto.setAddress("");
        personalDto.setIdCard("");
        personalDto.setImage("");
        personalDto.setPhoneNumber("");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/public/personal/information/update")
                        .content(this.objectMapper.writeValueAsString(personalDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
