package otus.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import otus.homework.model.ConsoleCommands;
import otus.homework.service.TestQuestionService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application implements ConsoleCommands {

    private final static String CSV_FILENAME = "test-questions.csv";

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestQuestionService service = context.getBean(TestQuestionService.class);

        System.out.println(service.getAllQuestionsFromCsv(CSV_FILENAME));

        console(service);
    }

    private static void console(TestQuestionService service) {

        Scanner scanner = new Scanner(System.in);
        int questionCount = 0;

        System.out.println("Enter the command. Example : /start, /next, /q.");

        try {
            do {
                try {
                    switch (scanner.nextLine().trim()) {
                        case start:
                            System.out.println("Question 1:");
                            System.out.println(service.getQuestionByNumberFromCsv(CSV_FILENAME, questionCount));
                            break;
                        case nextQuestion:
                            System.out.println("Next question:");
                            System.out.println(service.getQuestionByNumberFromCsv(CSV_FILENAME, ++questionCount));
                            break;
                        case quit:
                            scanner.close();
                            break;
                        default:
                            System.out.println("Wrong command");
                    }
                } catch (InputMismatchException | IOException e) {
                    System.out.println("Error");
                    scanner.next();
                }
            } while (true);
        }catch (IllegalStateException ex) {
            System.out.println("Exit. Scanner was closed");
        }
    }
}
