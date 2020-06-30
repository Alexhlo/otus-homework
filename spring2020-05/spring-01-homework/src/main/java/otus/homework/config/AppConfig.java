package otus.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import otus.homework.dao.TestQuestionDao;
import otus.homework.dao.TestQuestionDaoCsv;
import otus.homework.service.*;

@Configuration
public class AppConfig {

    @Value("${questions.file.name}")
    private String filename;

    @Bean
    public TestQuestionDao questionDao() {
        return new TestQuestionDaoCsv(filename);
    }

    @Bean
    public TestingExecutionServiceImpl testingExecutionService(TestQuestionService testQuestionService, IOService ioService) {
        return new TestingExecutionServiceImpl(testQuestionService, ioService);
    }

    @Bean
    public IOService ioService() {
        return new ConsoleIOServiceImpl();
    }

    @Bean
    public TestQuestionService questionService(TestQuestionDao questionDao) {
        return new TestQuestionServiceImpl(questionDao);
    }

}
