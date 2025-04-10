package ru.burdukov.console;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.burdukov.console.controller.ProjectController;


@ComponentScan(basePackages = "ru.burdukov")
@SpringBootApplication
public class App  implements CommandLineRunner {
    @Autowired
    private ProjectController controller;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.interactWithUser();
    }
}
