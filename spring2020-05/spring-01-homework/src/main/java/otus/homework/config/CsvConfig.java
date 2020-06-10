package otus.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class CsvConfig {

    @Value("${questions.file.name}")
    private String filename;

    public String getFilename() {
        return filename;
    }
}
