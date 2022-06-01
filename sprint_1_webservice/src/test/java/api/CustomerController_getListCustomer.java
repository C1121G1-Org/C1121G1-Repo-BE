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
public class CustomerController_getListCustomer {
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

    @Test
    public void getInfoStudent_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", "127"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerName").value("Huỳnh Thị Kim Ngân"))
                .andExpect(jsonPath("$.dateOfBirth").value("1999-11-01"))
                .andExpect(jsonPath("$.email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.address").value("số 978 Trần Hưng Đạo, phường 7, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.gender").value(false));
    }


}
