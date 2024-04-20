package com.example.railway.repository;

import com.example.railway.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAndEnabledTrue(String email);


    Optional<User> findByEmail(String email);

    Optional<User> findByIdAndEnabledIsTrue(Long id);


}