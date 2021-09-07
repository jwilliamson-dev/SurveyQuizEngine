package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test extends Survey {
    private List<String> answerKey; 

    public Test() {
        super();

        this.answerKey = new ArrayList<String>();
    }

    public void setAnswerKey(List<String> a) {
        this.answerKey = a;
    }

    public List<String> getAnswerKey() {
        return this.answerKey;
    }

    public HashMap<String, Integer> getGradeReport() {
        HashMap<String, Integer> out = new HashMap<String, Integer>();
        out.put("Correct", 0);
        out.put("Incorrect", 0);
        out.put("Needs manual grading", 0);

        if (this.answerKey.size() == 0) return out;

        for (int i = 0; i < this.getQuestions().size(); i++) {
            Question q = this.getQuestion(i);
            if (q instanceof ShortAnswerQuestion || q instanceof EssayQuestion) {
                out.put("Needs manual grading", out.get("Needs manual grading") + 1);
            } else if (q.getAnswer(0).compareTo(this.answerKey.get(i)) == 0) {
                out.put("Correct", out.get("Correct") + 1);
            } else {
                out.put("Incorrect", out.get("Incorrect") + 1);
            }
        }

        return out;
    }
}
