package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_name", nullable = false, length = 50)
    private String employeeName;
    @Column(name = "date_of_birth", length = 50)
    private String dateOfBirth;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "id_card", length = 50)
    private String idCard;
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToMany(mappedBy = "createdEmployee")
    private Set<Storage> storageSet;

    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;
}
