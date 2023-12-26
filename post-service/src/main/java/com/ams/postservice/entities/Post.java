package com.ams.postservice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Long profileId; // Profile ID from Profile Microservice

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;

  @Column(nullable = false)
  private Date creationDate;

  // Getters and setters
}

