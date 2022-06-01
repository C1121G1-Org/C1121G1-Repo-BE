package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class StorageDto implements Validator {
    private Long id;
    @NotBlank(message = "Quantity must be not blank! Please input!")
    private String createdDate;
    @NotNull(message = "Status must be not empty! Please input!")
    private Boolean status;
    @NotBlank(message = "Quantity must be not blank! Please input!")
    private String quantity;
    @NotNull(message = "Status must be not empty! Please input!")
    private Long createdEmployeeDto;
    @NotNull(message = "Status must be not empty! Please input!")
    private Long productDto;
    @NotNull(message = "Status must be not empty! Please input!")
    private Long supplierDto;
    private boolean deleteFlag;

    public StorageDto(){
        setDeleteFlag(false);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: validate() = validate quantity and validate createdDate
    */

    @Override
    public void validate(Object target, Errors errors) {
        StorageDto storageDto = (StorageDto) target;

        //Validate an Integer
        if (storageDto.getQuantity() != null){
            if (!storageDto.getQuantity().matches("^$|^\\s*$|^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,4})?\\s*$")){
                errors.rejectValue("quantity", "", "Wrong format (Quantity must be a number greater than 0)");
            }
        }
        //Validate createdDate
        if (storageDto.getCreatedDate() == null || storageDto.getCreatedDate().equals("")) {
            errors.rejectValue("createdDate", "createdDate.notBlank", "Created Date must not be blank!");
        } else {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate createdDate = LocalDate.parse(storageDto.getCreatedDate(), formatter);
            if (createdDate.isAfter(currentDate)) {
                errors.rejectValue("createdDate", "createdDate.afterCurrentDate", "Created Date must be before today!");
            }
        }
    }

}
