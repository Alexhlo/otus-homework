package otus.homework.service;

import otus.homework.model.ResultDto;
import otus.homework.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestingExecutionServiceImpl implements TestingExecutionService {

    private static final String NEXT_QUESTION = "/next";
    private static final String END = "/end";

    private final TestQuestionService questionService;

    public TestingExecutionServiceImpl(TestQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void executeStudentTest() {
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
                            nextQuestionConsoleCase(student, resultDTO, questionCount, points);
                            answer = scanner.nextLine();
                            if (answer.equals(questionService.getAnswerOnQuestionByNumber(questionCount))) {
                                ++points;
                            }
                            ++questionCount;
                            break;
                        case END:
                            endConsoleCase(student, resultDTO);
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

    private void nextQuestionConsoleCase(Student student, ResultDto resultDTO, int questionCount, int points) {

        long questionListSize = questionService.getAllQuestionsFromCsv().size();
        if (questionCount != questionListSize) {
            System.out.println(String.format("Next question %s: %s", questionCount, questionService.getQuestionByNumber(questionCount)));
        } else {
            endConsoleCase(student, resultDTO);
            pointScale(points);
        }
    }

    private void endConsoleCase(Student student, ResultDto resultDTO) {

        System.out.println("Testing is over, your result:");
        resultDTO.setStudent(student);
        resultDTO.setListTestQuestion(questionService.getAllQuestionsFromCsv());
        System.out.println(resultDTO.toString().replace("[", "").replace("]", ""));
    }

}
