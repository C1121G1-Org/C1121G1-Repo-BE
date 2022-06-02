package api.controller;

import api.dto.CustomerDto;
import api.dto.InvoiceDetailDto;
import api.dto.InvoiceDto;
import api.dto.ProductInvoiceDto;
import api.models.Customer;
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

import java.util.ArrayList;
import java.util.List;

//Create by LongNHLL
//Time: 16h30 01/06/2022
//Function: Crete invoice sales
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceDetailRestController_SalesManager {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    //    Test khi list sản phẩm null
    @Test
    public void createInvoiceDetail_productInvoiceDtoList_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        productInvoiceDtoList = null;
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Thẻ tín dụng");
        invoiceDto.setTotalMoney(1000000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi list sản phẩm rỗng
    @Test
    public void createInvoiceDetail_productInvoiceDtoList_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        productInvoiceDtoList.get(0).setQuantity(0L);
        productInvoiceDtoList.get(0).setProductId(0L);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Thẻ tín dụng");
        invoiceDto.setTotalMoney(1000000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi payment null
    @Test
    public void createInvoiceDetail_Payments_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
//        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi payment rỗng
    @Test
    public void createInvoiceDetail_Payments_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("");
        invoiceDto.setTotalMoney(1000000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi totalMoney null
    @Test
    public void createInvoiceDetail_totalMoney_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
//        invoiceDto.setTotalMoney(1000000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    //    Test khi totalMoney sai định dạng
//    @Test
//    public void createInvoiceDetail_TotalMoney_15() throws Exception {
//        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
//        InvoiceDto invoiceDto = new InvoiceDto();
//        CustomerDto customer = new CustomerDto();
//        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
//        productInvoiceDtoList.get(0).setQuantity(1L);
//        productInvoiceDtoList.get(0).setProductId(1L);
//        invoiceDetailDto.setInvoiceDto(invoiceDto);
//        invoiceDto.setPayments("Tiền mặt");
//        invoiceDto.setTotalMoney("rtre");
//        invoiceDto.setCustomerDto(customer);
//        customer.setCustomerName("Nguyễn Văn D");
//        customer.setPhoneNumber("0904859482");
//        customer.setDateOfBirth("2001-12-09");
//        customer.setEmail("DvanNguyen@gmail.com");
//        customer.setAddress("12 Hồng Hà");
//        customer.setGender(true);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //    Test khi totalMoney bé hơn 500
//    @Test
//    public void createInvoiceDetail_TotalMoney_16() throws Exception {
//        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
//        InvoiceDto invoiceDto = new InvoiceDto();
//        CustomerDto customer = new CustomerDto();
//        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
//        productInvoiceDtoList.get(0).setQuantity(1L);
//        productInvoiceDtoList.get(0).setProductId(1L);
//        invoiceDetailDto.setInvoiceDto(invoiceDto);
//        invoiceDto.setPayments("Tiền mặt");
//        invoiceDto.setTotalMoney(300.0);
//        invoiceDto.setCustomerDto(customer);
//        customer.setCustomerName("Nguyễn Văn D");
//        customer.setPhoneNumber("0904859482");
//        customer.setDateOfBirth("2001-12-09");
//        customer.setEmail("DvanNguyen@gmail.com");
//        customer.setAddress("12 Hồng Hà");
//        customer.setGender(true);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    //    Test khi customerName null
    @Test
    public void createInvoiceDetail_CustomerName_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
//        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi customerName rỗng
    @Test
    public void createInvoiceDetail_CustomerName_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi customerName sai định dạng
    @Test
    public void createInvoiceDetail_CustomerName_15() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D 123");
        customer.setPhoneNumber("0904859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi phoneNumber null
    @Test
    public void createInvoiceDetail_phoneNumber_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
//        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi phoneNumber rỗng
    @Test
    public void createInvoiceDetail_phoneNumber_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi phoneNumber sai đinh dạng
    @Test
    public void createInvoiceDetail_phoneNumber_15() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("090185948234df");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi DateOfBirth null
    @Test
    public void createInvoiceDetail_DateOfBirth_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
//        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi DateOfBirth rỗng
    @Test
    public void createInvoiceDetail_DateOfBirth_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi DateOfBirth sai đinh dạng
    @Test
    public void createInvoiceDetail_DateOfBirth_15() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("090185948234df");
        customer.setDateOfBirth("2001-31-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi Email null
    @Test
    public void createInvoiceDetail_Email_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("2001-12-09");
//        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi Email rỗng
    @Test
    public void createInvoiceDetail_Email_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi Email sai đinh dạng
    @Test
    public void createInvoiceDetail_Email_15() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("090185948234df");
        customer.setDateOfBirth("2001-31-09");
        customer.setEmail("DvanNguyengmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi Address null
    @Test
    public void createInvoiceDetail_Address_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
//        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Test khi Address rỗng
    @Test
    public void createInvoiceDetail_Address_14() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test thành công
    @Test
    public void createInvoiceDetail_18() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        CustomerDto customer = new CustomerDto();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        ProductInvoiceDto productInvoiceDto = new ProductInvoiceDto();
        productInvoiceDto.setProductId(1L);
        productInvoiceDto.setQuantity(1L);
        productInvoiceDtoList.add(productInvoiceDto);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
        invoiceDto.setPayments("Tiền mặt");
        invoiceDto.setTotalMoney(1000.0);
        invoiceDto.setCustomerDto(customer);
        customer.setCustomerName("Nguyễn Văn D");
        customer.setPhoneNumber("0901859482");
        customer.setDateOfBirth("2001-12-09");
        customer.setEmail("DvanNguyen@gmail.com");
        customer.setAddress("12 Hồng Hà");
        customer.setGender(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/invoiceDetail/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
