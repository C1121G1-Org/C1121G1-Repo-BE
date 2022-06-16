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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ProductDto implements Validator {

    private Long id;
    @NotBlank(message = "Vui lòng nhập tên")
    @Length(max = 255)
    private String name;
    @NotBlank(message = "Vui lòng nhập giá")
    @Pattern(regexp = "^(([0]*[1-9][0-9]*)|[1-9][0-9]*)$", message = "Giá phải là số và lớn hơn 0")
    private String price;
    @NotBlank(message = "Vui lòng chọn hình ảnh")
    private String image;
    private String qrScan;
    @NotBlank(message = "Vui lòng nhập kích thước màn hình")
    @Length(max = 50)
    private String screenSize;
    @NotBlank(message = "Vui lòng nhập thông số camera")
    @Length(max = 50)
    private String camera;
    @NotBlank(message = "Vui long nhập thông số camera trước")
    @Length(max = 50)
    private String selfie;
    @NotBlank(message = "Vui lòng nhập thông số cpu")
    @Length(max = 50)
    private String cpu;
    @NotBlank(message = "Vui lòng nhập thông số bộ nhớ")
    @Length(max = 50)
    private String memory;
    private String otherDescription;
    private IProductService iProductService;
    private CategoryDto categoryDto;



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
            if (product.getName().equalsIgnoreCase(inputtedProductName)) {
                errors.rejectValue("name", "", "Tên sản phẩm đã tồn tại");
            }
        }
    }

}

