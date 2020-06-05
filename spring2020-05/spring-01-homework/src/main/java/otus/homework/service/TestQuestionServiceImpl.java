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
    public List<TestQuestion> getAllQuestionsFromCsv(String filename) {
        return testQuestionDao.findAllQuestionFromCsvFile(filename);
    }

    @Override
    public String getQuestion(String filename, int number) {
        return testQuestionDao.findQuestion(filename, number);
    }

    @Override
    public String getAnswerOnQuestion(String filename, int number) {
        return testQuestionDao.findAnswerOnQuestion(filename, number);
    }
}
