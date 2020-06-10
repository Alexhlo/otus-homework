package otus.spring.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test-application.properties")
public class TestCsvConfig {

    @Value("${test.questions.file.name}")
    private String filename;

    public String getFilename() {
        return filename;
    }
}
