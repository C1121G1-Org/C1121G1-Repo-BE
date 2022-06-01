package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    private Double price;
    @NotBlank
    private String image;
    private String qrScan;
    private String screenSize;
    private String camera;
    private String selfie;
    private String cpu;
    private String memory;
    private String otherDescription;
}
