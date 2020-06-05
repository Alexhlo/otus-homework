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

    public TestQuestion(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public TestQuestion(int questionNumber, String question) {
        this.questionNumber = questionNumber;
        this.question = question;
    }

    @Override
    public String toString() {
        return "\nquestionNumber = " + questionNumber +
                ", question = " + question +
                ", answer = " + answer + ";";
    }
}
