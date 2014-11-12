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



public class ScoreScreen extends Activity {

    private Button homeButton;
    private Button playButton;

    private TextView rightText;
    private TextView wrongText;
    private Intent homeIntent;
    private Intent quizIntent;

    private String rightMessage;
    private String wrongMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
         homeButton = (Button)findViewById(R.id.button2);
         playButton = (Button)findViewById(R.id.button);

        rightText = (TextView)findViewById(R.id.textView2);
        wrongText = (TextView)findViewById(R.id.textView3);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        rightMessage = extras.getString("myRightMessage");
        wrongMessage = extras.getString("myWrongMessage");


        String rightPoints = "Questions Answered Right: " + rightMessage;
        String wrongPoints = "Questions Answered Wrong: " + wrongMessage;

        rightText.setText(rightPoints);
        wrongText.setText(wrongPoints);



        SharedPreferences sharedPref = this.getSharedPreferences("score.xml",MODE_PRIVATE);
        int myvalue = sharedPref.getInt("score", 0);

        if(myvalue < Integer.parseInt(rightMessage))
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("score", Integer.parseInt(rightMessage));
            editor.apply();
        }



        homeIntent = new Intent(this,MyActivity.class);
          quizIntent = new Intent(this,Quiz.class);

        homeButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(homeIntent);

            }
        } );

        playButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(quizIntent);

            }
        } );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.score_screen, menu);
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
}
