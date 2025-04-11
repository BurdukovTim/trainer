package ru.burdukov.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.burdukov.console.config.SpringConfig;
import ru.burdukov.console.controller.ConsoleController;
import ru.burdukov.domain.model.OpenQuestionCard;
import ru.burdukov.domain.repo.QuestionRepository;
import ru.burdukov.domain.service.QuestionService;



public class App
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConsoleController controller = context.getBean(ConsoleController.class);
        controller.interactWithUser();
    }
}
