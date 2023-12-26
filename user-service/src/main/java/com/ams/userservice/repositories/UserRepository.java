package com.ams.userservice.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ams.userservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
