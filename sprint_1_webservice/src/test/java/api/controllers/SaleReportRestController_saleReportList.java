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
public class SaleReportRestController_saleReportList {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void saleReportList_5() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/sale-report"))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saleReportList_6() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/sale-report"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("product1"))
                .andExpect(jsonPath("$[0].price").value(200D))
                .andExpect(jsonPath("$[0].qrScan").value("qrScan1"))
                .andExpect(jsonPath("$[0].deleteFlag").value(false));
    }

}
