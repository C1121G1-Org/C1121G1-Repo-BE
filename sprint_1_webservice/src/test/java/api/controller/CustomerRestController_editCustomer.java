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
    public void getInfoCustomer_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/studentRest/detail/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerName").value("Nguyễn Thái Việt"))
                .andExpect(jsonPath("$.phoneNumber").value("0912456789"))
                .andExpect(jsonPath("$.dateOfBirth").value("2022-10-12"))
                .andExpect(jsonPath("$.email").value("hoangtn97@gmail.com"))
                .andExpect(jsonPath("$.address").value("102 Điện Biên Phủ"))
                .andExpect(jsonPath("$.gender").value(1));
    }

    @Test
    public void editCustomer_name_5() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto=
        customerDto.setCustomerName("Du");
        customerDto.setGrade(8.0);
        customerDto.setDateOfBirth("2000-10-05");
        customerDto.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
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
