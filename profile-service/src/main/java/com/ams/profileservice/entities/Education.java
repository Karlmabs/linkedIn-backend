package com.ams.profileservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "education")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "profile_id", nullable = false)
  private Profile profile;

  @Column(nullable = false)
  private String school;

  @Column(nullable = false)
  private String degree;

  @Column(nullable = false)
  private String fieldOfStudy;

  @Column(nullable = false)
  private Date startDate;

  private Date endDate;
}

