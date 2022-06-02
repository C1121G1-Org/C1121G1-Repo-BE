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
    Fixed by khoaVC
    Time: 12:22 02/06/2022
    Function: create 12 test for method search Suppliers
 */

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierRestController_listSupplier {

    @Autowired
    private MockMvc mockMvc;

    //Không test trường hợp null vì đã cài đặt giá trị mặc định cho param là "" và require = false

    //Test case: search Suppliers with param su = "Công Ty Cổ Phần Trung HIếu", ad = "Hà Nội", ph = "0905444111", em = "trunghieu@gmail.com"
    //Expected Result: success 2xx, Supplier = {
    //  address: "Hà Nội",
    //  email: "trunghieu@gmail.com",
    //  phone: "0905444111",
    //  supplierName: "Công Ty Cổ Phần Trung HIếu"
    // }
    //Actual Result: success 2xx, Supplier = {
    //                                            //  address: "Hà Nội",
    //                                            //  email: "trunghieu@gmail.com",
    //                                            //  phone: "0905444111",
    //                                            //  supplierName: "Công Ty Cổ Phần Trung HIếu"
    //                                            // }
    @Test
    public void listSupplier_allParams_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("su","Trung HIếu")
                                .param("ad","Hà Nội")
                                .param("ph","0905444111")
                                .param("em","trunghieu@gmail.com")
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

    //Test case: search Suppliers with param su = "Công Ty Cổ Phần Trung HIếu", ad = "Hà Nội", ph = "0905444111"
    //Expected Result: success 2xx, Supplier = {
    //  address: "Hà Nội",
    //  email: "trunghieu@gmail.com",
    //  phone: "0905444111",
    //  supplierName: "Công Ty Cổ Phần Trung HIếu"
    // }
    //Actual Result: success 2xx, Supplier = {
    //                                            //  address: "Hà Nội",
    //                                            //  email: "trunghieu@gmail.com",
    //                                            //  phone: "0905444111",
    //                                            //  supplierName: "Công Ty Cổ Phần Trung HIếu"
    //                                            // }
    @Test
    public void listSupplier_supplier_address_phone_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("su","Trung HIếu")
                                .param("ad","Hà Nội")
                                .param("ph","0905444111")
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

    //Test case: search Suppliers with param su = "Công Ty Cổ Phần Trung HIếu", ad = "Hà Nội"
    //Expected Result: success 2xx, Supplier = {
    //  address: "Hà Nội",
    //  email: "trunghieu@gmail.com",
    //  phone: "0905444111",
    //  supplierName: "Công Ty Cổ Phần Trung HIếu"
    // }
    //Actual Result: success 2xx, Supplier = {
    //                                            //  address: "Hà Nội",
    //                                            //  email: "trunghieu@gmail.com",
    //                                            //  phone: "0905444111",
    //                                            //  supplierName: "Công Ty Cổ Phần Trung HIếu"
    //                                            // }
    @Test
    public void listSupplier_supplier_address_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/supplier/list/")
                                .param("su","Trung HIếu")
                                .param("ad","Hà Nội")
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

    //Test case: search Suppliers with param su = "", ad = "", ph = "", em = ""
    //Expected Result: success 2xx, Supplier = {
    //                                            address: "TP Hồ Chí Minh",
    //                                            email: "tuongvi@gmail.com",
    //                                            phone: "0905789654",
    //                                            supplierName: "Công Ty TNHH May Mặt Tường Vy"
    //                                          }
    //Actual Result: success 2xx, Supplier = {
    //                                            address: "TP Hồ Chí Minh",
    //                                            email: "tuongvi@gmail.com",
    //                                            phone: "0905789654",
    //                                            supplierName: "Công Ty TNHH May Mặt Tường Vy"
    //                                        }
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

    //Test case: search Storage with
    //Test case: search Suppliers with param su = "zzzz" (supplier)
    //Expected Result: Error 4xx
    //Actual Result: Error 4xx
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

    //Test case: search Storage with
    //Test case: search Suppliers with param su = "Trung HIếu" (supplier)
    //Expected Result: success 2xx, Supplier = {
    //                                            address: "Hà Nội",
    //                                            email: "trunghieu@gmail.com",
    //                                            phone: "0905444111",
    //                                            supplierName: "Công Ty Cổ Phần Trung HIếu"
    //                                          }
    //Actual Result: success 2xx, Supplier = {
    //                                            address: "Hà Nội",
    //                                            email: "trunghieu@gmail.com",
    //                                            phone: "0905444111",
    //                                            supplierName: "Công Ty Cổ Phần Trung HIếu"
    //                                        }
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

    //Test case: search Storage with
    //Test case: search Suppliers with param ad = "zzzz" (address)
    //Expected Result: Error 4xx
    //Actual Result: Error 4xx
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

    //Test case: search Storage with
    //Test case: search Suppliers with param ad = "TT Huế" (address)
    //Expected Result: success 2xx, Supplier = {
    //                                            address: "TT Huế",
    //                                            email: "haivan75@gmail.com",
    //                                            phone: "0901232262",
    //                                            supplierName: "Công Ty Cổ Phần Hải Vân"
    //                                          }
    //Actual Result: success 2xx, Supplier = {
    //                                            address: "TT Huế",
    //                                            email: "haivan75@gmail.com",
    //                                            phone: "0901232262",
    //                                            supplierName: "Công Ty Cổ Phần Hải Vân"
    //                                        }
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

    //Test case: search Storage with
    //Test case: search Suppliers with param ph = "zzzz" (phone)
    //Expected Result: Error 4xx
    //Actual Result: Error 4xx
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

    //Test case: search Storage with
    //Test case: search Suppliers with param ph = "0905789654" (phone)
    //Expected Result: success 2xx, Supplier = {
    //                                            address: "TP Hồ Chí Minh",
    //                                            email: "tuongvi@gmail.com",
    //                                            phone: "0905789654",
    //                                            supplierName: "Công Ty TNHH May Mặt Tường Vy"
    //                                          }
    //Actual Result: success 2xx, Supplier = {
    //                                            address: "TP Hồ Chí Minh",
    //                                            email: "tuongvi@gmail.com",
    //                                            phone: "0905789654",
    //                                            supplierName: "Công Ty TNHH May Mặt Tường Vy"
    //                                        }
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

    //Test case: search Storage with
    //Test case: search Suppliers with param em = "zzzz" (email)
    //Expected Result: Error 4xx
    //Actual Result: Error 4xx
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

    //Test case: search Storage with
    //Test case: search Suppliers with param em = "hoanggia111@gmail.com" (email)
    //Expected Result: success 2xx, Supplier = {
    //                                            address: "Đà Nẵng",
    //                                            email: "hoanggia111@gmail.com",
    //                                            phone: "0905789777",
    //                                            supplierName: "Công Ty TNHH Đầu Tư May Mặt Hoàng Gia"
    //                                          }
    //Actual Result: success 2xx, Supplier = {
    //                                            address: "Đà Nẵng",
    //                                            email: "hoanggia111@gmail.com",
    //                                            phone: "0905789777",
    //                                            supplierName: "Công Ty TNHH Đầu Tư May Mặt Hoàng Gia"
    //                                        }
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
