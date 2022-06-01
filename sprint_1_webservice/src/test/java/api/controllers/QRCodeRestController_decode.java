package api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class QRCodeRestController_decode {

    @Autowired
    private MockMvc mockMvc;

    public void decode_1() throws Exception {
        String path = "D:\\sprint-1\\test-qrcode\\PD-1.png";
        MultipartFile file = (MultipartFile) new FileInputStream(path);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/qrcode/decode").requestAttr("file",file).contentType(MediaType.MULTIPART_FORM_DATA_VALUE));
    }

}
