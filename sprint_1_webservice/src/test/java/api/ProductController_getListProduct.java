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
public class ProductController_getListProduct {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(4))
                .andExpect(jsonPath("$.totalElements").value(13))
                .andExpect(jsonPath("$.content[0].camera").value("2"))
                .andExpect(jsonPath("$.content[0].cpu").value("snap889"))
                .andExpect(jsonPath("$.content[0].delete_flag").value("flase"))
                .andExpect(jsonPath("$.content[0].image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.content[0].memory").value("64G"))
                .andExpect(jsonPath("$.content[0].name").value("Samsung A72"))
                .andExpect(jsonPath("$.content[0].other_description").value("new"))
                .andExpect(jsonPath("$.content[0].price").value("100000001"))
                .andExpect(jsonPath("$.content[0].qr_scan").value("gdfgfdgdf"))
                .andExpect(jsonPath("$.content[0].screen_size").value("6 inch"))
                .andExpect(jsonPath("$.content[0].selfie").value("12MP"));
    }

//    check id

    @Test
    public void getInfoStudent_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", ""))
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
