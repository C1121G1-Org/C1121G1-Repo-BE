package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotBlank(message = "please input name")
    @Length(max = 255)
    private String name;
//    @NotEmpty(message = "please input price")
    private String price;
    @NotBlank(message = "please input image")
    private String image;
    private String qrScan;
    @NotBlank(message = "Please input screenSize")
    @Length(max = 255)
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
}
