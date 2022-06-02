package api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_deleteEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDeleteEmployee_id_25() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDeleteEmployee_id_26() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDeleteEmployee_id_27() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/delete/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDeleteEmployee_id_28() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(15))
                .andExpect(jsonPath("$.content[1].employeeName").value("Tuấn Anh"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1990-05-06"))
                .andExpect(jsonPath("$.content[1].address").value("Hòa Khánh"))
                .andExpect(jsonPath("$.content[1].idCard").value("193444333"))
                .andExpect(jsonPath("$.content[1].phoneNumber").value("0905434756"))
                .andExpect(jsonPath("$.content[1].image").value("url"))
                .andExpect(jsonPath("$.content[1].position.id").value(2))
                .andExpect(jsonPath("$.content[1].account.id").value(1));
    }

}
