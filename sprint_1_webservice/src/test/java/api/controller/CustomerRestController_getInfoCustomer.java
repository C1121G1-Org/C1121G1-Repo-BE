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
public class CustomerRestController_getInfoCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    //test id=null, return error
    @Test
    public void getInfoCustomer_id_null() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test id="", return error
    @Test
    public void getInfoCustomer_id_empty() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    //test id=4, return object
    @Test
    public void getInfoCustomer_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/Customer/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerName").value("Nguyễn Thái Việt"))
                .andExpect(jsonPath("$.phoneNumber").value("0912456789"))
                .andExpect(jsonPath("$.dateOfBirth").value("2022-10-12"))
                .andExpect(jsonPath("$.email").value("hoangtn97@gmail.com"))
                .andExpect(jsonPath("$.address").value("102 Điện Biên Phủ"))
                .andExpect(jsonPath("$.gender").value(1));
    }

}
