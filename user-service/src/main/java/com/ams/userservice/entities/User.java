package com.ams.userservice.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  private Date birthDate;

  @Column(nullable = false)
  private Date registrationDate;

  private Date lastLoginDate;

}
