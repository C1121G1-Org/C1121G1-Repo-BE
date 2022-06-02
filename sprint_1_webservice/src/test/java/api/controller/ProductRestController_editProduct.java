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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_editProduct {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    check find by id
//    id= null

    @Test
    public void getInfoProduct_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//id =""

    @Test
    public void getInfoProduct_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//id out of range

    @Test
    public void getInfoProduct_id_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "127"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid id

    @Test
    public void getInfoProduct_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/product/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Iphone13"))
                .andExpect(jsonPath("$.price").value("1000"))
                .andExpect(jsonPath("$.image").value("https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg"))
                .andExpect(jsonPath("$.screenSize").value("10 Inch"))
                .andExpect(jsonPath("$.camera").value("20MP"))
                .andExpect(jsonPath("$.qrScan").value("asdafafafsfs"))
                .andExpect(jsonPath("$.selfie").value("12MP"))
                .andExpect(jsonPath("$.cpu").value("100-MDX"))
                .andExpect(jsonPath("$.memory").value("128gb"))
                .andExpect(jsonPath("$.otherDescription").value("iPhone 13 Pro không có nhiều sự thay đổi về thiết kế, khi máy vẫn sở hữu kiểu dáng tương tự như điện thoại iPhone 12 Pro với các cạnh viền vuông vắn và hai mặt kính cường lực cao cấp."))
                .andExpect(jsonPath("$.deleteFlag").value(false));
    }

//    check edit product
//    test name

//    test name = null
    @Test
    public void editProduct_name_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    test name = ""

    @Test
    public void editProduct_name_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    name over max length

    @Test
    public void editProduct_name_23() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid name

    @Test
    public void editProduct_name_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test price

// valid price
    @Test
    public void editProduct_price_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//price is negative

    @Test
    public void editProduct_price_21_1() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    price inclue character

    @Test
    public void editProduct_price_21_2() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


//    test image
// image = null
    @Test
    public void editProduct_image_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


//    image =""
    @Test
    public void editProduct_image_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid image
    @Test
    public void editProduct_image_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //    test screen size

//    screenSize = null
    @Test
    public void editProduct_screenSize_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    screenSize = ""
    @Test
    public void editProduct_screenSize_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    screenSize out of length

    @Test
    public void editProduct_screenSize_23() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid screenSize

    @Test
    public void editProduct_screenSize_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test camera
// camera =null

    @Test
    public void editProduct_camera_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    camrera =""
    @Test
    public void editProduct_camera_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    camera out of length
    @Test
    public void editProduct_camera_23() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid camera
    @Test
    public void editProduct_camera_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //    test selfie
//    selfie =null
    @Test
    public void editProduct_selfie_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    selfie = ""
    @Test
    public void editProduct_selfie_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    selfie out of length

    @Test
    public void editProduct_selfie_23() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid selfie
    @Test
    public void editProduct_selfie_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    test cpu
//    cpu =null

    @Test
    public void editProduct_cpu_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//cpu =""
    @Test
    public void editProduct_cpu_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//cpu out of length
    @Test
    public void editProduct_cpu_23() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid cpu

    @Test
    public void editProduct_cpu_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


//    test memory
//memory =null

    @Test
    public void editProduct_memory_19() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    memory = ""
    @Test
    public void editProduct_memory_20() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    memory out of length
    @Test
    public void editProduct_memory_23() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    valid memory

    @Test
    public void editProduct_memory_24() throws Exception {

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
                        .patch("/api/product/update/5")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}

