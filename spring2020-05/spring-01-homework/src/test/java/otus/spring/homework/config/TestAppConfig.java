package otus.spring.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoSimple;
import otus.homework.service.ConsoleServiceImpl;
import otus.homework.service.TestQuestionService;
import otus.homework.service.TestQuestionServiceImpl;

@Configuration
public class TestAppConfig {

    @Bean
    TestQuestionDao questionDao() {
        return new TestQuestionDaoSimple();
    }

    @Bean
    ConsoleServiceImpl consoleService(TestQuestionService questionService) {
        return new ConsoleServiceImpl(questionService);
    }

    @Bean
    TestQuestionService questionService(TestQuestionDao questionDao) {
        return new TestQuestionServiceImpl(questionDao);
    }
}
