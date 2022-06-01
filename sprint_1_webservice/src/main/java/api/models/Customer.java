package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Customer(String customerName, String phoneNumber, String dateOfBirth, String email, String address, boolean gender) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }
}
