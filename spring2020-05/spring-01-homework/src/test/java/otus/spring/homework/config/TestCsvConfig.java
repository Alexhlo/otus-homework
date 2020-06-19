package otus.spring.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:test-application.properties")
public class TestCsvConfig {

    @Value("${test.questions.file.name}")
    private String filename;

    public String getFilename() {
        return filename;
    }
}
