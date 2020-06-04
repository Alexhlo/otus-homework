package otus.homework.service;

import otus.homework.model.TestQuestion;

import java.util.List;

public interface TestQuestionService {

    List<TestQuestion> getAllQuestionsFromCsv(String filename);

    TestQuestion getQuestionByNumberFromCsv(String filename, int number);
}
