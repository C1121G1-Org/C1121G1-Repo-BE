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
public class ProductController_getProduct {
    @Autowired
    private MockMvc mockMvc;
    //    test cho trường hợp size list =0
    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test cho trường hợp trả về list thành công
    @Test
    public void getListProduct_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[0].camera").value("2"))
                .andExpect(jsonPath("$.content[0].cpu").value("snap889"))
                .andExpect(jsonPath("$.content[0].deleteFlag").value("false"))
                .andExpect(jsonPath("$.content[0].image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.content[0].memory").value("64G"))
                .andExpect(jsonPath("$.content[0].name").value("Samsung A72"))
                .andExpect(jsonPath("$.content[0].otherDescription").value("new"))
                .andExpect(jsonPath("$.content[0].price").value("1.00000001E8"))
                .andExpect(jsonPath("$.content[0].qrScan").value("gdfgfdgdf"))
                .andExpect(jsonPath("$.content[0].screenSize").value("6 inch"))
                .andExpect(jsonPath("$.content[0].selfie").value("12MP"));
    }

    //test cho tham số id = null
    @Test
    public void getInfoProduct_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test cho tham số id = rỗng
    @Test
    public void getInfoProduct_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test cho tham số id = quá lớn
    @Test
    public void getInfoProduct_id_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "127"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test cho tham số id tìm thấy . trả về thành công
    @Test
    public void getInfoProduct_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Samsung A72"))
                .andExpect(jsonPath("$.price").value("1.00000001E8"))
                .andExpect(jsonPath("$.image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.qrScan").value("gdfgfdgdf"))
                .andExpect(jsonPath("$.screenSize").value("6 inch"))
                .andExpect(jsonPath("$.camera").value("2"))
                .andExpect(jsonPath("$.selfie").value("12MP"))
                .andExpect(jsonPath("$.cpu").value("snap889"))
                .andExpect(jsonPath("$.memory").value("64G"))
                .andExpect(jsonPath("$.otherDescription").value("new"))
                .andExpect(jsonPath("$.deleteFlag").value(false));
    }



    //test trường hợp tìm kiếm với tham số null
    @Test
    public void getListReportProduct_7() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test trường hợp tìm kiếm với tham số rỗng
    @Test
    public void getListSearchProduct_name_8() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?keyName="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test trường hợp tìm kiếm với tham số không đúng
    @Test
    public void getListReportProduct_name_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?keyName=yudgdfg"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test trường hợp tìm kiếm với tham số truyền vào đúng
    @Test
    public void getListReportProduct_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyName=Samsung A72"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Samsung A72"))
                .andExpect(jsonPath("$.price").value("1.00000001E8"))
                .andExpect(jsonPath("$.image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.qrScan").value("gdfgfdgdf"))
                .andExpect(jsonPath("$.screenSize").value("6 inch"))
                .andExpect(jsonPath("$.camera").value("2"))
                .andExpect(jsonPath("$.selfie").value("12MP"))
                .andExpect(jsonPath("$.cpu").value("snap889"))
                .andExpect(jsonPath("$.memory").value("64G"))
                .andExpect(jsonPath("$.otherDescription").value("new"))
                .andExpect(jsonPath("$.deleteFlag").value(false));

    }

//test trường hợp tìm kiếm với tham số null

    @Test
    public void getListReportProduct_phone_7() throws Exception {
//        mặc định về rỗng
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test trường hợp tìm kiếm với tham số rỗng
    @Test
    public void getListReportProduct_phone_8() throws Exception {
//        mặc định sẽ trả về susccess
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?keyPrice="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test trường hợp tìm kiếm với tham số không đúng
    @Test
    public void getListReportProduct_phone_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?keyPrice=346435345435a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test trường hợp tìm kiếm với tham số truyền vào đúng
    @Test
    public void getListReportProduct_phone_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?keyPrice=1.00000001E8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Samsung A72"))
                .andExpect(jsonPath("$.price").value("1.00000001E8"))
                .andExpect(jsonPath("$.image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.qrScan").value("gdfgfdgdf"))
                .andExpect(jsonPath("$.screenSize").value("6 inch"))
                .andExpect(jsonPath("$.camera").value("2"))
                .andExpect(jsonPath("$.selfie").value("12MP"))
                .andExpect(jsonPath("$.cpu").value("snap889"))
                .andExpect(jsonPath("$.memory").value("64G"))
                .andExpect(jsonPath("$.otherDescription").value("new"))
                .andExpect(jsonPath("$.deleteFlag").value(false));

    }
}
