package api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QRCodeRestController_decode {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void decode_13() throws Exception {
        String path = "";
        ByteArrayResource byteArrayResource = new ByteArrayResource(Files.readAllBytes(Paths.get(path)));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/qrcode/decode").content(byteArrayResource.getByteArray())
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void decode_18() throws Exception {
        String path = "D:\\sprint-1\\test-qrcode\\PD-1.png";
        ByteArrayResource byteArrayResource = new ByteArrayResource(Files.readAllBytes(Paths.get(path)));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/qrcode/decode").content(byteArrayResource.getByteArray())
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
