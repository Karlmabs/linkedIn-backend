package com.ams.profileservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long userId; // Reference to User entity in User Microservice

  @Column(nullable = false)
  private String currentJobTitle;

  private String industry;

  @Column(length = 1000)
  private String summary;

  @Column(nullable = false)
  private String headline;

  private String website;

  @Column(nullable = false)
  private Boolean openForWork;

  @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Education> education;

  @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Experience> experiences;

  @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<ProfileSkill> skills;

  @ManyToMany
  @JoinTable(
          name = "profiles_connections",
          joinColumns = @JoinColumn(name = "profile1_id"),
          inverseJoinColumns = @JoinColumn(name = "profile2_id")
  )
  private Set<Profile> connections = new HashSet<>();

}
