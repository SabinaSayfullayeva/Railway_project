package com.example.railway.repository;

import com.example.railway.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card> findAllByUserName(String username);
}
