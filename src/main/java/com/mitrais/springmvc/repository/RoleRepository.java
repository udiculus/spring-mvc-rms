package com.mitrais.springmvc.repository;

import com.mitrais.springmvc.model.Role;
import com.mitrais.springmvc.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
