package otus.homework.service;

import otus.homework.model.ConsoleCommands;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {

    private final static String CSV_FILENAME = "test-questions.csv";

    private final TestQuestionService questionService;

    public ConsoleServiceImpl(TestQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void startConsole(TestQuestionService service) {

        Scanner scanner = new Scanner(System.in);
        int questionCount = 0;

        System.out.println("Enter the command. Example : /start, /next, /q.");

        try {
            do {
                try {
                    switch (scanner.nextLine().trim()) {
                        case ConsoleCommands.START:
                            System.out.println("Question 1:");
                            System.out.println(service.getQuestionByNumberFromCsv(CSV_FILENAME, questionCount));
                            break;
                        case ConsoleCommands.NEXT_QUESTION:
                            System.out.println("Next question:");
                            System.out.println(service.getQuestionByNumberFromCsv(CSV_FILENAME, ++questionCount));
                            break;
                        case ConsoleCommands.QUIT:
                            scanner.close();
                            break;
                        default:
                            System.out.println("Wrong command");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error");
                    scanner.next();
                }
            } while (true);
        }catch (IllegalStateException ex) {
            System.out.println("Exit. Scanner was closed");
        }
    }

}
