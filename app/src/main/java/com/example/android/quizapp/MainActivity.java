package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correct = 0;
    String playName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this a method to get the user name from the text field
     */
    private String getUsername() {
        EditText userName = (EditText) findViewById(R.id.userName);
        String usrName = userName.getText().toString();
        return usrName;
    }

    /**
     * This method checks whether question one is correct and adds a score of one to the variable correct
     */
    private void question1() {
        RadioButton radioButtonQ1 = (RadioButton) findViewById(R.id.radio_q1b);
        boolean isRadioButtonQ1Checked = radioButtonQ1.isChecked();
        if (isRadioButtonQ1Checked) {
            correct = correct + 1;
        }
    }

    /**
     * This method checks whether question two is correct and adds a score of one to the variable correct
     */
    private void question2() {
        RadioButton radioButtonQ2 = (RadioButton) findViewById(R.id.radio_q2d);
        boolean isRadioButtonQ2Checked = radioButtonQ2.isChecked();
        if (isRadioButtonQ2Checked) {
            correct = correct + 1;
        }
    }

    /**
     * This method checks whether question three is correct and adds a score of one to the variable correct
     */
    private void question3() {
        RadioButton radioButtonQ3 = (RadioButton) findViewById(R.id.radio_q3a);
        boolean isRadioButtonQ3Checked = radioButtonQ3.isChecked();
        if (isRadioButtonQ3Checked) {
            correct = correct + 1;
        }

    }

    /**
     * This method checks whether question four is correct and adds a score of one to the variable correct
     * itn uses unary operators to allow for more than one correct answer
     */
    private void question4() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_q4a);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_q4b);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_q4c);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_q4d);
        Boolean isCheckbox1 = checkBox1.isChecked();
        Boolean isCheckbox2 = checkBox2.isChecked();
        Boolean isCheckbox3 = checkBox3.isChecked();
        Boolean isCheckbox4 = checkBox4.isChecked();

        if (isCheckbox1 && isCheckbox3 && !isCheckbox2 && !isCheckbox4) {
            correct = correct + 1;
        }
    }

    private String question5() {
        EditText playerName = (EditText) findViewById(R.id.greatestPlayer);
        String playName = playerName.getText().toString();
        return playName;
    }

    private void checkAllQuestions() {
        question1();
        question2();
        question3();
        question4();

    }

    /**
     * This method reset the variable correct to zero, clearing the current score
     */
    private void resetCorrect() {
        correct = 0;
    }

    /**
     * This is called when the results button is pressed.
     * It call the method checkAllQuestions and outputs a message of the correct answer in a toast
     */
    public void calculateResult(View view) {
        checkAllQuestions();
        Toast.makeText(MainActivity.this, getUsername() + " Correct Answers are: " + correct + "/4 and " + question5() + " is the greatest player ever",
                Toast.LENGTH_LONG).show();
        resetCorrect();
    }
}
