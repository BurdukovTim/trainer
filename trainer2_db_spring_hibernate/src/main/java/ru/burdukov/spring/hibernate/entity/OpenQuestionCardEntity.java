package ru.burdukov.spring.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class OpenQuestionCardEntity {

    @Id
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
    @Column
    private String question;

    @Column
    private String expectedAnswer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }
    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }
}
