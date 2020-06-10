package otus.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestQuestion {

    private int questionNumber;
    private String question;
    private String answer;

    @Override
    public String toString() {
        return "\nquestionNumber = " + questionNumber +
                ", question = " + question +
                ", answer = " + answer + ";";
    }
}
