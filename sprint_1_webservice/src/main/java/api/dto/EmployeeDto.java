package api.dto;

//import api.services.IAccountService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto implements Validator {
    private Long id;
    private String employeeName;
    private String dateOfBirth;
    private String address;
    private String idCard;
    private String phoneNumber;
    private String image;
    private boolean deleteFlag;
    private PositionDto positionDto;
    private AccountDto accountDto;
//    private IAccountService iAccountService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
