package api.controller;


import api.dto.CustomerDto;
import api.services.ICustomerService;
import api.services.impl.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
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
    @Autowired
    private ICustomerService iCustomerService;

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
        long id=4;
        CustomerDto customerDto = new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setCustomerName("123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_name_6() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setCustomerName("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_name_7() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setCustomerName("Đình Quốc");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editPhone_Number_8() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setPhoneNumber("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPhone_Number_9() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setPhoneNumber("avc");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPhone_Number_10() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setPhoneNumber("0912457864");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editDate_Of_Birth_11() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setDateOfBirth("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editDate_Of_Birth_12() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setDateOfBirth("9999-99-99");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editDate_Of_Birth_13() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setDateOfBirth("1993-12-01");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editEmail_14() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setEmail("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmail_15() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setEmail("asdasdadas");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmail_16() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setEmail("hoangtu83@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editAdress_16() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setAddress("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editAdress_17() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setAddress("Đại học mở Hà Nội");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void editGender_19() throws Exception {
        long id=4;
        CustomerDto customerDto=new CustomerDto();
        doReturn(Optional.of(customerDto)).when(iCustomerService).findById(id);
        customerDto = new CustomerDto((long) 1,"Nguyễn Thái Việt", "0912456789","2022-10-12","hoangtn97@gmail.com","102 Điện Biên Phủ",true);
        customerDto.setGender(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customer/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
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
