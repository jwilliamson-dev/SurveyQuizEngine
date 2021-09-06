package main.java;

public class EssayQuestion extends Question {
    private String answerPrompt; 
    public EssayQuestion(String qPrompt, String aPrompt, int nAns) {
        super(qPrompt, nAns);
        this.answerPrompt = aPrompt;
    }

    @Override
    protected boolean validateAnswer(String ans) {
        return true;
    }

    @Override
    public String getAnswerPrompt() {
        return this.answerPrompt;
    }

}
