package api.dto;

import api.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;
    private String createTime;
    private String createDate;
    private Double totalMoney;
    @NotEmpty(message = "Vui lòng nhập loại thanh toán")
    private String payments;
    @Valid
    private Customer customer;

}
