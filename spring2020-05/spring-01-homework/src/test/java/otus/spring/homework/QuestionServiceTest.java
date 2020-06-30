package otus.spring.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.homework.config.AppConfig;
import otus.homework.model.TestQuestion;
import otus.homework.service.TestQuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource(locations = "classpath:test-application.properties")
public class QuestionServiceTest {

    @Autowired
    private TestQuestionService service;
    private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceTest.class);

    @Test
    void getAllQuestionsFromCsv() {

        List<TestQuestion> questionList = service.getAllQuestions();
        LOG.info(questionList::toString);
    }

    @Test
    void getQuestionTest() {

        String expected = "(1 + 1 * 1 + 1) - 1";
        String question = service.getQuestionByNumber(1);
        LOG.info(() -> question);

        assertEquals(expected, question);
    }

    @Test
    void getAnswerOnQuestionTest() {

        String expected = "2";
        String answer = service.getAnswerOnQuestionByNumber(2);
        LOG.info(() -> answer);

        assertEquals(expected, answer);
    }
}
