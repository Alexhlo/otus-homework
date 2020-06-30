package otus.homework.service;

import otus.homework.model.ResultDto;
import otus.homework.model.Student;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class TestingExecutionServiceImpl implements TestingExecutionService {

    private static final String COMMAND_NEXT_QUESTION = "/n";
    private static final String COMMAND_TESTING_END = "/end";
    private static final String MESSAGE_ENTER_COMMAND = "Enter command: ";
    private static final String MESSAGE_WRONG_COMMAND = "Wrong command! Try again.";
    private static final String MESSAGE_ERROR = "Error";
    private static final String MESSAGE_EXIT = "Exit";

    private final TestQuestionService questionService;
    private final IOService ioService;

    public TestingExecutionServiceImpl(TestQuestionService questionService, IOService ioService) {
        this.questionService = questionService;
        this.ioService = ioService;
    }

    @Override
    public void executeStudentTest() {

        Student student = new Student();
        ResultDto resultDTO = new ResultDto();
        String userAnswer;

        try {
            int questionCount = 0;
            int points = 0;

            greetingConsoleCase(student);

            while (true) {
                try {
                    ioService.print(MESSAGE_ENTER_COMMAND);
                    switch (ioService.readNextLine()) {
                        case COMMAND_NEXT_QUESTION:
                            inputNextQuestionConsoleCase(student, resultDTO, questionCount, points);
                            userAnswer = ioService.readNextLine();
                            if (userAnswer.trim().equals(questionService.getAnswerOnQuestionByNumber(questionCount))) {
                                ++points;
                            }
                            ++questionCount;
                            break;
                        case COMMAND_TESTING_END:
                            outputEndConsoleCase(student, resultDTO);
                            pointScale(points);
                            ioService.closeInputStream();
                            break;
                        default:
                            ioService.println(MESSAGE_WRONG_COMMAND);
                    }
                } catch (InputMismatchException e) {
                    ioService.println(MESSAGE_ERROR);
                }
            }
        } catch (IllegalStateException | NoSuchElementException ex) {
            ioService.println(MESSAGE_EXIT);
        }
    }

    private void greetingConsoleCase(Student student) {

        ioService.print("Enter your first name: ");
        student.setFirstName(ioService.readNextLine());
        ioService.print("Enter your last name: ");
        student.setLastName(ioService.readNextLine());

        ioService.println("Enter the command. Example : /n, /end.");
        ioService.println(String.format("Student: %s %s - test starting!", student.getFirstName(), student.getLastName()));
    }

    private void pointScale(int points) {

        switch (points) {
            case 1:
                ioService.println("You got 1 point");
                break;
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                ioService.println("You got " + points + " points.");
                break;
        }
    }

    private void inputNextQuestionConsoleCase(Student student, ResultDto resultDTO, int questionNumber, int points) {

        long questionListSize = questionService.getAllQuestions().size();
        if (questionNumber != questionListSize) {
            System.out.println(String.format("Next question %s: %s", questionNumber, questionService.getQuestionByNumber(questionNumber)));
            ioService.print("Your answer: ");
        } else {
            outputEndConsoleCase(student, resultDTO);
            pointScale(points);
            ioService.closeInputStream();
        }
    }

    private void outputEndConsoleCase(Student student, ResultDto resultDTO) {

        ioService.println("Testing is over, your result:");
        resultDTO.setStudent(student);
        resultDTO.setListTestQuestion(questionService.getAllQuestions());
        ioService.println(resultDTO.toString().replace("[", "").replace("]", ""));
    }

}
