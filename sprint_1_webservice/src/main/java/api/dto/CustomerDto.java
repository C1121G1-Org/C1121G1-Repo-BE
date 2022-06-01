package api.dto;

import api.models.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Validator {

    private Long id;
    @NotBlank(message = "Vui lòng nhập tên khách hàng")
    @Pattern(regexp = "^([^0-9]*)$", message = "Tên khách hàng sai định dạng ")
    private String customerName;
    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(090\\d{7})|(091\\d{7})|(\\(\\+84\\)90\\d{7})|(\\(\\+84\\)91\\d{7})$", message = "Số điện thoại sai định dạng ")
    private String phoneNumber;
    @NotBlank(message = "Vui lòng nhập ngày sinh khách hàng")
    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$", message = "Vui lòng nhập đúng định dạng")
    private String dateOfBirth;
    @NotBlank
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$", message = "vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank
    private String address;
    @NotNull
    private boolean gender;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
