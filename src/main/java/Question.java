package main.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class Question implements Serializable {
    static final long serialVersionUID = 1L;
    private String questionPrompt;
    private int numAnswers;
    protected List<String> answers;

    public Question(String qPrompt, int nAns) {
        this.questionPrompt = qPrompt;
        this.numAnswers = nAns;
        this.answers = new ArrayList<String>();
    }

    public String getQuestionPrompt() {
        return this.questionPrompt;
    }
    
    public int getNumAnswers() {
        return this.numAnswers;
    }
    
    public List<String> getAnswers() {
        return this.answers;
    }
    
    public void setQuestionPrompt(String prompt) {
        this.questionPrompt = prompt;
    }
    
    public void setNumAnswers(int num) {
        this.numAnswers = num;
    }
    
    public boolean addAnswer(String ans) {
        if (this.answers.size() < this.numAnswers && this.validateAnswer(ans)) {
            this.answers.add(ans);
            return true;
        } else {
            return false;
        }
    }
    
    public void removeAnswer(int ind) {
        answers.remove(ind);
    }
    
    public void removeAnswer(String res) {
        answers.remove(res);
    }
    
    public String getAnswer(int ind) {
        return answers.get(ind);
    }

    public void clearAnswers() {
        this.answers = new ArrayList<String>();
    }
    
    abstract protected boolean validateAnswer(String ans);
    abstract public String getAnswerPrompt(); 
}
