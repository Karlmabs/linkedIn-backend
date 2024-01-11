package com.ams.userservice.dto;

import com.ams.userservice.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

  private Long id;

  private String username;

  private String firstName;

  private String lastName;

  private String password;

  private String email;

  private Date birthDate;

  private Date registrationDate;

  private Date lastLoginDate;

  private Set<Role> roles = new HashSet<>();
}
