package org.example.triviadexbackend.controller;

import org.example.triviadexbackend.entity.Character;
import org.example.triviadexbackend.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Character> getAll() {
        return service.getAll();
    }

    @GetMapping("/franchise/{franchiseId}")
    public List<Character> getByFranchise(@PathVariable Long franchiseId) {
        return service.getByFranchiseId(franchiseId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Character create(@RequestBody Character character) {
        return service.create(character);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
