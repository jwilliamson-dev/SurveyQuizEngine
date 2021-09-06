package main.java;

import java.util.List;

public class MCQuestion extends Question {
    private List<String> answerChoices;

    public MCQuestion(String qPrompt, int nAns, List<String> choices) {
        super(qPrompt, nAns);
        this.answerChoices = (choices.size() > 26) ? answerChoices.subList(0, 26) : choices;
    }

    public boolean addChoice(String choice) {
        if (answerChoices.size() >= 26)
            return false;

        answerChoices.add(choice);
        return true;
    }

    @Override
    protected boolean validateAnswer(String ans) {
        Character answer = ans.charAt(0);
        Character max = Character.valueOf((char) ('a' + this.answerChoices.size()));

        return (Character.compare(answer, 'a') >= 0 && Character.compare(answer, max) < 0);
    }

    @Override
    public String getAnswerPrompt() {
        String out = "Enter the letter from a choice below.\n";
        char cur =  'a';

        for (String choice : answerChoices) {
            out += cur++ + ". " + choice + "\n";
        }
        
        return out.substring(0, out.length()-1);
    }
}
