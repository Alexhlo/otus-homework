package otus.spring.homework01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoSimple;
import otus.homework.model.TestQuestion;
import otus.homework.service.TestQuestionService;
import otus.homework.service.TestQuestionServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class QuestionServiceTesting {

    private final static String CSV_FILENAME = "test-questions.csv";

    private static TestQuestionDao questionDao;
    private static TestQuestionService service;
    private static TestQuestion model;

    @BeforeAll
    static void initBeans() {

        questionDao = new TestQuestionDaoSimple();
        service = new TestQuestionServiceImpl(questionDao);
        model = new TestQuestion();
    }

    @Test
    public void getFirstQuestionByNumberFromCsvFile() {

        String expected = "{questionNumber = 1, question = QuestionOneTest, answer = AnswerOneTest}";

        model = service.getQuestionByNumberFromCsv(CSV_FILENAME, 0);

        assertEquals(expected.trim(), model.toString().trim());
    }
}
