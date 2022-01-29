package com.mockpage.schoolwebapp.schoolpage.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
