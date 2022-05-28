package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", length = 50)
    private String createdDate;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "quantity", nullable = false)
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

    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;

}
