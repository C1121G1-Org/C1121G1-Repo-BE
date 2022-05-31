package api.utils;

import api.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;

public class QRCodeUtils {

    private static final String PATH = "D:\\sprint-1\\test-qrcode\\";

    public static String encode(Product product) {
        String filePath = PATH + "PD-" + product.getId() + ".png";

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonProduct = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);

            System.out.println(jsonProduct);

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

    public static Product decode(BufferedImage bf) {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf)));
        try {
            Result rs = new MultiFormatReader().decode(binaryBitmap);

            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.readValue(rs.getText(), Product.class);
            return product;
        } catch (NotFoundException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkQRCodes(BufferedImage bf1, BufferedImage bf2) {
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf1)));
        BinaryBitmap bitmap2 = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf2)));

        try {
            Result rs1 = new MultiFormatReader().decode(bitmap1);
            Result rs2 = new MultiFormatReader().decode(bitmap2);

            ObjectMapper mapper = new ObjectMapper();

            Product product1 = mapper.readValue(rs1.getText(), Product.class);
            Product product2 = mapper.readValue(rs2.getText(), Product.class);

            return product1.equals(product2);

        } catch (NotFoundException | JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
