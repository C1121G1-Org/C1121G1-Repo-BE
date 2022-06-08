package api.repositories;


import api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findRoleById( Integer Id);
}
