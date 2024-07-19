package com.vanlang.dao;

import com.vanlang.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, String> {

}
