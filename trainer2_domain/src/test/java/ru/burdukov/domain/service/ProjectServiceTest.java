package ru.burdukov.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.burdukov.domain.model.Project;
import ru.burdukov.domain.repo.ProjectRepository;
import java.util.List;
import java.util.Optional;

class ProjectServiceTest {

    private ProjectService service;
    private ProjectRepository repository;
    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ProjectRepository.class);
        service = new ProjectService(repository);
    }

    @Test
    @DisplayName("Получение существующего вопроса по id")
    void having_questionInRepo_when_getById_then_returnQuestion() {
        Mockito.when(repository.findById(12L))
                .thenReturn(Optional.of(new Project(12L, "Вопрос 1", "Ответ 1")));
        Optional<Project> projects = service.getById(12L);
        Assertions.assertTrue(projects.isPresent());
    }

    @Test
    @DisplayName("При сохранении нововй задачи, вызывается метод add у репозитория")
    void having_noQuestionInRepo_when_save_then_repoAddIsInvoken() {
        Project project = new Project(12L, "Вопрос 1", "Ответ 1");
        service.save(project);
        Mockito.verify(repository).add(Mockito.any());
    }

    @Test
    @DisplayName("При попытке получить вопросы, когда репозиторий пуст, получаем пустой список")
    void having_noQuestionInRepo_when_getAll_then_returnEmpty() {
        List<Project> project = service.getAll();
        Assertions.assertTrue(project.isEmpty());
    }

    @Test
    @DisplayName("При попытке получить несуществующий вопрос по id, получаем Optional.empty")
    void having_noQuestionInRepo_when_getById_then_returnEmpty() {
        Optional<Project> project = service.getById(12L);
        Assertions.assertFalse(project.isPresent());
    }

    @Test
    @DisplayName("При попытке получить вопрос по коду null, получаем Optional.empty")
    void having_nullId_when_getById_then_returnEmpty() {
        Optional<Project> project = service.getById(null);
        Assertions.assertFalse(project.isPresent());
    }

    @Test
    @DisplayName("Проверка существования вопроса успешна, если вопрос есть в репозитории")
    void having_questionInRepo_when_contains_then_returnTrue() {
        Project project = new Project(12L, "Вопрос 1", "Ответ 1");
        Mockito.when(repository.findById(12L))
                .thenReturn(Optional.of(project));
        Assertions.assertTrue(service.contains(project));
    }

    @Test
    @DisplayName("Проверка существования вопроса возвращает false, если вопроса нет в репозитории")
    void having_noQuestionInRepo_when_contains_then_returnFalse() {
        Project project = new Project(12L, "Вопрос 1", "Ответ 1");
        Assertions.assertFalse(service.contains(project));
    }

    @Test
    @DisplayName("Проверка существования вопроса возвращает false, если вопроса нет в репозитории")
    void having_questionInRepo_when_save_then_repoUpdateIsInvoken() {
        Project project = new Project(12L, "Задача 1", "Вопрос 1");
        Mockito.when(repository.findById(12L))
                .thenReturn(Optional.of(project));
        service.save(project);
        Mockito.verify(repository).update(Mockito.any());
    }

}