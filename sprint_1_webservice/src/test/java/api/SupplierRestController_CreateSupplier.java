package api;

import api.dto.SupplierDto;
import api.services.ISupplierService;
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
public class SupplierRestController_CreateSupplier {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    //Test [item] = null
    @Test
    public void createSupplier_name_13() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
//        supplierDto.setSupplierName("");
        supplierDto.setAddress("Hue");
        supplierDto.setPhone("0987654321");
        supplierDto.setEmail("phuloc123@ggmail.com");
        supplierDto.setDeleteFlag(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/supplier/create")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [item] =  rỗng ("")
    @Test
    public void createSupplier_name_14() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("");
        supplierDto.setAddress("Hue");
        supplierDto.setPhone("0987654321");
        supplierDto.setEmail("phuloc123@ggmail.com");
        supplierDto.setDeleteFlag(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/supplier/create")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [item] sai format (phụ thuộc vào từng item cụ thể: chỉ chứa chữ, chỉ chứa số, định dạng email…)
    @Test
    public void createSupplier_name_15() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("công Ty May Mặt Phú Lộc");
        supplierDto.setAddress("Hue");
        supplierDto.setPhone("0287654321");
        supplierDto.setEmail("phuloc123@com");
        supplierDto.setDeleteFlag(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/supplier/create")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [item] không >= minlength
    @Test
    public void createSupplier_name_16() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("công Ty May Mặt Phú Lộc");
        supplierDto.setAddress("Hue");
        supplierDto.setPhone("0287654321");
        supplierDto.setEmail("abc@com");
        supplierDto.setDeleteFlag(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/supplier/create")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test [item] không <= maxlength
    @Test
    public void createSupplier_name_17() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("công Ty May Mặt Phú Lộc");
        supplierDto.setAddress("Hue");
        supplierDto.setPhone("0287654321");
        supplierDto.setEmail("phuloc123222222222222222222222222222222222222222222222222222222@com");
        supplierDto.setDeleteFlag(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/supplier/create")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test All [item] đều hợp lệ
    @Test
    public void createSupplier_name_18() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("công Ty May Mặt Phú Lộc");
        supplierDto.setAddress("Hue");
        supplierDto.setPhone("0987654321");
        supplierDto.setEmail("phuloc@gmail.com");


        supplierDto.setDeleteFlag(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/supplier/create")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
