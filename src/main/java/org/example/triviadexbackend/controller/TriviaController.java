package org.example.triviadexbackend.controller;

import org.example.triviadexbackend.entity.Trivia;
import org.example.triviadexbackend.service.TriviaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trivias")
@CrossOrigin
public class TriviaController {

    private final TriviaService service;

    public TriviaController(TriviaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trivia> getAll() {
        return service.getAll();
    }

    @GetMapping("/category/{category}")
    public List<Trivia> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trivia> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trivia create(@RequestBody Trivia trivia) {
        return service.create(trivia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
