package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.util.List;

public interface TestQuestionDao {

    TestQuestion findQuestionByNumberFromCsvFile(String filename, Integer number);

    List<TestQuestion> findAllQuestionFromCsvFile(String fileName);
}
