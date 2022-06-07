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
public class EmployeeRestController_getListEmployee {
    @Autowired
    private MockMvc mockMvc;

    //Test case: List invoice
    // invoiceId = 1L, quantity = 6L, createTime = "12:00", createDate = "2022-01-21", customerName = "Nguyen Van A", productName = "xiaomi", totalMoney = 12000000

    @Test
<<<<<<< HEAD:sprint_1_webservice/src/test/java/api/controller/InvoiceControllerTest.java
    public  void findAll_5() throws Exception{
=======
    public void getListEmployee_5() throws Exception {

>>>>>>> 536a668439894a3bc5c179a4dbd01a8c13b6966e:sprint_1_webservice/src/test/java/api/controllers/EmployeeRestController_getListEmployee.java
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test case: List invoice
    // invoiceId = 1L, quantity = 6L, createTime = "12:00", createDate = "2022-01-21", customerName = "Nguyen Van A", productName = "xiaomi", totalMoney = 12000000

    @Test
<<<<<<< HEAD:sprint_1_webservice/src/test/java/api/controller/InvoiceControllerTest.java
    public void getList_6() throws Exception {
=======
    public void getListEmployee_6() throws Exception {
>>>>>>> 536a668439894a3bc5c179a4dbd01a8c13b6966e:sprint_1_webservice/src/test/java/api/controllers/EmployeeRestController_getListEmployee.java

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
<<<<<<< HEAD:sprint_1_webservice/src/test/java/api/controller/InvoiceControllerTest.java
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(4))
                .andExpect(jsonPath("$.content[0].invoiceId").value(1))
                .andExpect(jsonPath("$.content[0].quantity").value(6))
                .andExpect(jsonPath("$.content[0].createTime").value("12:00"))
                .andExpect(jsonPath("$.content[0].createDate").value("21/01/2022"))
                .andExpect(jsonPath("$.content[0].customerName").value("Nguyen Van A"))
                .andExpect(jsonPath("$.content[0].productName").value("xiaomi"))
                .andExpect(jsonPath("$.content[0].payments").value("tien mat"))
                .andExpect(jsonPath("$.content[0].totalMoney").value(1200000.0));
    }


    //Test case: List invoice
    //    object in null list

    @Test
    public  void findAll_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test case: List invoice
    //    object in empty list

    @Test
    public  void findAll_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test case: List invoice
    //   There are no objects in the list

    @Test
    public  void findAll_10() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test case: List invoice
    //   There are no objects in the list

    @Test
    public  void findAll_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/invoice/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



=======
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(15))
                .andExpect(jsonPath("$.content[3].employeeName").value("Lê Ngọc Ánh"))
                .andExpect(jsonPath("$.content[3].dateOfBirth").value("2000-05-19"))
                .andExpect(jsonPath("$.content[3].address").value("Hòa Khánh"))
                .andExpect(jsonPath("$.content[3].idCard").value("194543332"))
                .andExpect(jsonPath("$.content[3].phoneNumber").value("194543332"))
                .andExpect(jsonPath("$.content[3].image").value("url"))
                .andExpect(jsonPath("$.content[3].position.id").value(3))
                .andExpect(jsonPath("$.content[3].account.id").value(3));

    }
>>>>>>> 536a668439894a3bc5c179a4dbd01a8c13b6966e:sprint_1_webservice/src/test/java/api/controllers/EmployeeRestController_getListEmployee.java
}
