package otus.homework.service;

import otus.homework.model.TestQuestion;

import java.io.IOException;
import java.util.List;

public interface TestQuestionService {

    List<TestQuestion> getAllQuestionsFromCsv(String filename) throws IOException;

    TestQuestion getQuestionByNumberFromCsv(String filename ,Integer number) throws IOException;
}
