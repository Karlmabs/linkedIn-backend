package com.ams.postservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profiles_comments_likes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentLike {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id", nullable = false)
  private Comment comment;

  @Column(nullable = false)
  private Long profileId; // Reference to the Profile entity in the Profile Microservice

}

