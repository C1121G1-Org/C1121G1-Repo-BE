package api.controller;

import api.dto.AccountDto;
import api.dto.EmployeeDto;
import api.dto.PositionDto;
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


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_createEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_name_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        employeeDto.setPositionDto(positionDto);
        employeeDto.setAccountDto(accountDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
