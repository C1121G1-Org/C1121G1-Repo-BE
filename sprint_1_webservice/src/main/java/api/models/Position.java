package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "position_name", nullable = false, length = 50)
    private String positionName;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employeeSet;

}
