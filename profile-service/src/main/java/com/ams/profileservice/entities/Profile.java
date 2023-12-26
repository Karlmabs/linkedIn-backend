package com.ams.profileservice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Long userId; // User ID from User Microservice

  @Column(nullable = false)
  private String currentJobTitle;

  private String industry;

  @Column(columnDefinition = "TEXT")
  private String summary;

  @Column(nullable = false)
  private String headline;

  private String website;

  @Column(nullable = false)
  private boolean isOpenForWork;

  // Assuming education, experience, skills are handled in separate entities
}
