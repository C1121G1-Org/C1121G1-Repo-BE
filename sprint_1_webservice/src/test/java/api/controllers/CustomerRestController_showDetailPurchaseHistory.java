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
public class CustomerRestController_showDetailPurchaseHistory {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDetailPurchaseHistory_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/purchase-history/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDetailPurchaseHistory_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/purchase-history/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDetailPurchaseHistory_id_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/purchase-history/{id}", "123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getDetailPurchaseHistory_id_5() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/purchase-history/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(3))
                .andExpect(jsonPath("$.content[0].purchaseDate").value("28-05-2022"))
                .andExpect(jsonPath("$.content[0].purchaseProducts").value("iPhone 11 Pro Max,SamSung s22"))
                .andExpect(jsonPath("$.content[0].totalMoney").value("3.65E7"));
    }
}
