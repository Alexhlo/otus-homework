package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.io.IOException;
import java.util.List;

public interface TestQuestionDao {

    TestQuestion findQuestionByNumberFromCsvFile(String filename, Integer number) throws IOException;

    List<TestQuestion> findAllQuestionFromCsvFile(String fileName) throws IOException;
}
