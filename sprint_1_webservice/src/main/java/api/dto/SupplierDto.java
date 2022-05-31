package api.dto;

import api.models.Supplier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import api.services.ISupplierService;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
        String supplierName = supplierDto.getSupplierName();
        Supplier supplier = this.isupplierService.findBySupplierName(supplierName);
        if(supplier!=null){
            if(supplier.getSupplierName().equals(supplierName)){
                errors.rejectValue("supplierName","","Name is already existed");
            }
        }
    }
}