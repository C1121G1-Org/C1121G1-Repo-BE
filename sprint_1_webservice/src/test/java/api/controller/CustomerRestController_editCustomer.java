package api.controller;


import api.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_editCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getInfoCustomer_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/customer/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Le Van C"))
                .andExpect(jsonPath("$.dateOfBirth").value("2022-06-02"))
                .andExpect(jsonPath("$.classStudent.id").value(12));
    }


    /*@Test
    public void editStudent_name_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Đặng Văn Huy");
        customerDto.set(8.0);
        customerDto.setDateOfBirth("2000-10-05");
        customerDto.setGender(1);

        ClassStudentDto classStudentDto = new ClassStudentDto();
        classStudentDto.setId(2);
        customerDto.setClassStudentDto(classStudentDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStudent_18() throws Exception {

        StudentDto studentDto = new StudentDto();
        studentDto.setName("Nguyễn Văn An");
        studentDto.setGrade(8.0);
        studentDto.setDateOfBirth("2000-10-05");
        studentDto.setGender(1);

        ClassStudentDto classStudentDto = new ClassStudentDto();
        classStudentDto.setId(2);
        studentDto.setClassStudentDto(classStudentDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }*/
}
