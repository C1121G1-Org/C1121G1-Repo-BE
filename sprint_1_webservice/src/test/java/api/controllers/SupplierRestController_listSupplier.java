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

/*
    Created by khoaVC
    Time: 15:22 01/06/2022
    Function: create 12 test for method create Storage
 */

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierRestController_listSupplier {

    @Autowired
    private MockMvc mockMvc;

    //Không test trường hợp null vì đã cài đặt giá trị mặc định cho param là "" và require = false
    //Test case thành công
    @Test
    public void listSupplier_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api//supplier/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(2))
                .andExpect(jsonPath("$.totalElements").value(6))
                .andExpect(jsonPath("$.content[2].address").value("TP Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].email").value("tuongvi@gmail.com"))
                .andExpect(jsonPath("$.content[2].phone").value("0905789654"))
                .andExpect(jsonPath("$.content[2].supplierName").value("Công Ty TNHH May Mặt Tường Vy"));
    }

    @Test
    public void listSupplier_8() throws Exception {
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
                .andExpect(jsonPath("$.totalElements").value(6))
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
    public void listSupplier_supplier_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("su","Trung HIếu")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].address").value("Hà Nội"))
                .andExpect(jsonPath("$.content[0].email").value("trunghieu@gmail.com"))
                .andExpect(jsonPath("$.content[0].phone").value("0905444111"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Công Ty Cổ Phần Trung HIếu"));
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
    public void listSupplier_address_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("ad","TT Huế")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(2))
                .andExpect(jsonPath("$.content[0].address").value("TT Huế"))
                .andExpect(jsonPath("$.content[0].email").value("haivan75@gmail.com"))
                .andExpect(jsonPath("$.content[0].phone").value("0901232262"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Công Ty Cổ Phần Hải Vân"));
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
    public void listSupplier_phone_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("ph","0905789654")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].address").value("TP Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[0].email").value("tuongvi@gmail.com"))
                .andExpect(jsonPath("$.content[0].phone").value("0905789654"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Công Ty TNHH May Mặt Tường Vy"));
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

    @Test
    public void listSupplier_email_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("em","hoanggia111@gmail.com")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].address").value("Đà Nẵng"))
                .andExpect(jsonPath("$.content[0].email").value("hoanggia111@gmail.com"))
                .andExpect(jsonPath("$.content[0].phone").value("0905789777"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Công Ty TNHH Đầu Tư May Mặt Hoàng Gia"));
    }
}
