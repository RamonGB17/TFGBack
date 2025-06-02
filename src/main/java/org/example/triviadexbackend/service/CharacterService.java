package org.example.triviadexbackend.service;

import org.example.triviadexbackend.entity.Character;
import org.example.triviadexbackend.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> getAll() {
        return repository.findAll();
    }

    public List<Character> getByFranchiseId(Long franchiseId) {
        return repository.findByFranchiseId(franchiseId);
    }

    public Optional<Character> getById(Long id) {
        return repository.findById(id);
    }

    public Character create(Character character) {
        return repository.save(character);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
