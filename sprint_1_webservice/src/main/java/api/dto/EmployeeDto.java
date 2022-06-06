package api.dto;

import api.models.Account;
import api.models.Employee;
import api.services.IAccountService;
import api.services.IEmployeeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Validator {
    private Long id;
    @NotBlank
    @Size(min = 5, max = 50)
    private String employeeName;
    @NotBlank
    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$",message = "nhập đúng định dạng. ")
    private String dateOfBirth;
    @NotBlank
    @Size(min = 5, max = 100)
    private String address;
    @NotBlank
    @Pattern(regexp = "^\\d{9}|\\d{11}$", message = "9 - 10 number please")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)", message = "invalid phone number ex:0901234567")
    private String phoneNumber;
    @NotBlank
    private String image;
    private boolean deleteFlag;
    private PositionDto positionDto;
    @Valid
    private AccountDto accountDto;
    private IAccountService iAccountService;
    @Valid
    private IEmployeeService iEmployeeService ;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String checkUserName = employeeDto.getIdCard();
        Employee employee = this.iEmployeeService.findByIdCard(employeeDto.getIdCard());
        if (employee != null) {
            if (employee.getIdCard().equals(checkUserName)) {
                errors.rejectValue("idCard", "", "số chứng minh  tồn tại");
            }
        }
    }
}
