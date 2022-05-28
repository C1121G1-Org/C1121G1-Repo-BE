package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "supplier_name", nullable = false, length = 50)
    private String supplierName;
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "supplier")
    private Set<Storage> storageSet;

    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;


}
