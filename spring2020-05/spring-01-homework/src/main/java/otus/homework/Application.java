package otus.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import otus.homework.service.ConsoleService;
import otus.homework.service.TestQuestionService;

public class Application {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestQuestionService questionService = context.getBean(TestQuestionService.class);
        ConsoleService consoleService = context.getBean(ConsoleService.class);

        consoleService.startConsole(questionService);
    }

}
