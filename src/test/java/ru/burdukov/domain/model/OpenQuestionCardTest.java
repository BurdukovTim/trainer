package ru.burdukov.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class OpenQuestionCardTest {

    private static final String CARD_QUESTION = "Что такое git pull?";

    private static final String CARD_EXPECTED_ANSWER = "Git pull используется для извлечения и загрузки содержимого из " +
            "удаленного репозитория и немедленного обновления локального репозитория этим содержимым";

    private OpenQuestionCard openQuestionCard;

    @BeforeEach
    void setUp() {
        openQuestionCard = new OpenQuestionCard(CARD_QUESTION, CARD_EXPECTED_ANSWER);
    }


    @Test
    @DisplayName("OpenQuestionCard создаётся с правильными question и expectedQuestion")
    void having_correctQuestion_when_newOpenQuestionCard_then_created(){
        Assertions.assertEquals(CARD_QUESTION, openQuestionCard.getQuestion());
    }

    @Test
    @DisplayName("В OpenQuestionCard при создании нового экземпляра класса с question равным null выбрасывается исключение")
    void having_nullQuestion_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(null, CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("В OpenQuestionCard при создании нового экземпляра класса с question равным null выбрасывается исключение")
    void having_nullExpectedAnswer_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(CARD_QUESTION, null));
    }

    @Test
    @DisplayName("В OpenQuestionCard при создании нового экземпляра класса с пустым question выбрасывается исключение")
    void having_emptyQuestion_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard("", CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("В OpenQuestionCard при создании нового экземпляра класса с пустым expectedAnswer выбрасывается исключение")
    void having_emptyExpectedAnswer_when_newOpenQuestionCard_then_exceptionThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(CARD_QUESTION, ""));
    }

    @Test
    @DisplayName("Проверка ответа методом checkAnswer() проходит успешно")
    void having_correctResult_while_using_checkAnswer_method() {
        String answer = "Неверный ответ";
        Assertions.assertTrue(openQuestionCard.checkAnswer(CARD_EXPECTED_ANSWER));
        Assertions.assertFalse(openQuestionCard.checkAnswer(answer));
    }
}