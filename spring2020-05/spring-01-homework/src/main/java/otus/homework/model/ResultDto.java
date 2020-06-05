package otus.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    private Student student;
    private List<TestQuestion> listTestQuestion;

    @Override
    public String toString() {
        return "Student: " + student +
                ";\nList test question: " + listTestQuestion;
    }
}
