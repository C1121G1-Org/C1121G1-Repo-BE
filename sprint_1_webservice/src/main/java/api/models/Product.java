package api.models;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> d4e22ab7f3cd7d1d5c860991ebbf5904c208d0a6
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;
    @Column(name = "qr_scan", columnDefinition = "LONGTEXT")
    private String qrScan;
    @Column(name = "screen_size", length = 50)
    private String screenSize;
    @Column(name = "camera", length = 50)
    private String camera;
    @Column(name = "selfie", length = 50)
    private String selfie;
    @Column(name = "cpu", length = 50)
    private String cpu;
    @Column(name = "memory", length = 50)
    private String memory;

    @Column(name = "other_description", columnDefinition = "LONGTEXT")
    private String otherDescription;

    @OneToMany(mappedBy = "product")
<<<<<<< HEAD
=======
    @JsonBackReference
>>>>>>> d4e22ab7f3cd7d1d5c860991ebbf5904c208d0a6
    private Set<Storage> storageSet;

    @Column(name = "delete_flag", nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean deleteFlag;

    @OneToMany(mappedBy = "product")
<<<<<<< HEAD
    private Set<InvoiceDetail> invoiceDetailSet;
=======
    @JsonBackReference
    private Set<InvoiceDetail> invoiceDetailSet;


    /*
        Create by: hauPV
        Penalty: 5k
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return deleteFlag == product.deleteFlag && id.equals(product.id) && Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) && Objects.equals(image, product.image) &&
                Objects.equals(qrScan, product.qrScan) && Objects.equals(screenSize, product.screenSize) &&
                Objects.equals(camera, product.camera) && Objects.equals(selfie, product.selfie) &&
                Objects.equals(cpu, product.cpu) && Objects.equals(memory, product.memory) &&
                Objects.equals(otherDescription, product.otherDescription);
    }

    @Override
    public int hashCode() {
        return 22;
    }

>>>>>>> d4e22ab7f3cd7d1d5c860991ebbf5904c208d0a6
}
