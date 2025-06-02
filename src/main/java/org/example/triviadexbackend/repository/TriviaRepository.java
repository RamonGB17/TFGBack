package org.example.triviadexbackend.repository;

import org.example.triviadexbackend.entity.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriviaRepository extends JpaRepository<Trivia, Long> {

    List<Trivia> findByCategory(String category);
}
