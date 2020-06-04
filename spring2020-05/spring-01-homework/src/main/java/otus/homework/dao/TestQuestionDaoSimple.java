package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.util.List;

import static otus.homework.util.CsvReader.readTestQuestionsFromCsv;

public class TestQuestionDaoSimple implements TestQuestionDao {

    @Override
    public TestQuestion findQuestionByNumberFromCsvFile(String filename, Integer number) {
        return readTestQuestionsFromCsv(filename).get(number);
    }

    @Override
    public List<TestQuestion> findAllQuestionFromCsvFile(String filename){
        return readTestQuestionsFromCsv(filename);
    }
}
