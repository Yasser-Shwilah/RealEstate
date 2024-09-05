package com.realestate.Real_Estate.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.Real_Estate.entity.Role.RoleType;
import com.realestate.Real_Estate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
     List<User> findByRole(RoleType role);
}

