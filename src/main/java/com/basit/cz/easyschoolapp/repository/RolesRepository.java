package com.basit.cz.easyschoolapp.repository;

import com.basit.cz.easyschoolapp.model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer> {
    Roles getByRoleName(String roleName);
}
