
package com.course_work.posSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course_work.posSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Custom queries can be added here
    Optional<User> findByUsername(String username);
}

