package api.controller;

import api.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_createProduct {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createProduct_name_13() throws Exception {

        ProductDto productDto = new ProductDto();
//        productDto.setName("");
        productDto.setPrice("100");
        productDto.setImage("100");
        productDto.setScreenSize("100");
        productDto.setCamera("100");
        productDto.setSelfie("100");
        productDto.setCpu("100");
        productDto.setMemory("100");
        productDto.setOtherDescription("100");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    test name

    @Test
    public void createProduct_name_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("");
        productDto.setPrice("100");
        productDto.setImage("100");
        productDto.setScreenSize("100");
        productDto.setCamera("100");
        productDto.setSelfie("100");
        productDto.setCpu("100");
        productDto.setMemory("100");
        productDto.setOtherDescription("100");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createProduct_name_17() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setPrice("100");
        productDto.setImage("100");
        productDto.setScreenSize("100");
        productDto.setCamera("100");
        productDto.setSelfie("100");
        productDto.setCpu("100");
        productDto.setMemory("100");
        productDto.setOtherDescription("100");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createProduct_name_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("aaa");
        productDto.setPrice("aaa");
        productDto.setImage("aaa");
        productDto.setScreenSize("aaa");
        productDto.setCamera("aaa");
        productDto.setSelfie("aaa");
        productDto.setCpu("aaa");
        productDto.setMemory("aaa");
        productDto.setOtherDescription("aaa");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test image

    @Test
    public void createProduct_image_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("aaa");
        productDto.setPrice("aaa");
//        productDto.setImage("aaa");
        productDto.setScreenSize("aaa");
        productDto.setCamera("aaa");
        productDto.setSelfie("aaa");
        productDto.setCpu("aaa");
        productDto.setMemory("aaa");
        productDto.setOtherDescription("aaa");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }





}
