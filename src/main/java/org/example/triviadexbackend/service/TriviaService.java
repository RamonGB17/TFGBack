package org.example.triviadexbackend.service;

import org.example.triviadexbackend.entity.Trivia;
import org.example.triviadexbackend.repository.TriviaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TriviaService {

    private final TriviaRepository repository;

    public TriviaService(TriviaRepository repository) {
        this.repository = repository;
    }

    public List<Trivia> getAll() {
        return repository.findAll();
    }

    public List<Trivia> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Optional<Trivia> getById(Long id) {
        return repository.findById(id);
    }

    public Trivia create(Trivia trivia) {
        return repository.save(trivia);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
