//package ru.burdukov.web.api.controller;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import ru.burdukov.domain.model.OpenQuestionCard;
//import ru.burdukov.domain.repo.QuestionRepository;
//import ru.burdukov.web.api.dto.OpenQuestionCardDto;
//
//import java.util.List;
//
//@SpringBootTest
//class QuestionRestControllerTest {
//    @MockitoBean
//    private QuestionRepository questionRepository;
//
//    @Autowired
//    private QuestionRestController controller;
//
//    @Test
//    @DisplayName("Создание Question с корректными id, question и expectedAnswer проходит успешно")
//    void having_task_when_list_then_return() {
//        Mockito.when(questionRepository.findAll())
//                .thenReturn(List.of(new OpenQuestionCard(12345L, "Вопрос", "Ответ")));
//        List<OpenQuestionCardDto> list = controller.list();
//        Assertions.assertEquals(1, list.size());
//    }
//}