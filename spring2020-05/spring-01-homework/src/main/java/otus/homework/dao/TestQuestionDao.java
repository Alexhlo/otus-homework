package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.util.List;

public interface TestQuestionDao {

    List<TestQuestion> findAllQuestionFromCsvFile(String fileName);

    String findQuestion(String filename, Integer number);

    String findAnswerOnQuestion(String filename, int number);
}
