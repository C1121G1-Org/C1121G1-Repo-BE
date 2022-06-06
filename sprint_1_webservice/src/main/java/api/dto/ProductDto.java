package api.dto;

import api.models.Product;
import api.services.IProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ProductDto implements Validator {

    private Long id;
    @NotBlank(message = "please input name")
    @Length(max = 255)
    private String name;
    @NotBlank(message = "please input price")
    @Pattern(regexp = "^(([0]*[1-9][0-9]*)|[1-9][0-9]*)$", message = "number must be a number and greater than 0")
    private String price;
    @NotBlank(message = "please input image")
    private String image;
    private String qrScan;
    @NotBlank(message = "Please input screenSize")
    @Length(max = 50)
    private String screenSize;
    @NotBlank(message = "Please input camera")
    @Length(max = 50)
    private String camera;
    @NotBlank(message = "Please input selfie")
    @Length(max = 50)
    private String selfie;
    @NotBlank(message = "Please input cpu")
    @Length(max = 50)
    private String cpu;
    @NotBlank(message = "Please input memory")
    @Length(max = 50)
    private String memory;
    private String otherDescription;
    private IProductService iProductService;
//    private boolean deleteFlag;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;

        String inputtedProductName = productDto.getName();
        Product product = this.iProductService.findProductByName(productDto.getName());
        if (product != null) {
            if (product.getName().equals(inputtedProductName)) {
                errors.rejectValue("name", "", "Tên sản phẩm đã tồn tại");
            }
        }
    }
}

