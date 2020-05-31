package otus.homework.model;

public class TestQuestion {

    private Integer questionNumber;
    private String question;
    private String answer;

    public TestQuestion(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public TestQuestion(Integer questionNumber, String question, String answer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answer = answer;
    }

    public TestQuestion() {

    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "\n{" +
                "questionNumber = " + questionNumber +
                ", question = " + question +
                ", answer = " + answer +
                "}";
    }
}
