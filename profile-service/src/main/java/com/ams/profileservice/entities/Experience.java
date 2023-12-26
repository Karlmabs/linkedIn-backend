package com.ams.profileservice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "experiences")
public class Experience {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Long profileId;

  @Column(nullable = false)
  private String jobTitle;

  @Column(nullable = false)
  private String companyName;

  @Column(nullable = false)
  private String location;

  @Column(nullable = false)
  private Date startDate;

  private Date endDate;

}

