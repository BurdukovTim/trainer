package ru.burdukov.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.burdukov.domain.model.OpenQuestionCard;
import ru.burdukov.domain.repo.QuestionRepository;

import java.util.List;
import java.util.Optional;

public class QuestionServiceTest {
    private QuestionService questionService;
    private QuestionRepository questionRepository;
    @BeforeEach
    void setUp() {
        questionRepository = Mockito.mock(QuestionRepository.class);
        questionService = new QuestionService(questionRepository);
    }

    @Test
    @DisplayName("Получение существующего вопроса по id")
    void having_taskInRepo_when_getById_then_returnQuestion() {
        Mockito.when(questionRepository.findById(12L))
                .thenReturn(Optional.of(new OpenQuestionCard(12L, "Вопрос 1", "Ответ 1")));
        Optional<OpenQuestionCard> openQuestionCard = questionService.getById(12L);
        Assertions.assertTrue(openQuestionCard.isPresent());
    }

    @Test
    @DisplayName("При сохранении нововй задачи, вызывается метод add у репозитория")
    void having_noTaskInRepo_when_save_then_repoAddIsInvoken() {
        OpenQuestionCard openQuestionCard = new OpenQuestionCard(12L, "Вопрос 1", "Ответ 1");
        questionService.save(openQuestionCard);
        Mockito.verify(questionRepository).add(Mockito.any());
    }

    @Test
    @DisplayName("При попытке получить вопросы, когда репозиторий пуст, получаем пустой список")
    void having_noTaskInRepo_when_getAll_then_returnEmpty() {
        List<OpenQuestionCard> question = questionService.getAll();
        Assertions.assertTrue(question.isEmpty());
    }

    @Test
    @DisplayName("При попытке получить несуществующий вопрос по id, получаем Optional.empty")
    void having_noQuestionInRepo_when_getById_then_returnEmpty() {
        Optional<OpenQuestionCard> question = questionService.getById(12L);
        Assertions.assertFalse(question.isPresent());
    }

    @Test
    @DisplayName("При попытке получить вопрос по коду null, получаем Optional.empty")
    void having_nullId_when_getById_then_returnEmpty() {
        Optional<OpenQuestionCard> question = questionService.getById(null);
        Assertions.assertFalse(question.isPresent());
    }

    @Test
    @DisplayName("Проверка существования вопроса успешна, если вопрос есть в репозитории")
    void having_taskInRepo_when_contains_then_returnTrue() {
        OpenQuestionCard question = new OpenQuestionCard(12L, "Вопрос 1", "Ответ 1");
        Mockito.when(questionRepository.findById(12L))
                .thenReturn(Optional.of(question));
        Assertions.assertTrue(questionService.contains(question));
    }

    @Test
    @DisplayName("Проверка существования вопроса возвращает false, если вопроса нет в репозитории")
    void having_noTaskInRepo_when_contains_then_returnFalse() {
        OpenQuestionCard question = new OpenQuestionCard(12L, "Вопрос 1", "Ответ 1");
        Assertions.assertFalse(questionService.contains(question));
    }

    @Test
    @DisplayName("Проверка существования вопроса возвращает false, если вопроса нет в репозитории")
    void having_taskInRepo_when_save_then_repoUpdateIsInvoken() {
        OpenQuestionCard question = new OpenQuestionCard(12L, "Задача 1", "Вопрос 1");
        Mockito.when(questionRepository.findById(12L))
                .thenReturn(Optional.of(question));
        questionService.save(question);
        Mockito.verify(questionRepository).update(Mockito.any());
    }


}
