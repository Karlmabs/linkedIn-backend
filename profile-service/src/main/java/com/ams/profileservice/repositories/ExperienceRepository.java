package com.ams.profileservice.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ams.profileservice.entities.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
