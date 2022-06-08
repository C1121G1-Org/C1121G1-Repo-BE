
package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "storage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", length = 50)
    private String createdDate;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "quantity", nullable = false, columnDefinition = "BIGINT default 0")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee createdEmployee;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, referencedColumnName = "id")
    private Supplier supplier;

    @Column(name = "delete_flag", nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean deleteFlag;

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", createdDate='" + createdDate + '\'' +
                ", status=" + status +
                ", quantity=" + quantity +
                ", createdEmployee=" + createdEmployee +
                ", product=" + product +
                ", supplier=" + supplier +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
