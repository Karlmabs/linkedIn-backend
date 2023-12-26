package com.ams.profileservice.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ams.profileservice.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>  {
}
