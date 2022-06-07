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
public class EmployeeRestController_getListEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListEmployee_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListEmployee_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(15))
                .andExpect(jsonPath("$.content[3].employeeName").value("Lê Ngọc Ánh"))
                .andExpect(jsonPath("$.content[3].dateOfBirth").value("2000-05-19"))
                .andExpect(jsonPath("$.content[3].address").value("Hòa Khánh"))
                .andExpect(jsonPath("$.content[3].idCard").value("194543332"))
                .andExpect(jsonPath("$.content[3].phoneNumber").value("194543332"))
                .andExpect(jsonPath("$.content[3].image").value("url"))
                .andExpect(jsonPath("$.content[3].position.id").value(3))
                .andExpect(jsonPath("$.content[3].account.id").value(3));

    }
}
