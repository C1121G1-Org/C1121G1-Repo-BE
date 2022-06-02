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

    //test id=null, return error
    @Test
    public void getInfoCustomer_id_null() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test id="", return error
    @Test
    public void getInfoCustomer_id_empty() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //test id=4, return object
    @Test
    public void getInfoCustomer_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Customer/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerName").value("Nguyễn Thái Việt"))
                .andExpect(jsonPath("$.phoneNumber").value("0912456789"))
                .andExpect(jsonPath("$.dateOfBirth").value("2022-10-12"))
                .andExpect(jsonPath("$.email").value("hoangtn97@gmail.com"))
                .andExpect(jsonPath("$.address").value("102 Điện Biên Phủ"))
                .andExpect(jsonPath("$.gender").value(1));
    }

    //test wrong name
    @Test
    public void editCustomer_name_wrong() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt12");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test null name
    @Test
    public void editCustomer_name_null() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right name
    @Test
    public void editCustomer_name_right() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Lee Chong Wei");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //test wrong phone number
    @Test
    public void editCustomer_phone_Number_wrong() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789aas");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test null phone number
    @Test
    public void editCustomer_phone_Number_null() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right phone number
    @Test
    public void editCustomer_phone_Number_Right() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Lee Chong Wei");
        customerDto.setPhoneNumber("0912555555");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //test wrong date of birth
    @Test
    public void editdate_of_birth_wrong() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("hh12-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test null date of birth
    @Test
    public void editdate_of_birth_null() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right date of birth
    @Test
    public void editdate_of_birth_right() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Lee Chong Wei");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //test wrong email
    @Test
    public void editEmail_wrong() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("as");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test null email
    @Test
    public void editEmail_null() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right email
    @Test
    public void editEmail_right() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Lee Chong Wei");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //test null address
    @Test
    public void editAddress_wrong() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right address
    @Test
    public void editAddress_right() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Nguyễn Thái Việt");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right gender
    @Test
    public void editGender_right() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName("Lee Chong Wei");
        customerDto.setPhoneNumber("0912456789");
        customerDto.setDateOfBirth("2022-10-12");
        customerDto.setEmail("hoangtn97@gmail.com");
        customerDto.setAddress("102 Điện Biên Phủ");
        customerDto.setGender(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }




}
