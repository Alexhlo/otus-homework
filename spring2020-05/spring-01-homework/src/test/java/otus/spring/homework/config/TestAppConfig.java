package otus.spring.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoCsv;
import otus.homework.service.*;

@Configuration
@ComponentScan
public class TestAppConfig {

    @Bean
    TestQuestionDao questionDao(TestCsvConfig csvConfig) {
        return new TestQuestionDaoCsv(csvConfig.getFilename());
    }

    @Bean
    TestingExecutionService testingExecutionService(InputOutputService inputOutputService) {
        return new TestingExecutionServiceImpl(inputOutputService);
    }

    @Bean
    TestQuestionService questionService(TestQuestionDao questionDao) {
        return new TestQuestionServiceImpl(questionDao);
    }

    @Bean
    InputOutputService inputOutputService(TestQuestionService questionService){
        return new InputOutputServiceImpl(questionService);
    }
}
