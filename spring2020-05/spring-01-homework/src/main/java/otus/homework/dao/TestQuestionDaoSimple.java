package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.util.List;

import static otus.homework.util.CsvReader.readTestQuestionsFromCsv;

public class TestQuestionDaoSimple implements TestQuestionDao {

    @Override
    public List<TestQuestion> findAllQuestionFromCsvFile(String filename){
        return readTestQuestionsFromCsv(filename);
    }

    @Override
    public String findQuestion(String filename, Integer number) {
        return readTestQuestionsFromCsv(filename).get(number).getQuestion();
    }

    @Override
    public String findAnswerOnQuestion(String filename, int number) {
        return readTestQuestionsFromCsv(filename).get(number).getAnswer();
    }
}
