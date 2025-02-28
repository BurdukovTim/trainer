package ru.burdukov.domain.model;

public class OpenQuestionCard {
    private final String question;
    private final String expectedAnswer;
    final static String errorMessage = "Поле question не должно быть null.";

    public OpenQuestionCard(String question, String expectedAnswer) {
        if (question == null || question.trim().isEmpty()){
            throw new IllegalArgumentException(errorMessage);
        }

        if (expectedAnswer == null || expectedAnswer.trim().isEmpty()){
            throw new IllegalArgumentException(errorMessage);
        }
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean checkAnswer(String userAnswer) {
        return expectedAnswer.equals(userAnswer);
    }

    @Override
    public String toString() {
        return "OpenQuestionCard{" +
                "question='" + question + '\'' +
                ", expectedAnswer='" + expectedAnswer + '\'' +
                '}';
    }
}