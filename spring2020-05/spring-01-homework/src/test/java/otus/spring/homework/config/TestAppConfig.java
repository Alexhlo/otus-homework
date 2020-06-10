package otus.spring.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoCsv;
import otus.homework.service.TestQuestionService;
import otus.homework.service.TestQuestionServiceImpl;
import otus.homework.service.TestingExecutionServiceImpl;

@Configuration
@ComponentScan
public class TestAppConfig {

    @Bean
    TestQuestionDao questionDao(TestCsvConfig csvConfig) {
        return new TestQuestionDaoCsv(csvConfig.getFilename());
    }

    @Bean
    TestingExecutionServiceImpl consoleService(TestQuestionService questionService) {
        return new TestingExecutionServiceImpl(questionService);
    }

    @Bean
    TestQuestionService questionService(TestQuestionDao questionDao) {
        return new TestQuestionServiceImpl(questionDao);
    }
}
