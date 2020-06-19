package otus.homework.dao;

import otus.homework.model.TestQuestion;

import java.util.List;

public interface TestQuestionDao {

    List<TestQuestion> findAllQuestion();

    String findQuestionByNumber(int number);

    String findAnswerOnQuestionByNumber(int number);
}
