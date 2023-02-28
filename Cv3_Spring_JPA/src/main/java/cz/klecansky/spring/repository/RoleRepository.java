package cz.klecansky.spring.repository;

import cz.klecansky.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}