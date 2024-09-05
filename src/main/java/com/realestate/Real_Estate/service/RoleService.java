package com.realestate.Real_Estate.service;


import com.realestate.Real_Estate.entity.Role;
import com.realestate.Real_Estate.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Create a new Role
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    // Get all Roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get a Role by ID
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    // Update a Role
    public Role updateRole(Long id, Role updatedRole) {
        return roleRepository.findById(id)
                .map(role -> {
                    role.setName(updatedRole.getName());
                    role.setRoleType(updatedRole.getRoleType());
                    return roleRepository.save(role);
                })
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

    // Delete a Role by ID
    public void deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Role not found with id " + id);
        }
    }
}

