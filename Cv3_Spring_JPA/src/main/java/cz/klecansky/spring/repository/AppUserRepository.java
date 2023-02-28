package cz.klecansky.spring.repository;

import cz.klecansky.spring.entity.AppUser;
import cz.klecansky.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    List<AppUser> findByActive(boolean active);

    @Query("SELECT u FROM AppUser u JOIN u.roles r WHERE r.name = :roleName")
    List<AppUser> getAppUserByRoles(@Param("roleName") String roleName);

}