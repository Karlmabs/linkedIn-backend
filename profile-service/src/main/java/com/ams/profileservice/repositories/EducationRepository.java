package com.ams.profileservice.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ams.profileservice.entities.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
