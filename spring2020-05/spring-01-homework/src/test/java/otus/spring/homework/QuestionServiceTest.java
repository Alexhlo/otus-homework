package otus.spring.homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoSimple;
import otus.homework.model.TestQuestion;
import otus.homework.service.TestQuestionService;
import otus.homework.service.TestQuestionServiceImpl;
import otus.spring.homework.config.TestAppConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ComponentScan
@ContextConfiguration(classes = TestAppConfig.class)
public class QuestionServiceTest {

    private final static String CSV_FILENAME = "test-questions.csv";

    @Autowired
    private static AnnotationConfigApplicationContext context;
    private static TestQuestionService service;
    private static TestQuestion model;
    private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceTest.class);

    @BeforeAll
    static void initBeans() {

        TestQuestionDao questionDao = new TestQuestionDaoSimple();
        context = new AnnotationConfigApplicationContext(QuestionServiceTest.class);
        service = new TestQuestionServiceImpl(questionDao);
        model = new TestQuestion();
    }

    @Test
    void getFirstQuestionByNumberFromCsvFile() {

        List<TestQuestion> questionList = service.getAllQuestionsFromCsv(CSV_FILENAME);

        LOG.info(questionList::toString);
    }

    @Test
    void getQuestionTest() {

        String expected = "(1 + 1 * 1 + 1) - 1";
        String question = service.getQuestion(CSV_FILENAME, 1);

        assertEquals(expected, question);
    }

    @Test
    void getAnswerOnQuestionTest() {

        String expected = "2";
        String answer = service.getAnswerOnQuestion(CSV_FILENAME, 2);

        assertEquals(expected, answer);
    }
}
