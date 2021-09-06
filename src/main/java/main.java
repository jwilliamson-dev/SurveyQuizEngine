package main.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class SurveyQuizEngine {
    public static Survey loadedSurvey;

    public static void main(String[] args) {
        int command;
        Output.println("Welcome to the SurveyTestDriver Application!");
        while (true) {
            Output.println("-------- Main Menu --------");
            Output.println("1. Create a Survey\n" + "2. Create a Test\n" + "3. Load a Survey\n" + "4. Load a Test\n"
                    + "5. Exit");

            command = Input.getInt("Enter a number: ");

            switch (command) {
                case 1:
                    loadedSurvey = new Survey();
                    handleSurvey();
                    break;
                case 2:
                    // loadedSurvey = new Test();
                    handleTest();
                    break;
                case 3:
                    loadedSurvey = loadSurvey();
                    handleSurvey();
                    break;
                case 4:
                    // loadedSurvey = loadTest();
                    handleTest();
                    break;
                case 5:
                    Output.println("Exiting now.");
                    return;
                default:
                    Output.println("Unrecognized Command.");
            }
        }
        
    }

    public static void handleSurvey() {
        int command;

        while (true) {
            Output.println("-------- Survey Menu --------");
            Output.println(
                    "1. Take Survey\n2. Display Survey\n3. Edit Survey\n4. Save Survey\n5. Export Survey\n6. Exit");

            command = Input.getInt("Enter a number: ");

            switch (command) {
                case 1:
                    takeSurvey();
                    break;
                case 2:
                    displaySurvey();
                    break;
                case 3:
                    editSurvey();
                    break;
                case 4:
                    saveSurvey();
                    break;
                case 5:
                    exportSurvey();
                    break;
                case 6:
                    Output.println("Exiting survey.");
                    return;
                default:
                    Output.println("Unrecognized Command.");
                    break;
            }
        }
    }

    public static void handleTest() {
        int command;

        while (true) {
            Output.println("-------- Test Menu --------");
            Output.println(
                    "1. Take Test\n2. Display Test\n3. Edit Test\n4. Save Test\n5. Grade Test\n6. Export Test\n7. Exit");

            command = Input.getInt("Enter a number: ");

            switch (command) {
                case 1:
                    takeSurvey();
                    break;
                case 2:
                    displaySurvey();
                    break;
                case 3:
                    editTest();
                    break;
                case 4:
                    saveSurvey();
                    break;
                case 5:
                    gradeTest();
                    break;
                case 6:
                    exportSurvey();
                    break;
                case 7:
                    Output.println("Exiting survey.");
                    return;
                default:
                    Output.println("Unrecognized Command.");
                    break;
            }
        }
    }

    public static Survey loadSurvey() {
        FileInputStream fis;
        ObjectInputStream ois;
        Survey s = null;
        String fname = Input.getString("-------- Load Survey --------\nEnter the name of the file to load: ");

        try {
            fis = new FileInputStream(fname);
            ois = new ObjectInputStream(fis);
            s = (Survey) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            Output.println("File Error, please try again.");
        } catch (ClassNotFoundException e) {
            Output.println("Class not found. Please try a different file.");
        }

        return s;
    }

    public static void takeSurvey() {
        for (Question q : loadedSurvey.getQuestions()) {
            Output.println("-------- Take Survey --------");
            Output.println(q.getQuestionPrompt());
            Output.println(q.getAnswerPrompt());

            for (int i = 1; i <= q.getNumAnswers(); i++) {
                String ans;
                q.clearAnswers();
                do {
                    ans = Input.getString("Enter your answer: ");

                    if (ans.compareTo("") == 0) {
                        i = q.getNumAnswers() + 1;
                        break;
                    }
                } while (!q.addAnswer(ans));
            }
        }
    }

    public static void editSurvey() {
        int command;

        while (true) {
            Output.println("-------- Edit Survey --------");
            Output.println("1. Add Question\n2. Edit Question\n3. Remove Question\n4. Exit");

            command = Input.getInt("Enter a number: ");

            switch (command) {
                case 1:
                    createQuestion();
                    break;
                case 2:
                    Output.println("Not Implemented");
                    break;
                case 3:
                    removeQuestion();
                    break;
                case 4:
                    Output.println("Exiting.");
                    return;
                default:
                    Output.println("Unrecognized Command.");
                    break;
            }
        }
    }

    public static void saveSurvey() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        String fname = Input.getString("-------- Save Survey --------\nEnter file name to save to: ");

        try {
            fos = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(loadedSurvey);
            oos.close();
            fos.close();
        } catch (IOException e) {
            Output.println("Unable to output. Please try again.");
        }

    }

    public static void exportSurvey() {
        return;
    }

    public static void gradeTest() {
        return;
    }

    public static void editTest() {
        return;
    }

    public static void removeQuestion() {
        int toRemove = Input.getInt("Enter question number to remove: ");

        if (toRemove < loadedSurvey.getQuestions().size())
            loadedSurvey.removeQuestion(toRemove);
    }

    public static void createQuestion() {
        int choice, nAns;
        String qPrompt, aPrompt;
        Question q = null;
        Output.println("-------- Add Question --------");
        Output.println("Question Types:\n1. Multiple Choice\n2. True/False\n3. Essay\n4. Short Answer\n5. Date");

        while (true) {
            choice = Input.getInt("Enter the number corresponding to the desired type: ");
            if (choice <= 5 && choice > 0)
                break;
        }

        qPrompt = Input.getString("Enter the question prompt: ");

        switch (choice) {
            case 1:
                List<String> choices = new ArrayList<String>();
                while (true) {
                    String c = Input.getString("Enter choice: ");
                    if (c.compareTo("") == 0)
                        break;
                    else
                        choices.add(c);
                }
                nAns = Input.getInt("Enter the number of allowed answers: ");
                q = new MCQuestion(qPrompt, nAns, choices);
                break;
            case 2:
                q = new TFQuestion(qPrompt);
                break;
            case 3:
                aPrompt = Input.getString("Enter the answer prompt: ");
                nAns = Input.getInt("Enter the number of allowed answers: ");
                q = new EssayQuestion(qPrompt, aPrompt, nAns);
                break;
            case 4:
                aPrompt = Input.getString("Enter the answer prompt: ");
                nAns = Input.getInt("Enter the number of allowed answers: ");
                int l = Input.getInt("Enter the max answer length: ");
                q = new ShortAnswerQuestion(qPrompt, aPrompt, nAns, l);
                break;
            case 5:
                nAns = Input.getInt("Enter the number of allowed answers: ");
                Date min = Input.getDate("Enter the minimum date: ");
                Date max = Input.getDate("Enter the maximum date: ");
                q = new DateQuestion(qPrompt, nAns, min, max);
                break;
        }
        if (q != null)
            loadedSurvey.addQuestion(q);
    }

    public static void displaySurvey() {
        for (Question q : loadedSurvey.getQuestions()) {
            Output.println("-------- Survey Question --------");
            Output.println(q.getQuestionPrompt());
            Output.println(q.getAnswerPrompt());
            for (String ans : q.getAnswers()) {
                Output.println("ANSWER:\t" + ans);
            }
        }
    }
}