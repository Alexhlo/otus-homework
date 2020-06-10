package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.util.List;

import static otus.homework.util.CsvReader.readTestQuestionsFromCsv;

public class TestQuestionDaoCsv implements TestQuestionDao {

    private final String filename;

    public TestQuestionDaoCsv(String filename) {
        this.filename = filename;
    }

    @Override
    public List<TestQuestion> findAllQuestionFromCsvFile(){
        return readTestQuestionsFromCsv(filename);
    }

    @Override
    public String findQuestionByNumber(int number) {
        return readTestQuestionsFromCsv(filename).get(number).getQuestion();
    }

    @Override
    public String findAnswerOnQuestionByNumber(int number) {
        return readTestQuestionsFromCsv(filename).get(number).getAnswer();
    }
}