package com.ams.postservice.entities;

import jakarta.persistence.*;

import java.util.Date;

import java.util.Set;

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long profileId; // Reference to the Profile entity in the Profile Microservice

  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;

  @Column(nullable = false)
  private Date creationDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id")
  private Comment parentComment;

  @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Comment> replies;

  @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<CommentLike> likes;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;
}

