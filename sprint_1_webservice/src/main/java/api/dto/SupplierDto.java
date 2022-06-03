package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import api.models.Supplier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import api.services.ISupplierService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class SupplierDto implements Validator {
    private Long id;

    @NotBlank(message = "Supplier name can not empty")
    private String supplierName;

    @NotBlank(message = "Address can not empty")
    private String address;

    @NotBlank(message = "Phone can not empty")
    @Pattern(regexp = "^$|(09)[0-9]{8}", message = "Phone number starting with 09 and 10 numbers")
    private String phone;

    @NotBlank(message = "Email can not empty")
    @Pattern(regexp = "^$|[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)", message = "Please enter the correct format")
    private String email;

    private boolean deleteFlag;

    private ISupplierService isupplierService;

    public SupplierDto() {
        setDeleteFlag(true);
    }

    public ISupplierService getIsupplierService() {
        return isupplierService;
    }

    public void setIsupplierService(ISupplierService isupplierService) {
        this.isupplierService = isupplierService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SupplierDto supplierDto = (SupplierDto) target;
        String supplierName = supplierDto.getSupplierName();
        Supplier supplier = this.isupplierService.findBySupplierName(supplierName);
        if (supplier != null) {
            if (supplier.getSupplierName().equals(supplierName)) {
                errors.rejectValue("supplierName", "", "Name is already existed");
            }
        }
    }
}
