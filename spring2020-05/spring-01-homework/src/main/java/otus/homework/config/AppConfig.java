package otus.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoCsv;
import otus.homework.service.*;

@Configuration
public class AppConfig {

    @Bean
    TestQuestionDao questionDao(CsvConfig csvConfig) {
        return new TestQuestionDaoCsv(csvConfig.getFilename());
    }

    @Bean
    TestingExecutionServiceImpl testingExecutionService(InputOutputService inputOutputService) {
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
