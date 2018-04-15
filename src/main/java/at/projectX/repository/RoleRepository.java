package at.projectX.repository;

import at.projectX.domain.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {
}
