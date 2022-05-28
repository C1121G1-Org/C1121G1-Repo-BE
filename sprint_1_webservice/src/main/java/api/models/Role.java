package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<AccountRole> accountRoleSet;

}
