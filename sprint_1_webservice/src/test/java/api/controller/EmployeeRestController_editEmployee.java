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
public class EmployeeRestController_editEmployee  {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //test cho trường hợp item name
    @Test
    public void editEmployee_name_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("Khoa@abc");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("a");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    // test trường hợp cho item DateOfBirth
    @Test
    public void editEmployee_dateOfBirth_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
//    employeeDto.setDateOfBirth("01/01/1998");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_dateOfBirth_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_dateOfBirth_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("Khoa@abc");
        employeeDto.setDateOfBirth("01/01/2019");//không đủ 18 tuổi
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void editEmployee_dateOfBirth_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // test cho item address
    @Test
    public void editEmployee_address_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
//        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_address_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void editEmployee_address_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("a");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("1");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_address_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101qưeqaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadddddddddddddddddddddddddddddddddddd");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_address_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101 Nguyễn lương bằng");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // test cho trường item Image

    @Test
    public void editEmployee_image_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/1998");
        employeeDto.setAddress("101");
//        employeeDto.setImage("");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_Image_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("");
        employeeDto.setAddress("101");
        employeeDto.setImage("");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editEmployee_Image_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101 Nguyễn lương bằng");
        employeeDto.setImage("https://firebasestorage.googleapis.com/v0/b/product-37dbb.appspot.com/o/26-05-2022055604PMitachi.webp?alt=media&token=73ab589f-9177-4600-abc3-1dd30c8bb79b");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // TEST cho item iphone
    @Test
    public void editEmployee_phoneNumber_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
//        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phoneNumber_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phoneNumber_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("Khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("090539hdidjd");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phoneNumber_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("09053");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phoneNumber_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phoneNumber_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101");
        employeeDto.setImage("abjjbjbjhbjc");
        employeeDto.setPhoneNumber("0905098098");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // test cho trường item IdCard

    @Test
    public void editEmployee_IdCard_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/1998");
        employeeDto.setAddress("101");
        employeeDto.setImage("lkjhgfdsa");
        employeeDto.setPhoneNumber("0905393839");
//        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_IdCard_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/1998");
        employeeDto.setAddress("101");
        employeeDto.setImage("uiytreeeeeqwre");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_IdCard_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/1998");
        employeeDto.setAddress("101");
        employeeDto.setImage("uiytreeeeeqwre");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048202000199abc");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editEmployee_idCard_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101 Nguyễn lương bằng");
        employeeDto.setImage("https://firebasestorage.googleapis.com/v0/b/product-37dbb.appspot.com/o/26-05-2022055604PMitachi.webp?alt=media&token=73ab589f-9177-4600-abc3-1dd30c8bb79b");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048202000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // test cho trường item chọn position

    @Test
    public void editEmployee_Position_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/1998");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
//        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_Position_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(0);
        positionDto.setPositionName("");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editEmployee_Position_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("01/01/2002");
        employeeDto.setAddress("101 Nguyễn lương bằng");
        employeeDto.setImage("https://firebasestorage.googleapis.com/v0/b/product-37dbb.appspot.com/o/26-05-2022055604PMitachi.webp?alt=media&token=73ab589f-9177-4600-abc3-1dd30c8bb79b");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // test cho item email
    @Test
    public void editEmployee_Email_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
//        accountDto.setEmail("khoa@gmail.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_Email_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_Email_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editEmployee_Email_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    // test cho item user name
    @Test
    public void editEmployee_userName_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
//        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError() );
    }
    @Test
    public void editEmployee_UserName_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_userName_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful() );
    }

    // test cho item pass work
    @Test
    public void ceditEmployee_passWord_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("khai");
//        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError() );
    }
    @Test
    public void editEmployee_passWord_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_passWord_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        PositionDto positionDto = new PositionDto();
        AccountDto accountDto = new AccountDto();
        employeeDto.setEmployeeName("khoa");
        employeeDto.setDateOfBirth("24/11/2003");
        employeeDto.setAddress("101");
        employeeDto.setImage("abcbcbcb");
        employeeDto.setPhoneNumber("0905393839");
        employeeDto.setIdCard("048879000199");
        positionDto.setId(1);
        positionDto.setPositionName("Quản lý");
        accountDto.setId(Long.valueOf(1));
        accountDto.setEmail("khoa.com");
        accountDto.setUserName("khai");
        accountDto.setEncryptPassword("123123");
        accountDto.setIsEnabled(true);
        accountDto.setVerificationCode("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful() );
    }



}
