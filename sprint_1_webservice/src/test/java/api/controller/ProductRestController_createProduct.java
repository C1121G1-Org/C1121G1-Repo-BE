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

    //    test name
//    test name = null

    @Test
    public void createProduct_name_13() throws Exception {

        ProductDto productDto = new ProductDto();
//        productDto.setName("");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//name =""
    @Test
    public void createProduct_name_14() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");




        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    name out of length

    @Test
    public void createProduct_name_17() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");




        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//valid name
    @Test
    public void createProduct_name_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");




        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test price
//valid price

    @Test
    public void createProduct_price_13() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

// negative price
    @Test
    public void createProduct_price_15_1() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("-1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//price include charactor

    @Test
    public void createProduct_price_15_2() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000aaaaaaaaa");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


//    test image
//image =null

    @Test
    public void createProduct_image_13() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
//        productDto.setImage("http/asdhasd.asdhasjd");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//image =""
    @Test
    public void createProduct_image_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//valid price
    @Test
    public void createProduct_image_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test screen size
//    screenSize = null
    @Test
    public void createProduct_screenSize_13() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
//        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    screenSize = ""
    @Test
    public void createProduct_screenSize_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    screenSize out of length
    @Test
    public void createProduct_screenSize_17() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//     valid screenSize
    @Test
    public void createProduct_screenSize_18() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test camera
//camera = null

    @Test
    public void createProduct_camera_13() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
//        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    camera =""
    @Test
    public void createProduct_camera_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    camera out of length
    @Test
    public void createProduct_camera_17() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("aaaaaaaaaqaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid camera
    @Test
    public void createProduct_camera_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");




        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //    test selfie
//    selfie = null
    @Test
    public void createProduct_selfie_13() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
//        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

         this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    selfie =""
    @Test
    public void createProduct_selfie_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//selfie out of length

    @Test
    public void createProduct_selfie_17() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid selfie
    @Test
    public void createProduct_selfie_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test cpu

//cpu =null
    @Test
    public void createProduct_cpu_13() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
//        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//cpu = ""
    @Test
    public void createProduct_cpu_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    cpu out of length

    @Test
    public void createProduct_cpu_17() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid cpu
    @Test
    public void createProduct_cpu_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


//    test memory
// memory = null
    @Test
    public void createProduct_memory_13() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
//        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//memory =""

    @Test
    public void createProduct_memory_14() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    memory out length
    @Test
    public void createProduct_memory_17() throws Exception {

        ProductDto productDto = new ProductDto();

        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setMemory("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//     vaid memory
    @Test
    public void createProduct_memory_18() throws Exception {

        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone13");
        productDto.setPrice("1000");
        productDto.setImage("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg");
        productDto.setScreenSize("10 Inch");
        productDto.setCamera("20MP");
        productDto.setSelfie("12MP");
        productDto.setCpu("100-MDX");
        productDto.setMemory("128gb");
        productDto.setOtherDescription("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp.");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
