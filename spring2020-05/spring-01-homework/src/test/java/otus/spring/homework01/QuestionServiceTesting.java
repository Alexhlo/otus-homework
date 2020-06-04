package otus.spring.homework01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.homework.model.TestQuestion;
import otus.homework.service.TestQuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class QuestionServiceTesting {

    private final static String CSV_FILENAME = "test-questions.csv";

    private static ApplicationContext context;
    private static TestQuestionService service;
    private static TestQuestion model;

    @BeforeAll
    static void initBeans() {

        context = new ClassPathXmlApplicationContext("/spring-context.xml");
        service = context.getBean(TestQuestionService.class);
        model = new TestQuestion();
    }

    @Test
    public void getFirstQuestionByNumberFromCsvFile() {

        String expected = "{questionNumber = 1, question = QuestionOneTest, answer = AnswerOneTest}";

        model = service.getQuestionByNumberFromCsv(CSV_FILENAME, 0);

        assertEquals(expected.trim(), model.toString().trim());
    }
}
