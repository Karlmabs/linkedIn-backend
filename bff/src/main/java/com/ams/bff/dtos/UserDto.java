package com.ams.bff.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;

  private String username;

  private String firstName;

  private String lastName;

  private String password;

  private String email;

  private Date birthDate;

  private Date registrationDate;

  private Date lastLoginDate;

}
