package com.ams.profileservice.repositories;

import com.ams.profileservice.entities.ProfileSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileSkillRepository extends JpaRepository<ProfileSkill, Long> {
}
