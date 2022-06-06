package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class StorageDto implements Validator {
    private Long id;
    @NotBlank
    private String createdDate;
    private boolean status;
    @NotBlank
    private String quantity;
    private Long createdEmployeeDto;
    private Long productDto;
    private Long supplierDto;
    private boolean deleteFlag;

    public StorageDto(){
        setDeleteFlag(true);
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
        if (storageDto.getCreatedDate().equals("")) {
            errors.rejectValue("createdDate", "createdDate.notBlank", "Created Date must not be blank!");
        } else {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate createdDateLocal = LocalDate.parse(storageDto.getCreatedDate(), formatter);
            if (createdDateLocal.isAfter(currentDate)) {
                errors.rejectValue("createdDate", "createdDate.afterCurrentDate", "Created Date must be before today!");
            }
        }
    }

}
