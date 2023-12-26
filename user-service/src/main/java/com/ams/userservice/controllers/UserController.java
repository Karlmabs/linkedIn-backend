package com.ams.userservice.controllers;

import com.ams.userservice.dto.UserDto;
import com.ams.userservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  public final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getUsers(){
    return ResponseEntity.ok(userService.findAll());
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
    return ResponseEntity.ok(userService.save(userDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(Long id){
    return ResponseEntity.ok(userService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
    return ResponseEntity.ok(userService.update(id, userDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
