package api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


/*
    Created by HauPV
    Time: 10:00 02/06/2022
    Function: display QR Code information
*/


@Getter
@Setter
public class ProductQRCode {
    private Long id;
    private String name;
    private Double price;
    private String image;
    private String qrScan;
    private String screenSize;
    private String camera;
    private String selfie;
    private String cpu;
    private String memory;
    private boolean deleteFlag;

    public ProductQRCode() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQRCode that = (ProductQRCode) o;
        return deleteFlag == that.deleteFlag && id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(image, that.image) && Objects.equals(qrScan, that.qrScan) && Objects.equals(screenSize, that.screenSize) && Objects.equals(camera, that.camera) && Objects.equals(selfie, that.selfie) && Objects.equals(cpu, that.cpu) && Objects.equals(memory, that.memory);
    }

    @Override
    public int hashCode() {
        return 22;
    }

    @Override
    public String toString() {
        return "ProductQRCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", qrScan='" + qrScan + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", camera='" + camera + '\'' +
                ", selfie='" + selfie + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
