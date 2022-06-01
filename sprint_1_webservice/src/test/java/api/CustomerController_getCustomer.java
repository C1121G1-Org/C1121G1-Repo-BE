package api;

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
public class CustomerController_getCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(9))
                .andExpect(jsonPath("$.totalElements").value(35))
                .andExpect(jsonPath("$.content[0].customerName").value("Huỳnh Thị Kim Ngân"))
                .andExpect(jsonPath("$.content[0].dateOfBirth").value("1999-11-01"))
                .andExpect(jsonPath("$.content[0].address").value("số 978 Trần Hưng Đạo, phường 7, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[0].email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.content[0].gender").value("false"));
    }
//    test findById

    @Test
    public void getInfoCustomer_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoCustomer_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoCustomer_id_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", "127"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoCustomer_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerName").value("Huỳnh Thị Kim Ngân"))
                .andExpect(jsonPath("$.dateOfBirth").value("1999-11-01"))
                .andExpect(jsonPath("$.email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.address").value("số 978 Trần Hưng Đạo, phường 7, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.gender").value(false));
    }


//    search Customer
    @Test
    public void getListReportCustomer_customer_7() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListReportCustomer_customer_name_8() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyName="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListReportCustomer_name_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyName=djfioeshfi"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListReportCustomer_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyName=ngân"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].customerName").value("Huỳnh Thị Kim Ngân"))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0912123785"))
                .andExpect(jsonPath("$.content[0].dateOfBirth").value("1999-11-01"))
                .andExpect(jsonPath("$.content[0].email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.content[0].address").value("số 978 Trần Hưng Đạo, phường 7, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[0].gender").value("false"));

    }

    @Test
    public void getListReportCustomer_phone_7() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListReportCustomer_customer_phone_8() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyPhone="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListReportCustomer_phone_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyphon=346435345435a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListReportCustomer_phone_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyPhone=0912123785"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].customerName").value("Huỳnh Thị Kim Ngân"))
                .andExpect(jsonPath("$.content[0].phoneNumber").value("0912123785"))
                .andExpect(jsonPath("$.content[0].dateOfBirth").value("1999-11-01"))
                .andExpect(jsonPath("$.content[0].email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.content[0].address").value("số 978 Trần Hưng Đạo, phường 7, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[0].gender").value("false"));
    }
}
