package otus.homework.service;

import otus.homework.dao.TestQuestionDao;
import otus.homework.model.TestQuestion;

import java.util.List;

public class TestQuestionServiceImpl implements TestQuestionService {

    private final TestQuestionDao testQuestionDao;

    public TestQuestionServiceImpl(TestQuestionDao testQuestionDao) {
        this.testQuestionDao = testQuestionDao;
    }

    @Override
    public List<TestQuestion> getAllQuestionsFromCsv() {
        return testQuestionDao.findAllQuestionFromCsvFile();
    }

    @Override
    public String getQuestionByNumber(int number) {
        return testQuestionDao.findQuestionByNumber(number);
    }

    @Override
    public String getAnswerOnQuestionByNumber(int number) {
        return testQuestionDao.findAnswerOnQuestionByNumber(number);
    }
}
