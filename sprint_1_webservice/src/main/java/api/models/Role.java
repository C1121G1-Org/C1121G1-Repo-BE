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
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private Set<AccountRole> accountRoleSet;

}
