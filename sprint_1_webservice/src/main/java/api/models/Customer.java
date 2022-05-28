package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name", nullable = false, length = 255)
    private String customerName;
    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;
    @Column(name = "date_of_birth", nullable = false, length = 50)
    private String dateOfBirth;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Column(name = "gender", nullable = false)
    private boolean gender;

    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoiceSet;

}
