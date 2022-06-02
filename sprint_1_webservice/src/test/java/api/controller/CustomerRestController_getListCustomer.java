package api.controller;

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
public class CustomerRestController_getListCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Case list size=0
    @Test
    public void getListCustomer_size0() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Case list size=34, 4 elements per page
    @Test
    public void getListStudent_sizeNotNull() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(4))
                .andExpect(jsonPath("$.totalElements").value(34))
                .andExpect(jsonPath("$.content[2].customerName").value("Đặng Quang Huy"))
                .andExpect(jsonPath("$.content[2].dateOfBirth").value("1992-06-02"))
                .andExpect(jsonPath("$.content[2].phoneNumber").value("0912456785"))
                .andExpect(jsonPath("$.content[2].email").value("vanc@codegym.com"))
                .andExpect(jsonPath("$.content[2].address").value("The Garden Mall, số 190 đường Hồng Bàng, phường 12, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].gender").value(true))
        ;
    }


    //input search key phone =a, wrong type of search
    @Test
    public void getListStudent_SearchFall1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/customer/list?keyPhone=a"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Input search = Vie, right input search
    @Test
    public void getListCustomer_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/studentRest/list/?keyName=Vie"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[2].customerName").value("Nguyễn Thái Việt"))
                .andExpect(jsonPath("$.content[2].dateOfBirth").value("1993-02-11"))
                .andExpect(jsonPath("$.content[2].phoneNumber").value("0912423785"))
                .andExpect(jsonPath("$.content[2].email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.content[2].address").value("số 648 đường Nguyễn Trãi, phường 11, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].gender").value(true));
    }


    //input search key name =12, wrong type of search
    @Test
    public void getListCustomer_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/studentRest/list/?keyName=12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //search 2 fields of search, successfull return
    @Test
    public void getListCustomer_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/studentRest/list/?keyName=Vie&keyPhone=09124"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[1].customerName").value("Nguyễn Thái Việt"))
                .andExpect(jsonPath("$.content[2].dateOfBirth").value("1993-02-11"))
                .andExpect(jsonPath("$.content[2].phoneNumber").value("0912423785"))
                .andExpect(jsonPath("$.content[2].email").value("hoangduy@gmail.com"))
                .andExpect(jsonPath("$.content[2].address").value("số 648 đường Nguyễn Trãi, phường 11, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].gender").value(true));
    }


}
