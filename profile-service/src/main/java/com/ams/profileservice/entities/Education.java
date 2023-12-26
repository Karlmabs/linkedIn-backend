package com.ams.profileservice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "education")
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Long profileId;

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
