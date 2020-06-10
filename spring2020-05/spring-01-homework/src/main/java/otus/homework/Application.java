package otus.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import otus.homework.service.TestingExecutionService;

@ComponentScan
@Configuration
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        TestingExecutionService testingExecutionService = context.getBean(TestingExecutionService.class);

        testingExecutionService.executeStudentTest();
    }

}
