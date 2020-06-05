package otus.homework.service;

import otus.homework.model.ResultDto;
import otus.homework.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {

    private final static String CSV_FILENAME = "questions.csv";
    private static final String NEXT_QUESTION = "/next";
    private static final String END = "/end";

    private final TestQuestionService questionService;

    public ConsoleServiceImpl(TestQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void startConsole(TestQuestionService service) {

        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        ResultDto resultDTO = new ResultDto();

        try {
            int questionCount = 0;
            int points = 0;
            String answer;
            System.out.println("Enter your first name and last name:\n");
            student.setFirstName(scanner.next());
            student.setLastName(scanner.nextLine());

            System.out.println("Enter the command. Example : /next, /end.\n");
            System.out.println("Start testing!\n");
            do {
                try {
                    switch (scanner.nextLine().trim()) {
                        case NEXT_QUESTION:
                            nextQuestionConsoleCase(service, student, resultDTO, questionCount, points);
                            answer = scanner.nextLine();
                            if (answer.equals(service.getAnswerOnQuestion(CSV_FILENAME, questionCount))) {
                                ++points;
                            }
                            ++questionCount;
                            break;
                        case END:
                            endConsoleCase(service, student, resultDTO);
                            pointScale(points);
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
        } catch (IllegalStateException ex) {
            System.out.println("Exit. Scanner was closed");
        }
    }

    private void pointScale(int points) {
        switch (points) {
            case 1:
                System.out.println("You got 1 point");
                break;
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("You got " + points + " points.");
                break;
        }
    }

    private void nextQuestionConsoleCase(TestQuestionService service, Student student, ResultDto resultDTO, int questionCount, int points) {

        long questionListSize = service.getAllQuestionsFromCsv(CSV_FILENAME).size();
        if (questionCount != questionListSize) {
            System.out.println(String.format("Next question %s: %s", questionCount, service.getQuestion(CSV_FILENAME, questionCount)));
        } else {
            endConsoleCase(service, student, resultDTO);
            pointScale(points);
        }
    }

    private void endConsoleCase(TestQuestionService service, Student student, ResultDto resultDTO) {

        System.out.println("Testing is over, your result:");
        resultDTO.setStudent(student);
        resultDTO.setListTestQuestion(service.getAllQuestionsFromCsv(CSV_FILENAME));
        System.out.println(resultDTO.toString().replace("[", "").replace("]", ""));
    }

}
