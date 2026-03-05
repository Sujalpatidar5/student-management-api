package com.cfs.student_api.repo;

import com.cfs.student_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //db se user fetch krna *********************
    Optional<User> findByUsername(String username);
}
