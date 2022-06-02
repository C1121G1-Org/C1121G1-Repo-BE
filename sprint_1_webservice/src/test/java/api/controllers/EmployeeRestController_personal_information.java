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

    /*
         Test case 1: View personal information without login.
         Data: this method doesn't need input as it will get the account's personal information
               based on which account is logged in through the JWT code stored in the request header.
    */
    @Test
    public void view_personal_information_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/personal/information")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
         Test case 4: View personal information after login successfully.
         Data: this method doesn't need input as it will get the account's personal information
               based on which account is logged in through the JWT code stored in the request header.
    */
    @Test
    public void view_personal_information_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/public/personal/information")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFpcHJvIiwiaWF0IjoxNjU0MDc0NDIyLCJleHAiOjE2NTQwODMwNjJ9.7eppPqXVDbB5zBhoFJu5O9h7G8e69BXipQYTJN9XTpk")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /*
         Test case 20: Update personal information without enter name value.
         Data: {
                    id: 1,
                    name: "",
                    dateOfBirth: "2001-12-21",
                    address: "",
                    idCard: "",
                    image: "",
                    phoneNumber: "",
                }
          * address, idCard, image, phoneNumber are optional fields, can be empty.
    */
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

    /*
         Test case 24: Update personal information with valid name value.
         Data: {
                    id: 1,
                    name: "Khai",
                    dateOfBirth: "2001-12-21",
                    address: "",
                    idCard: "",
                    image: "",
                    phoneNumber: "",
                }
          * address, idCard, image, phoneNumber are optional fields, can be empty.
    */
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

    /*
         Test case 20: Update personal information without enter date of birth value.
         Data: {
                    id: 1,
                    name: "Khai",
                    dateOfBirth: "",
                    address: "",
                    idCard: "",
                    image: "",
                    phoneNumber: "",
                }
          * address, idCard, image, phoneNumber are optional fields, can be empty.
    */
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

    /*
         Test case 20: Update personal information with wrong format of date of birth, expect format of
                       date of birth is yyyy-MM-dd.
         Data: {
                    id: 1,
                    name: "Khai",
                    dateOfBirth: "2001/12/21",
                    address: "",
                    idCard: "",
                    image: "",
                    phoneNumber: "",
                }
          * address, idCard, image, phoneNumber are optional fields, can be empty.
    */
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

    /*
         Test case 24: Update personal information with valid date of birth format (yyyy-MM-dd).
         Data: {
                    id: 1,
                    name: "Khai",
                    dateOfBirth: "2001/12/21",
                    address: "",
                    idCard: "",
                    image: "",
                    phoneNumber: "",
                }
          * address, idCard, image, phoneNumber are optional fields, can be empty.
    */
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

    /*
        Test case 24: Update personal information with valid values but not logged in.
        Data: {
                   id: 1,
                   name: "Khai",
                   dateOfBirth: "2001/12/21",
                   address: "",
                   idCard: "",
                   image: "",
                   phoneNumber: "",
               }
         * address, idCard, image, phoneNumber are optional fields, can be empty.
   */
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
