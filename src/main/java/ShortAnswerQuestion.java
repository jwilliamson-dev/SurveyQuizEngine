package main.java;

public class ShortAnswerQuestion extends EssayQuestion {
    private int maxLength;

    public ShortAnswerQuestion(String qPrompt, String aPrompt, int nAns, int len) {
        super(qPrompt, aPrompt, nAns);
        this.maxLength = len;
    }

    @Override
    protected boolean validateAnswer(String ans) {
        return ans.length() <= this.maxLength;
    }

}
