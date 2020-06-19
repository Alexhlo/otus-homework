package otus.homework.service;

import otus.homework.model.ResultDto;
import otus.homework.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutputServiceImpl implements InputOutputService {

    private static final String NEXT_QUESTION = "/next";
    private static final String END = "/end";

    private final TestQuestionService questionService;

    public InputOutputServiceImpl(TestQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void startConsole() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        ResultDto resultDTO = new ResultDto();

        try {
            int questionCount = 0;
            int points = 0;
            String userAnswer;

            greetingConsoleCase(scanner, student);

            while (true) {
                try {
                    switch (scanner.nextLine().trim()) {
                        case NEXT_QUESTION:
                            inputNextQuestionConsoleCase(student, resultDTO, questionCount, points, scanner);
                            userAnswer = scanner.nextLine();
                            if (userAnswer.trim().equals(questionService.getAnswerOnQuestionByNumber(questionCount))) {
                                ++points;
                            }
                            ++questionCount;
                            break;
                        case END:
                            outputEndConsoleCase(student, resultDTO);
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
            }
        } catch (IllegalStateException ex) {
            System.out.println("Exit. Scanner was closed");
        }
    }

    private void greetingConsoleCase(Scanner scanner, Student student) {
        System.out.println("Enter your first name and last name:\n");
        student.setFirstName(scanner.next());
        student.setLastName(scanner.nextLine());

        System.out.println("Enter the command. Example : /next, /end.\n");
        System.out.println("Start testing!\n");
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

    private void inputNextQuestionConsoleCase(Student student, ResultDto resultDTO, int questionNumber, int points, Scanner scanner) {

        long questionListSize = questionService.getAllQuestions().size();
        if (questionNumber != questionListSize) {
            System.out.println(String.format("Next question %s: %s", questionNumber, questionService.getQuestionByNumber(questionNumber)));
        } else {
            outputEndConsoleCase(student, resultDTO);
            pointScale(points);
            scanner.close();
        }
    }

    private void outputEndConsoleCase(Student student, ResultDto resultDTO) {

        System.out.println("Testing is over, your result:");
        resultDTO.setStudent(student);
        resultDTO.setListTestQuestion(questionService.getAllQuestions());
        System.out.println(resultDTO.toString().replace("[", "").replace("]", ""));
    }
}
