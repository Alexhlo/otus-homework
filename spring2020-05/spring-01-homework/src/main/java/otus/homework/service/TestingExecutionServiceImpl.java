package otus.homework.service;

public class TestingExecutionServiceImpl implements TestingExecutionService {

    private final InputOutputService inputOutputService;

    public TestingExecutionServiceImpl(InputOutputService inputOutputService) {
        this.inputOutputService = inputOutputService;
    }

    @Override
    public void executeStudentTest() {
        inputOutputService.startConsole();
    }

}
