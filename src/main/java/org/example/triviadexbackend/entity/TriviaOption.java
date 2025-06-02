package org.example.triviadexbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trivia_options")
public class TriviaOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answerText;

    @ManyToOne
    @JoinColumn(name = "trivia_id")
    private Trivia trivia;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAnswerText() { return answerText; }
    public void setAnswerText(String answerText) { this.answerText = answerText; }

    public Trivia getTrivia() { return trivia; }
    public void setTrivia(Trivia trivia) { this.trivia = trivia; }
}
