package com.ams.bff.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest implements Serializable {

  private String username;

  private String firstName;

  private String lastName;

  private String password;

  private String email;

  private String phoneNumber;

  private Date birthDate;

  private Date registrationDate = new Date();

  private Date lastLoginDate;

  private Set<String> role;

}
