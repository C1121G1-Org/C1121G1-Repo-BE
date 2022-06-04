package api.utils;

import api.models.Product;
import api.models.ProductQRCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ByteArrayResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Hashtable;

public class QRCodeUtils {

    private static final String PATH = "D:\\qrcode\\";

    public static String encode(ProductQRCode productQRCode) {
        String filePath = PATH + "PD-" + productQRCode.getId() + ".png";

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonProduct = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productQRCode);

            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix bitMatrix = new MultiFormatWriter().encode(jsonProduct, BarcodeFormat.QR_CODE, 500, 500, hashtable);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", Paths.get(filePath));

            return filePath;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ProductQRCode decode(BufferedImage bf) {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf)));
        try {
            Result rs = new MultiFormatReader().decode(binaryBitmap);
            ObjectMapper mapper = new ObjectMapper();

            ProductQRCode productQRCode = mapper.readValue(rs.getText(), ProductQRCode.class);

            return productQRCode;
        } catch (NotFoundException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkQRCodes(BufferedImage bf1, BufferedImage bf2) {
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf1)));
        BinaryBitmap bitmap2 = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf2)));

        try {
            Result rs1 = new MultiFormatReader().decode(bitmap1);
            Result rs2 = new MultiFormatReader().decode(bitmap2);

            ObjectMapper mapper = new ObjectMapper();

            ProductQRCode product1 = mapper.readValue(rs1.getText(), ProductQRCode.class);
            ProductQRCode product2 = mapper.readValue(rs2.getText(), ProductQRCode.class);

            return product1.equals(product2);

        } catch (NotFoundException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }


}
