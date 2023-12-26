package com.ams.postservice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Long postId;

  @Column(nullable = false)
  private Long profileId; // Profile ID from Profile Microservice

  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;

  private Long commentId; // For reply to another comment

  @Column(nullable = false)
  private Date creationDate;

  // Getters and setters
}

