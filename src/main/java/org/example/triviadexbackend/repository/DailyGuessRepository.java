package org.example.triviadexbackend.repository;

import org.example.triviadexbackend.entity.DailyGuess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyGuessRepository extends JpaRepository<DailyGuess, Long> {

    List<DailyGuess> findByUserId(Long userId);

    Optional<DailyGuess> findByUserIdAndGuessDate(Long userId, LocalDate guessDate);

    Optional<DailyGuess> findByGuessDate(LocalDate guessDate);
}
