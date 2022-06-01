package api.controller;

import api.dto.InvoiceDetailDto;
import api.dto.InvoiceDto;
import api.dto.ProductInvoiceDto;
import api.models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

//Create by LongNHLL
//Time: 16h30 01/06/2022
//Function: get list product bestseller from database
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceDetailRestController_SalesManager {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void createSupplier_name_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        Customer customer = new Customer();
        List<ProductInvoiceDto> productInvoiceDtoList = new ArrayList<>();
        productInvoiceDtoList.get(0).setQuantity(1L);
        productInvoiceDtoList.get(0).setProductId(3L);
        invoiceDetailDto.setInvoiceDto(invoiceDto);
            invoiceDto.setPayments("");
            invoiceDto.setTotalMoney(1000000.0);
            invoiceDto.setCustomer(customer);
            customer.setCustomerName("Nguyễn Văn D");
            customer.setPhoneNumber("0904859482");
            customer.setDateOfBirth("2001-12-09");
            customer.setEmail("DvanNguyen@gmail.com");
            customer.setAddress("12 Hồng Hà");
            customer.setGender(true);

//        this.mockMvc.perform(MockMvcRequestBuilders.post(""))


    }


}
