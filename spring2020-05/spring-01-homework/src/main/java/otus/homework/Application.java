package otus.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import otus.homework.service.ConsoleService;
import otus.homework.service.TestQuestionService;

@ComponentScan
@Configuration
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        ConsoleService consoleService = context.getBean(ConsoleService.class);
        TestQuestionService questionService = context.getBean(TestQuestionService.class);

        consoleService.startConsole(questionService);
    }

}
