package otus.homework.service;

import otus.homework.model.TestQuestion;

import java.util.List;

public interface TestQuestionService {

    List<TestQuestion> getAllQuestionsFromCsv(String filename);

    String getQuestion(String filename, int number);

    String getAnswerOnQuestion(String filename, int number);
}
