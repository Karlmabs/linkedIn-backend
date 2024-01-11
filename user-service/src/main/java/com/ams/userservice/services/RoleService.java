package com.ams.userservice.services;

import com.ams.userservice.dto.RoleDto;
import com.ams.userservice.entities.Role;
import com.ams.userservice.exceptions.ResourceNotFoundException;
import com.ams.userservice.mapper.RoleMapper;
import com.ams.userservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

  private final RoleRepository roleRepository;
  private final RoleMapper mapper;

  public RoleService(RoleRepository roleRepository, RoleMapper mapper) {
    this.roleRepository = roleRepository;
    this.mapper = mapper;
  }

  public Role createRole(RoleDto roleRequestDto) {
    Role role = mapper.toEntity(roleRequestDto);
    return roleRepository.save(role);
  }

  public Role getRoleById(Long id) throws ResourceNotFoundException {
    return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
  }

  public Role updateRole(Long id, RoleDto updatedRole) throws ResourceNotFoundException {
    Role target = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
    Role updated = mapper.partialUpdate(updatedRole, target);
    return roleRepository.save(updated);
  }

  public void deleteRole(Long id) {
    roleRepository.deleteById(id);
  }

  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }
}
