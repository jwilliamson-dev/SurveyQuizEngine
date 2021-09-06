package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateQuestion extends Question {
    private Date minDate;
    private Date maxDate;
    private static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public DateQuestion(String qPrompt, int nAns, Date min, Date max) {
        super(qPrompt, nAns);
        this.minDate = min;
        this.maxDate = max;
    }

    public void setMinDate(Date d) {
        this.minDate = d;
    }

    public void setMaxDate(Date d) {
        this.maxDate = d;
    }

    public Date getMinDate() {
        return this.minDate;
    }

    public Date getMaxDate() {
        return this.maxDate;
    }

    @Override
    protected boolean validateAnswer(String ans) {
        Date d = null;
        try {
            d = df.parse(ans);
        } catch (ParseException e) {
            Output.println("Input must be a valid date in format: " + df.toPattern() + " .");
        }

        return d.after(this.minDate) && d.before(this.maxDate);
    }

    @Override
    public String getAnswerPrompt() {
        return "Enter a date in MM/dd/yyyy format between " + df.format(this.minDate) + " and "
                + df.format(this.maxDate) + ".";
    }

}
