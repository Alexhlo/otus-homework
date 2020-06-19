package otus.homework.service;

import otus.homework.model.TestQuestion;

import java.util.List;

public interface TestQuestionService {

    List<TestQuestion> getAllQuestions();

    String getQuestionByNumber(int number);

    String getAnswerOnQuestionByNumber(int number);
}
