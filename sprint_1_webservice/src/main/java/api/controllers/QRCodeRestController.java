package api.controllers;

import api.models.Product;
import api.models.ProductQRCode;
import api.services.IProductService;
import api.utils.QRCodeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/*
    Created by HauPV
    Time: 11:50 31/05/2022
    Function: encode and decode QR-Code
    Role : Admin , Storekeeper , Seller
*/

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/qrcode")
public class QRCodeRestController {

    @Autowired
    IProductService iProductService;

    /*
        Function: encode QR-Code
    */
    @PostMapping(value = "/encode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> encode(@RequestBody ProductQRCode productQRCode) {

        if (productQRCode.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> product = iProductService.findById(productQRCode.getId());
        if (product.isPresent() && product.get() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String filePath = QRCodeUtils.encode(productQRCode);
        try {
            ByteArrayResource byteArrayResource = new ByteArrayResource(Files.readAllBytes(Paths.get(filePath)));
            return ResponseEntity.status(HttpStatus.OK).contentLength(byteArrayResource.contentLength()).body(byteArrayResource);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
       Function: decode QR-Code
   */
    @PostMapping(value = "/decode", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductQRCode> decode(@RequestBody MultipartFile file) {
        try {
            BufferedImage bf = ImageIO.read(file.getInputStream());
            ProductQRCode productQRCode = QRCodeUtils.decode(bf);

            if (productQRCode == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(productQRCode, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
   Function: compare 2 QR-Codes
*/
    @PostMapping(value = "/check", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> checkQRCodes(@RequestBody MultipartFile file1, @RequestBody MultipartFile file2) {
        try {
            BufferedImage bf1 = ImageIO.read(file1.getInputStream());
            BufferedImage bf2 = ImageIO.read(file2.getInputStream());
            boolean check = QRCodeUtils.checkQRCodes(bf1, bf2);
            return new ResponseEntity<>(check, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
