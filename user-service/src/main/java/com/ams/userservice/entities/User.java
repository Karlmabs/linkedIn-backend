package com.ams.userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

  private String phoneNumber;

  private Date birthDate;

  @Column(nullable = false)
  private Date registrationDate = new Date();

  private Date lastLoginDate;

  @ManyToMany
  @JoinTable(joinColumns = @JoinColumn(name = "user_id"))
  private Set<Role> roles = new HashSet<>();

}
