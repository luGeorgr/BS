package www.george.com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamWord {
    private String word;
    private List<String> choices = new ArrayList<>(4);

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public List<String> getChoices() {
        return choices;
    }
}
