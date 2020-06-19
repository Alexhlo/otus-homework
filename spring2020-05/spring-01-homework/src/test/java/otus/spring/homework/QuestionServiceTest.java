package otus.spring.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.homework.model.TestQuestion;
import otus.homework.service.TestQuestionService;
import otus.spring.homework.config.TestAppConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ComponentScan
@ContextConfiguration(classes = TestAppConfig.class)
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

        assertEquals(expected, question);
    }

    @Test
    void getAnswerOnQuestionTest() {

        String expected = "2";
        String answer = service.getAnswerOnQuestionByNumber(2);

        assertEquals(expected, answer);
    }
}
