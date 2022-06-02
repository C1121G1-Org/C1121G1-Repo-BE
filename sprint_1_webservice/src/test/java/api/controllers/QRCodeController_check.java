package api.controllers;

import org.junit.jupiter.api.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QRCodeController_check {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void check_18() throws Exception {
        String path1 = "D:\\sprint-1\\test-qrcode\\PD-1.png";
        String path2 = "D:\\sprint-1\\test-qrcode\\PD-2.png";

        ByteArrayResource bytes1 = new ByteArrayResource(Files.readAllBytes(Paths.get(path1)));
        ByteArrayResource bytes2 = new ByteArrayResource(Files.readAllBytes(Paths.get(path2)));

        mockMvc.perform(MockMvcRequestBuilders.post("api/qrcode/check")
                        .content(bytes1.getByteArray())
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .content(bytes2.getByteArray())
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void check_13() throws Exception {
        String path1 = "";
        String path2 = "D:\\sprint-1\\test-qrcode\\PD-1.png";

        ByteArrayResource bytes1 = new ByteArrayResource(Files.readAllBytes(Paths.get(path1)));
        ByteArrayResource bytes2 = new ByteArrayResource(Files.readAllBytes(Paths.get(path2)));

        mockMvc.perform(MockMvcRequestBuilders.post("api/qrcode/check").content(bytes1.getByteArray())
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .content(bytes2.getByteArray()).contentType(MediaType.MULTIPART_FORM_DATA)).andDo(print())
                        .andExpect(status().is4xxClientError());
    }
}
