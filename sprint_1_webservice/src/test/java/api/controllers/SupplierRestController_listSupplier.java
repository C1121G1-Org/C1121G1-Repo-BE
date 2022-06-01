package api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class SupplierRestController_listSupplier {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void listSupplier_supplier_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api//supplier/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(2))
                .andExpect(jsonPath("$.totalElements").value(4))
                .andExpect(jsonPath("$.content[2].address").value("TP Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].email").value("tuongvi@gmail.com"))
                .andExpect(jsonPath("$.content[2].phone").value("0905789654"))
                .andExpect(jsonPath("$.content[2].supplierName").value("Công Ty TNHH May Mặt Tường Vy"));
    }

    @Test
    public void listSupplier_supplier_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("su","")
                                .param("ad","")
                                .param("ph","")
                                .param("em","")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(2))
                .andExpect(jsonPath("$.totalElements").value(4))
                .andExpect(jsonPath("$.content[2].address").value("TP Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].email").value("tuongvi@gmail.com"))
                .andExpect(jsonPath("$.content[2].phone").value("0905789654"))
                .andExpect(jsonPath("$.content[2].supplierName").value("Công Ty TNHH May Mặt Tường Vy"));
    }

    @Test
    public void listSupplier_supplier_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("su","zzzz")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void listSupplier_address_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("ad","zzzz")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void listSupplier_phone_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("ph","zzzz")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void listSupplier_email_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("em","zzzz")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
