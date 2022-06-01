package api.controllers;

import api.models.Product;
import api.models.ProductQRCode;
import api.utils.QRCodeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QRCodeRestController_encode {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void encode_1() throws Exception {
        Product productDTO = new Product(null, "iPhone", 200D, "image", "qrScan", "screenSize", "Camera", "Selfie", "Cpu", "memory", "other", null, true, null);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/qrcode/encode")
                        .content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());

    }

    @Test
    public void encode_3() throws Exception {
        Product productDTO = new Product(800L, "iPhone", 200D, "image", "qrScan", "screenSize", "Camera", "Selfie", "Cpu", "memory", "other", null, true, null);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/qrcode/encode")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void encode_4() throws Exception {
        Product productDTO = new Product(1L, "iPhone", 200D, "image", "qrScan", "screenSize", "Camera", "Selfie", "Cpu", "memory", "other", null, true, null);
        ProductQRCode productQRCode = new ProductQRCode();
        ObjectMapper objectMapper = new ObjectMapper();
        BeanUtils.copyProperties(productDTO, productQRCode);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productDTO);
        String path = QRCodeUtils.encode(productQRCode);
        ByteArrayResource byteArrayResource = new ByteArrayResource(Files.readAllBytes(Paths.get(path)));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/qrcode/encode")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
