package api.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create CustomerDto
     */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Validator {

    private Long id;



    @NotBlank(message = "Vui lòng nhập tên khách hàng ")
    @Pattern(regexp = "^([^0-9]*)$", message = "Tên khách hàng sai định dạng ")
    private String customerName;

    @NotBlank(message = "Vui lòng nhập số điện thoại ")
    @Pattern(regexp = "^(090\\d{7})|(091\\d{7})|(\\(\\+84\\)90\\d{7})|(\\(\\+84\\)91\\d{7})$", message = "Số điện thoại sai định dạng ")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập ngày sinh khách hàng")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "vui lòng nhập đúng định dạng")
    private String dateOfBirth;
    @NotBlank
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$", message = "vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập địa chỉ ")
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
