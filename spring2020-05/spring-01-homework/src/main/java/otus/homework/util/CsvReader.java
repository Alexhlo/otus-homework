package otus.homework.util;

import org.springframework.util.ResourceUtils;
import otus.homework.model.TestQuestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private final static String TABULATION = "\t";

    public static List<TestQuestion> readTestQuestionsFromCsv(String fileName) throws IOException {

        List<TestQuestion> questionList = new ArrayList<>();

        File file = ResourceUtils.getFile("classpath:" + fileName);

        mapCsvToModel(questionList, file);

        return questionList;
    }

    private static void mapCsvToModel(List<TestQuestion> questionList, File file) {

        try (BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String [] data = line.split(TABULATION);

                TestQuestion question = createModel(data);
                questionList.add(question);
                line = br.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static TestQuestion createModel(String[] metadata) {

        Integer number = Integer.parseInt(metadata[0]);
        String question = metadata[1];
        String answer = metadata[2];

        return new TestQuestion(number, question, answer);
    }
}
