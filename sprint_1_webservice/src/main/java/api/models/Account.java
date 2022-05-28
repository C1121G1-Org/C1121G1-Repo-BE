package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Column(name = "encrypt_password", nullable = false, columnDefinition = "LONGTEXT")
    private String encryptPassword;
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;

    @Column(name = "verification_code", nullable = false, length = 255)
    private String verificationCode;

    @OneToOne(mappedBy = "account")
    private Employee employee;

    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoleSet;

}
