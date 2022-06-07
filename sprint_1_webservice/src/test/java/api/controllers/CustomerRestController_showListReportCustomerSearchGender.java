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
public class CustomerRestController_showListReportCustomerSearchGender {

    @Autowired
    private MockMvc mockMvc;


    // Test trường hợp gender = null
    // Trả về lỗi 4xx
    @Test
    public void getListReportCustomerSearchGender_gender_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/report-customer-search-gender"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // Test trường hợp gender = rỗng ("")
    // Trả về lỗi 4xx
    @Test
    public void getListReportCustomerSearchGender_gender_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/report-customer-search-gender?gender="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // Test trường hợp gender không có trong DB
    // Trả về NO_CONTENT (2xx)
    @Test
    public void getListReportCustomerSearchGender_gender_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/report-customer-search-gender?gender=differentBoolean"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // Test trường hợp search theo gender ra được kết quả list có trong db
    // Trả về OK (2xx)
    // Lấy phần tử đầu tiên ra để kiểm tra
    @Test
    public void getListReportCustomerSearchGender_gender_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/report-customer-search-gender?gender=true"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].name").value("Quốc Tuấn"))
                .andExpect(jsonPath("$.content[0].dateOfBirth").value("11-03-1998"))
                .andExpect(jsonPath("$.content[0].email").value("quoctuan@gmail.com"))
                .andExpect(jsonPath("$.content[0].gender").value("true"))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0905112365"));
    }
}
