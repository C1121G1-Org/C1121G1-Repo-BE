package api.dto;

import api.services.IAccountService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Validator {
    private Long id;
    @NotBlank(message = "not blank")
    private String userName;
    @NotBlank(message = "not blank")
    private String encryptPassword;
    @NotBlank(message = "not blank")
    @Pattern(regexp ="^[a-z][a-z0-9\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$" ,message = "sai định dạng email")
    private String email;
    private Boolean isEnabled;
    private String verificationCode;
    private EmployeeDto employeeDto;
    @Valid
    private IAccountService iAccountService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }


}
