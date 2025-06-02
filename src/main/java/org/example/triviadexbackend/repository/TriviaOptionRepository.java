package org.example.triviadexbackend.repository;

import org.example.triviadexbackend.entity.TriviaOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaOptionRepository extends JpaRepository<TriviaOption, Long> {
}
