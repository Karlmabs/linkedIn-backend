package com.ams.bff.controllers;

import com.ams.bff.dtos.AuthResponse;
import com.ams.bff.dtos.LoginRequest;
import com.ams.bff.dtos.SignupRequest;
import com.ams.bff.dtos.UserDto;
import com.ams.bff.services.UserApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userApi")
public class UserApiController {

  private final UserApiService userService;

  private final RestTemplate restTemplate;

  public UserApiController(UserApiService userService, RestTemplate restTemplate) {
    this.userService = userService;
    this.restTemplate = restTemplate;
  }

  @Operation(summary = "Register a new user")
  @ApiResponse(responseCode = "200", description = "User registration completed successfully !!",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = AuthResponse.class)) })
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    return restTemplate.postForEntity("http://user-service:8080/api/auth/signup", signUpRequest, AuthResponse.class);
  }

  @Operation(summary = "authenticate a user")
  @ApiResponse(responseCode = "200", description = "User logged in successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = AuthResponse.class)) })
  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    return restTemplate.postForEntity("http://user-service:8080/api/auth/login", loginRequest, Object.class);
  }

  @Operation(summary = "Get all users")
  @ApiResponse(responseCode = "200", description = "Found the users",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto[].class)) })
  @GetMapping
  public UserDto[] getUsers(){
    return restTemplate.getForObject("http://user-service:8080/api/users", UserDto[].class);
  }

  @Operation(summary = "Get a user by ID")
  @ApiResponse(responseCode = "200", description = "Found the user",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@Parameter(description = "ID of the user to be obtained") @PathVariable Long id){
    return restTemplate.getForEntity("http://user-service:8080/api/users/"+id, UserDto.class, id);
  }

  @Operation(summary = "Update a user")
  @ApiResponse(responseCode = "200", description = "User updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = UserDto.class)) })
  @PutMapping("/{id}")
  public void updateUser(@Parameter(description = "ID of the user to be updated") @PathVariable Long id,
                                            @RequestBody UserDto userDto){
    restTemplate.put("http://user-service:8080/api/users/"+id, userDto, UserDto.class, id);
  }

  @Operation(summary = "Delete a user")
  @ApiResponse(responseCode = "204", description = "User deleted successfully")
  @DeleteMapping("/{id}")
  public void deleteUser(@Parameter(description = "ID of the user to be deleted") @PathVariable Long id){
    restTemplate.delete("http://user-service:8080/api/users/"+id, id);
  }

}
