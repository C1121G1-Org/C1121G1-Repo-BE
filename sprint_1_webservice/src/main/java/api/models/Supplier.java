
package api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonBackReference
    private Set<Storage> storageSet;

    @Column(name = "delete_flag", nullable = false, columnDefinition = "BIT(1) default 1")
    private boolean deleteFlag;


}
