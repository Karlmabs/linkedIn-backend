package com.ams.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

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
}
