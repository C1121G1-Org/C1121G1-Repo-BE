package api.dto;

<<<<<<< HEAD
=======

import api.services.IProductService;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


>>>>>>> manager-product
public interface IProductDto {
    Long getId();

    String getName();

    Double getPrice();

    String getCpu();

    String getEmail();

    String getMemory();

    String getImage();

    String getQrScan();

    String getScreenSize();

    String getCamera();

    String getSelfie();

    String getOtherDescription();
<<<<<<< HEAD

    Long getQuantity();
=======
    String getQuantity();

>>>>>>> manager-product
}
