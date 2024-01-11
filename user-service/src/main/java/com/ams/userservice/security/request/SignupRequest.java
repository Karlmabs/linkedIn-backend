package com.ams.userservice.security.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
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
