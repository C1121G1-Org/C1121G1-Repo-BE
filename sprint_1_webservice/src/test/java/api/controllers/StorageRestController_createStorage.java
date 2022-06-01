package api.controllers;

import api.dto.StorageDto;
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

/*
    Created by khoaVC
    Time: 15:22 01/06/2022
    Function: create 12 test for method create Storage
 */

@SpringBootTest
@AutoConfigureMockMvc
public class StorageRestController_createStorage {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createStorage_createdDate_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate(null);
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_createdDate_14() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_createdDate_15() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-12-12");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_18() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createStorage_quantity_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity(null);
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_quantity_14() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_quantity_15() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("abc");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_quantity_16() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("-10");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_status_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_createdEmployeeDto_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(100L); //Thuộc tính này kiểu dữ liệu là Long, là id của employee trong DTO StorageDto,
                                                //nên muốn lấy về employee phải sử dụng findById trả về createdEmployee
                                                //Trường hợp này trả về null nên đây là trường hợp 13
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_productDto_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(100L); //Thuộc tính này kiểu dữ liệu là Long, là id của product trong DTO StorageDto,
                                        //nên muốn lấy về product phải sử dụng findById trả về product
                                        //Trường hợp này trả về null nên đây là trường hợp 13
        storageDto.setSupplierDto(1L);
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStorage_supplierDto_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setCreatedDate("2022-01-01");
        storageDto.setCreatedEmployeeDto(1L);
        storageDto.setProductDto(1L);
        storageDto.setSupplierDto(100L); //Thuộc tính này kiểu dữ liệu là Long, là id của supplier trong DTO StorageDto,
                                        //nên muốn lấy về supplier phải sử dụng findById trả về supplier
                                        //Trường hợp này trả về null nên đây là trường hợp 13
        storageDto.setQuantity("100");
        storageDto.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
