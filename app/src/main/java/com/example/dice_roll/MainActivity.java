package com.example.dice_roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int dice = 0;
    public EditText editText;
    public TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rdg = (RadioGroup) findViewById(R.id.radio_group);
        TextView textView1 = (TextView) findViewById(R.id.textView1);

        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.linear_layout);
//
//// Then just use the following:




        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView1.setFocusable(false);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
                // Code here executes on main thread after user presses button
                String message;
                if(dice > 0) {
                        message = rollDice(dice);


                }
                else if(!editText.getText().toString().equals("")) {
                    if (Integer.parseInt(String.valueOf(editText.getText())) > 0) {

                        message = rollDice(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    else {
                        message = "Please insert sides greater than 0";
                    }
                } else {
                    message = "Please select either radio button or set slides number.";
                }
                textView1.setText(message);
            }
        });

        editText = (EditText) findViewById(R.id.plain_text_input);
        editText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dice = 0;
                textView1.setFocusable(true);
                rdg.clearCheck();

            }
        });
    }
        public void onRadioButtonClicked(View view)
        {
            editText.setHint("");
            editText.setText("");
            //require to import the RadioButton class
            RadioButton rb4 = (RadioButton) findViewById(R.id.radio_clicked_four);
            RadioButton rb6 = (RadioButton) findViewById(R.id.radio_clicked_six);
            RadioButton rb8 = (RadioButton) findViewById(R.id.radio_clicked_eight);

            RadioButton rb10 = (RadioButton) findViewById(R.id.radio_clicked_ten);
            RadioButton rb12 = (RadioButton) findViewById(R.id.radio_clicked_twelve);
            RadioButton rb20 = (RadioButton) findViewById(R.id.radio_clicked_twenty);

            //is the current radio button now checked?
            boolean  checked = ((RadioButton) view).isChecked();

            //now check which radio button is selected
            //android switch statement
            switch(view.getId()){

                case R.id.radio_clicked_four:
                    if(checked)
                        //if windows phone programming book is selected
                        //set the checked radio button's text style bold italic
                        rb4.setTypeface(null, Typeface.BOLD_ITALIC);
                    //set the other two radio buttons text style to default
                    // reqire to import Typeface class
                    dice = 4;
                    rb6.setTypeface(null, Typeface.NORMAL);
                    rb8.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default
                    rb10.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb12.setTypeface(null, Typeface.NORMAL);
                    rb20.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default

                    break;

                case R.id.radio_clicked_six:
                    if(checked)
                        //if ios programming book is selected
                        //set the checked radio button's text style bold italic
                        rb6.setTypeface(null, Typeface.BOLD_ITALIC);
                    dice = 6;
                    //set the other two radio buttons text style to default
                    rb4.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb8.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default
                    rb10.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb12.setTypeface(null, Typeface.NORMAL);
                    rb20.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.radio_clicked_eight:
                    if(checked)
                        //if android programming book is selected
                        //set the checked radio button's text style bold italic
                        rb8.setTypeface(null, Typeface.BOLD_ITALIC);
                    dice = 8;
                    //set the other two radio buttons text style to default
                    rb6.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb4.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default
                    rb10.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb12.setTypeface(null, Typeface.NORMAL);
                    rb20.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.radio_clicked_ten:
                    if(checked)
                        //if android programming book is selected
                        //set the checked radio button's text style bold italic
                        rb10.setTypeface(null, Typeface.BOLD_ITALIC);
                    //set the other two radio buttons text style to default
                    rb6.setTypeface(null, Typeface.NORMAL);
                    dice = 10;
                    // reqire to import Typeface class
                    rb4.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default
                    rb8.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb12.setTypeface(null, Typeface.NORMAL);
                    rb20.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.radio_clicked_twelve:
                    if(checked)
                        //if android programming book is selected
                        //set the checked radio button's text style bold italic
                        rb12.setTypeface(null, Typeface.BOLD_ITALIC);
                    //set the other two radio buttons text style to default
                    dice = 12;
                    rb6.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb4.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default
                    rb10.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb8.setTypeface(null, Typeface.NORMAL);
                    rb20.setTypeface(null, Typeface.NORMAL);
                    break;

                case R.id.radio_clicked_twenty:
                    if(checked)
                        //if android programming book is selected
                        //set the checked radio button's text style bold italic
                        rb20.setTypeface(null, Typeface.BOLD_ITALIC);
                    //set the other two radio buttons text style to default
                    dice = 20;
                    rb6.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb4.setTypeface(null, Typeface.NORMAL);
                    //set the other two radio buttons text style to default
                    rb10.setTypeface(null, Typeface.NORMAL);
                    // reqire to import Typeface class
                    rb12.setTypeface(null, Typeface.NORMAL);
                    rb8.setTypeface(null, Typeface.NORMAL);
                    break;
            }
        }


    private static String rollDice(int sides) {
        int number;
        Random rand = new Random();


            number = rand.nextInt(sides);

        return Integer.toString(number);
    }

//    public void hideKeyboard(View view) {
//        try {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        } catch(Exception ignored) {
//        }
}