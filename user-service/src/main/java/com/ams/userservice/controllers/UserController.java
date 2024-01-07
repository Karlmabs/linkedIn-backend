
package com.ams.userservice.controllers;

import com.ams.userservice.dto.UserDto;
import com.ams.userservice.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

  @Operation(summary = "Get all users")
  @ApiResponse(responseCode = "200", description = "Found the users",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto.class)) })
  @GetMapping
  public ResponseEntity<List<UserDto>> getUsers(){
    return ResponseEntity.ok(userService.findAll());
  }

  @Operation(summary = "Create a new user")
  @ApiResponse(responseCode = "200", description = "User created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto.class)) })
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
    return ResponseEntity.ok(userService.save(userDto));
  }

  @Operation(summary = "Get a user by ID")
  @ApiResponse(responseCode = "200", description = "Found the user",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@Parameter(description = "ID of the user to be obtained") Long id){
    return ResponseEntity.ok(userService.findById(id));
  }

  @Operation(summary = "Update a user")
  @ApiResponse(responseCode = "200", description = "User updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<UserDto> updateUser(@Parameter(description = "ID of the user to be updated") @PathVariable Long id,
                                            @RequestBody UserDto userDto){
    return ResponseEntity.ok(userService.update(id, userDto));
  }

  @Operation(summary = "Delete a user")
  @ApiResponse(responseCode = "204", description = "User deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@Parameter(description = "ID of the user to be deleted") @PathVariable Long id){
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
