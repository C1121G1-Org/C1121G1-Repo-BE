package api.dto;

import api.models.Supplier;
import api.services.ISupplierService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
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
    @Email(message = "Please enter the correct format")
    private String email;

    private boolean deleteFlag;

    private ISupplierService isupplierService;

    public SupplierDto() {
         setDeleteFlag(false);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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
        String supplierNameValidate = supplierDto.getSupplierName();
        Supplier supplier = this.isupplierService.findBySupplierName(supplierNameValidate);
        if (supplier != null) {
            if (supplier.getSupplierName().equals(supplierNameValidate)) {
                errors.rejectValue("supplierName", "", "Tên nhà cung cấp đã tồn tại!");
            }
        }
        String emailValidate = supplierDto.getEmail();
        Supplier supplier1 = this.isupplierService.findByEmail(emailValidate);
        if(supplier1 != null) {
            if(supplier1.getEmail().equals(emailValidate)){
                errors.rejectValue("email", "", "Email không được trùng!");
            }
        }

    }

}
