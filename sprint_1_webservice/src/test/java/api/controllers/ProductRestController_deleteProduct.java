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
public class ProductRestController_deleteProduct {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteProduct_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/product/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void deleteProduct_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/product/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void deleteProduct_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/product/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
