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


    @Test
    public void getListCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(4))
                .andExpect(jsonPath("$.totalElements").value(34))
                .andExpect(jsonPath("$.content[1].customerName").value("Đặng Quang Huy"))
                .andExpect(jsonPath("$.content[2].dateOfBirth").value("1992-06-02"))
                .andExpect(jsonPath("$.content[2].phoneNumber").value("0912456785"))
                .andExpect(jsonPath("$.content[2].email").value("vanc@codegym.com"))
                .andExpect(jsonPath("$.content[2].address").value("The Garden Mall, số 190 đường Hồng Bàng, phường 12, quận 5, Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[2].gender").value(true))
        ;
    }



    @Test
    public void getListStudent_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/customer/list?keyPhone=a"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListCustomer_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/studentRest/list/?keyName=Vie"))
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

    @Test
    public void getListCustomer_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/studentRest/list/?keyName=12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

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

//    @Test
//    public void getListStudent_6() {
//        ResponseEntity<Page<Student>> responseEntity
//                = this.studentRestController.getListStudent(PageRequest.of(0, 2));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Nguyễn Văn Bình",
//                responseEntity.getBody().getContent().get(1).getName());
//        Assertions.assertEquals("2001-10-05",
//                responseEntity.getBody().getContent().get(1).getDateOfBirth());
//    }
}
