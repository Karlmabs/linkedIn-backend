package com.ams.userservice.controllers;

import com.ams.userservice.dto.RoleDto;
import com.ams.userservice.entities.Role;
import com.ams.userservice.mapper.RoleMapper;
import com.ams.userservice.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

  private final RoleService roleService;
  private final RoleMapper mapper;

  public RoleController(RoleService roleService, RoleMapper mapper) {
    this.roleService = roleService;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<RoleDto> createUser(@RequestBody RoleDto roleRequestDto) {
    Role createdRole = roleService.createRole(roleRequestDto);
    return new ResponseEntity<>(mapper.toDto(createdRole), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
    return ResponseEntity.ok(mapper.toDto(roleService.getRoleById(id)));
  }

  @GetMapping
  public ResponseEntity<List<RoleDto>> getAllUsers() {
    List<Role> roles = roleService.getAllRoles();
    return new ResponseEntity<>(mapper.toDtoList(roles), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RoleDto> updateUser(@PathVariable Long id, @RequestBody RoleDto updatedRole) {
    Role updated = roleService.updateRole(id, updatedRole);
    if (updated != null) {
      return new ResponseEntity<>(mapper.toDto(updated), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    roleService.deleteRole(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
