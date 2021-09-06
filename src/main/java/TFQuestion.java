package main.java;

import java.util.List;

public class TFQuestion extends MCQuestion {
    public TFQuestion(String qPrompt) {
        super(qPrompt, 1, List.of("True", "False")); 
    }

    // Possibly do a different validate function
}
