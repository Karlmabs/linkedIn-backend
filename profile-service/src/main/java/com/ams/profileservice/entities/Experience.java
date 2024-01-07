package com.ams.profileservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Experience {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "profile_id", nullable = false)
  private Profile profile;

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


