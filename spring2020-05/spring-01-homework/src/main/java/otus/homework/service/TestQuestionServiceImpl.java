package otus.homework.service;


import otus.homework.dao.TestQuestionDao;
import otus.homework.model.TestQuestion;

import java.io.IOException;
import java.util.List;

public class TestQuestionServiceImpl implements TestQuestionService {

    private final TestQuestionDao testQuestionDao;

    public TestQuestionServiceImpl(TestQuestionDao testQuestionDao) {
        this.testQuestionDao = testQuestionDao;
    }

    @Override
    public List<TestQuestion> getAllQuestionsFromCsv(String filename) throws IOException {
        return testQuestionDao.findAllQuestionFromCsvFile(filename);
    }

    @Override
    public TestQuestion getQuestionByNumberFromCsv(String filename ,Integer number) throws IOException {
        return testQuestionDao.findQuestionByNumberFromCsvFile(filename ,number);
    }
}
