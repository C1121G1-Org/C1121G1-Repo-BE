package api.controller;

import api.controllers.InvoiceRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.xml.stream.Location;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //Test case: List invoice
    // invoiceId = 1L, quantity = 6L, createTime = "12:00", createDate = "2022-01-21", customerName = "Nguyen Van A", productName = "xiaomi", totalMoney = 12000000


    @Test
    public  void findAll_5() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test case: List invoice
    // invoiceId = 1L, quantity = 6L, createTime = "12:00", createDate = "2022-01-21", customerName = "Nguyen Van A", productName = "xiaomi", totalMoney = 12000000

    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(3))
//                .andExpect(jsonPath("$.totalElements").value(14))
                .andExpect(jsonPath("$.content[0].invoiceId").value(1))
                .andExpect(jsonPath("$.content[0].quantity").value(6))
                .andExpect(jsonPath("$.content[0].createTime").value("12:00"))
                .andExpect(jsonPath("$.content[0].createDate").value("2022-01-21"))
                .andExpect(jsonPath("$.content[0].customerName").value("Nguyen Van Cong"))
                .andExpect(jsonPath("$.content[0].productName").value("xiaomi"))
                .andExpect(jsonPath("$.content[0].payments").value("tien mat"))
                .andExpect(jsonPath("$.content[0].totalMoney").value(12000000));
    }

}
