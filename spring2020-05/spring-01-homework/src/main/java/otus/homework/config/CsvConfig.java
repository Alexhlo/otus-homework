package otus.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CsvConfig {

    @Value("${questions.file.name}")
    private String filename;

    public String getFilename() {
        return filename;
    }
}
