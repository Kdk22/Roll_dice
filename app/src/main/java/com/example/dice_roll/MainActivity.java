package com.example.dice_roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
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

        RadioButton rb4 = (RadioButton) findViewById(R.id.radio_clicked_four);
        RadioButton rb6 = (RadioButton) findViewById(R.id.radio_clicked_six);
        RadioButton rb8 = (RadioButton) findViewById(R.id.radio_clicked_eight);

        RadioButton rb10 = (RadioButton) findViewById(R.id.radio_clicked_ten);
        RadioButton rb12 = (RadioButton) findViewById(R.id.radio_clicked_twelve);
        RadioButton rb20 = (RadioButton) findViewById(R.id.radio_clicked_twenty);


        editText = (EditText) findViewById(R.id.plain_text_input);

        if(UpdateInt("textValue") % 1 == 0 && UpdateInt("textValue") > 0) {
            editText.setText(Integer.toString(UpdateInt("textValue")));
            dice = UpdateInt("textValue");
        } else if(UpdateBool("d4")){
            dice = 4;
            rb4.setChecked(UpdateBool("d4"));
        } else if(UpdateBool("d6")){
            dice = 6;
            rb6.setChecked(UpdateBool("d6"));

        } else if(UpdateBool("d8") ){
            dice = 8;
            rb8.setChecked(UpdateBool("d8"));

        } else if(UpdateBool("d10")){
            dice = 10;
            rb10.setChecked(UpdateBool("d10"));

        } else if(UpdateBool("d12")){
            dice = 12;
            rb12.setChecked(UpdateBool("d12"));

        } else if(UpdateBool("d20")){
            dice = 20;
            rb20.setChecked(UpdateBool("d20"));

        } else {
            dice = 0;
        };



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

                        SaveIntoSharedPrefs("textValue", Integer.parseInt(String.valueOf(editText.getText())), false);

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

            RadioButton rb4 = (RadioButton) findViewById(R.id.radio_clicked_four);
            RadioButton rb6 = (RadioButton) findViewById(R.id.radio_clicked_six);
            RadioButton rb8 = (RadioButton) findViewById(R.id.radio_clicked_eight);

            RadioButton rb10 = (RadioButton) findViewById(R.id.radio_clicked_ten);
            RadioButton rb12 = (RadioButton) findViewById(R.id.radio_clicked_twelve);
            RadioButton rb20 = (RadioButton) findViewById(R.id.radio_clicked_twenty);

            editText.setHint("");
            editText.setText("");
            ResetSharedPref();
//            SaveIntoSharedPrefs("textValue", 0, false);
            //require to import the RadioButton class


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
                    SaveIntoSharedPrefs("d4", 0, true);
                    SaveIntoSharedPrefs("d6", 0, false);
                    SaveIntoSharedPrefs("d8", 0, false);
                    SaveIntoSharedPrefs("d10", 0, false);
                    SaveIntoSharedPrefs("d12", 0, false);
                    SaveIntoSharedPrefs("d20", 0, false);

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

                    SaveIntoSharedPrefs("d6", 0, true);
                    SaveIntoSharedPrefs("d4", 0, false);
                    SaveIntoSharedPrefs("d8", 0, false);
                    SaveIntoSharedPrefs("d10", 0, false);
                    SaveIntoSharedPrefs("d12", 0, false);
                    SaveIntoSharedPrefs("d20", 0, false);
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


                    SaveIntoSharedPrefs("d8", 0, true);

                    SaveIntoSharedPrefs("d4", 0, false);
                    SaveIntoSharedPrefs("d6", 0, false);
                    SaveIntoSharedPrefs("d10", 0, false);
                    SaveIntoSharedPrefs("d12", 0, false);
                    SaveIntoSharedPrefs("d20", 0, false);

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

                    SaveIntoSharedPrefs("d10", 0, true);

                    SaveIntoSharedPrefs("d4", 0, false);
                    SaveIntoSharedPrefs("d6", 0, false);
                    SaveIntoSharedPrefs("d8", 0, false);
                    SaveIntoSharedPrefs("d12", 0, false);
                    SaveIntoSharedPrefs("d20", 0, false);

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

                    SaveIntoSharedPrefs("d12", 0, true);

                    SaveIntoSharedPrefs("d4", 0, false);
                    SaveIntoSharedPrefs("d6", 0, false);
                    SaveIntoSharedPrefs("d8", 0, false);
                    SaveIntoSharedPrefs("d10", 0, false);
                    SaveIntoSharedPrefs("d20", 0, false);
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

                    SaveIntoSharedPrefs("d20", 0, true);

                    SaveIntoSharedPrefs("d4", 0, false);
                    SaveIntoSharedPrefs("d6", 0, false);
                    SaveIntoSharedPrefs("d8", 0, false);
                    SaveIntoSharedPrefs("d10", 0, false);
                    SaveIntoSharedPrefs("d12", 0, false);

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

    do {
        number = rand.nextInt(sides+1);
    } while (number == 0);
            return Integer.toString(number);
    }

    private void SaveIntoSharedPrefs(String key, int diceVal, boolean value){

        SharedPreferences sp = getSharedPreferences("Dice", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(diceVal > 0){
            editor.putInt(key, diceVal);
        }else {
            editor.putBoolean(key, value);

        }
        editor.apply();
    }


    private int UpdateInt(String key){
        SharedPreferences sp = getSharedPreferences("Dice", MODE_PRIVATE);
            return sp.getInt(key, 0);
        }


    private boolean UpdateBool(String key){
        SharedPreferences sp = getSharedPreferences("Dice", MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    private void ResetSharedPref(){
        SharedPreferences sp = getSharedPreferences("Dice", MODE_PRIVATE);
        sp.edit().clear().commit();
    }
    }
//    public void hideKeyboard(View view) {
//        try {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        } catch(Exception ignored) {
//        }