package org.example.triviadexbackend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trivias")
public class Trivia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category; // anime o videojuegos
    private String question;
    private String correctAnswer;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "trivia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TriviaOption> options;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<TriviaOption> getOptions() { return options; }
    public void setOptions(List<TriviaOption> options) { this.options = options; }
}
