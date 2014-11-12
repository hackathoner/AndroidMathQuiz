package com.anuraagy.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.content.*;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;
import java.util.*;
import android.app.*;

import java.text.AttributedCharacterIterator;


public class Quiz extends Activity {

    //Create all the private button fields
    private Button submitButton;
    private EditText inputText;
    private TextView viewText;
    private TextView rightText;
    public static String myRightMessage;
    public static String myWrongMessage;
    private TextView wrongText;

    private int number1;
    private int wrong;
    private int right;
    private int number2;
    private TextView titleText;
    private int inputValue;
    private int totalValue;
    private int currentNumber;
    private String numberString;
    private ArrayList runningTotal;
    private Intent scoreIntent;
    private String myTextIsCool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button submit = (Button)findViewById(R.id.button);

        viewText = (TextView)findViewById(R.id.myNumbers);


        inputText = (EditText)findViewById(R.id.numberInputed);

        titleText = (TextView)findViewById(R.id.textView);

        rightText = (TextView)findViewById(R.id.right);
        wrongText = (TextView)findViewById(R.id.wrong);

        wrong = 0;
        right = 0;
        rightText.setText("Number Right: " + right);
        wrongText.setText("Number Wrong: " + wrong);

        currentNumber = 18;
        titleText.setText("Question " + currentNumber);

        runningTotal = new ArrayList();
//        boolean hello = mathString();
        newProblem();
        submit.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                if(currentNumber < 20 ) {
                    if (checkAnswer()) {
                        currentNumber++;
//                        showRightAlert();
                        right++;
                        inputText.setText("");
                        titleText.setText("Question " + currentNumber);
                        rightText.setText("Number Right: " + right);
                        newProblem();

                    } else {
                      showWrongAlert();
                      wrong++;
                        currentNumber++;
                        titleText.setText("Question " + currentNumber);
                        wrongText.setText("Number Wrong: " + wrong);
                        inputText.setText("");
                        newProblem();

                    }
                }
                else
                {
                    //String myWrong = wrong+ "";
                    //String myRight = right + "";

                    scoreIntent = new Intent(getApplicationContext(),ScoreScreen.class);
                    Bundle extras = new Bundle();
                    extras.putString("myRightMessage",Integer.toString(right));
                    extras.putString("myWrongMessage",Integer.toString(wrong));
                    scoreIntent.putExtras(extras);

                    startActivity(scoreIntent);
                }
            }
        } );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void newProblem()
    {
         number1 = (int)(Math.random()*12 + 1);
         number2 = (int)(Math.random()*12 + 1);
         totalValue = number1 * number2;

        String numberString = number1 + " * " + number2;
        viewText.setText(numberString);


    }

    private void showWrongAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bummmmmmer. Your answer is wrong")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showRightAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You are right!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    //Check the answer submitted
    private boolean checkAnswer()
    {

        if(number1*number2 == Integer.parseInt(inputText.getText().toString()))
        {
            runningTotal.add("true");
            return true;
        }
        else
        {
            runningTotal.add("false");
            return false;
        }
    }
//    private boolean mathString()
//    {
//
//
//        int number1 = (int)(Math.random()*12 + 1);
//        int number2 = (int)(Math.random()*12 + 1);
//        int value = number1 * number2;
//
//        String totalText = number1 + " * " + number2;
//
//        TextView viewText = (TextView)findViewById(R.id.textView4);
//        viewText.setText(totalText);
//
//        EditText inputText = (EditText)findViewById(R.id.numberInputed);
//        String s = inputText.getText().toString();
//        int value2 = Integer.parseInt(s);
//
//        if(value == value2)
//            return true;
//       else
//            return false;
//    }
}
