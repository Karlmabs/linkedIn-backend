package com.ams.postservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles_posts_likes")
public class PostLike {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @Column(nullable = false)
  private Long profileId; // Reference to the Profile entity in the Profile Microservice

  // Getters and setters
}

