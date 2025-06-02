package org.example.triviadexbackend.controller;

import org.example.triviadexbackend.entity.UserTriviaAnswer;
import org.example.triviadexbackend.service.UserTriviaAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-trivia-answers")
@CrossOrigin
public class UserTriviaAnswerController {

    private final UserTriviaAnswerService service;

    public UserTriviaAnswerController(UserTriviaAnswerService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserTriviaAnswer> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<UserTriviaAnswer> getByUserId(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTriviaAnswer> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserTriviaAnswer create(@RequestBody UserTriviaAnswer answer) {
        return service.create(answer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
