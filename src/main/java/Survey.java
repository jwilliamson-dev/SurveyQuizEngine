package main.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Survey implements Serializable {
    private List<Question> questions;

    public Survey() {
        this.questions = new ArrayList<Question>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(int ind) {
        if (ind > this.questions.size() - 1)
            return null;

        return this.questions.get(ind);
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void removeQuestion(Question q) {
        questions.remove(q);
    }

    public void removeQuestion(int ind) {
        questions.remove(ind);
    }

    public void modifyQuestion(int ind, Question q) {
        questions.set(ind, q);
    }
}
