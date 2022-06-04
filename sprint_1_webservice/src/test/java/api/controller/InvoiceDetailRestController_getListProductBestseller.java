package api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Create by chienLV
//Time: 16h30 01/06/2022
//Function: test method get list product bestseller from database at controller
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceDetailRestController_getListProductBestseller {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListProductBestseller_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/invoiceDetail/listProductBestseller"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListProductBestseller_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/invoiceDetail/listProductBestseller"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.size()").value(10))
                .andExpect(jsonPath("$.[0].productQuantity").value(34))
                .andExpect(jsonPath("$.[9].productQuantity").value(10))
                .andExpect(jsonPath("$.[0].id").value(2))
                .andExpect(jsonPath("$.[0].name").value("Samsung A72"))
                .andExpect(jsonPath("$.[0].price").value(100000001))
                .andExpect(jsonPath("$.[0].image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.[0].screenSize").value("6 inch"))
                .andExpect(jsonPath("$.[0].cpu").value("snap889"))
                .andExpect(jsonPath("$.[0].memory").value("64G"))
                .andExpect(jsonPath("$.[0].camera").value("2"))
                .andExpect(jsonPath("$.[0].selfie").value("12MP"))
                .andExpect(jsonPath("$.[0].otherDescription").value("new"))
                .andExpect(jsonPath("$.[9].id").value(10))
                .andExpect(jsonPath("$.[9].name").value("Samsung A80"))
                .andExpect(jsonPath("$.[9].price").value(100000009))
                .andExpect(jsonPath("$.[9].image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.[9].screenSize").value("14 inch"))
                .andExpect(jsonPath("$.[9].cpu").value("snap897"))
                .andExpect(jsonPath("$.[9].memory").value("64G"))
                .andExpect(jsonPath("$.[9].camera").value("2"))
                .andExpect(jsonPath("$.[9].selfie").value("12MP"))
                .andExpect(jsonPath("$.[9].otherDescription").value("new"));
    }
}
