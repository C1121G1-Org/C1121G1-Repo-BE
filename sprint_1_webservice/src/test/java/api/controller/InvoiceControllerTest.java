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

    @Test
    public  void findAll_1() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.totalPages").value(3))
//                .andExpect(jsonPath("$.totalElements").value(14))
                .andExpect(jsonPath("$.content[0].createTime").value("12:00"))
                .andExpect(jsonPath("$.content[0].createDate").value("2022-01-21"))
                .andExpect(jsonPath("$.content[0].customer.id").value(1))
                .andExpect(jsonPath("$.content[0].product.id").value(1))
                .andExpect(jsonPath("$.content[0].totalMoney").value(1200000));
    }

}
