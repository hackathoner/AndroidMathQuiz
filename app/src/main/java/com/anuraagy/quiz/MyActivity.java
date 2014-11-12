package com.anuraagy.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.content.*;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;

public class MyActivity extends Activity {
    //Create all the private button fields
    private Button helpButton;
    private Button playButton;
    private Button highScoreButton;

    //Create all private intent fields
    private Intent helpIntent;
    private Intent quizIntent;
    private Intent highScoreIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Create the buttons from the fields
        Button helpButton = (Button)findViewById(R.id.instructions);
        Button playButton = (Button)findViewById(R.id.startButton);
        Button highScoreButton = (Button)findViewById(R.id.highscores);

        //Create all the intents
        final Intent highScoreIntent = new Intent(this,Highscore.class);
        final Intent quizIntent = new Intent(this,Quiz.class);
        final Intent helpIntent = new Intent(this,Help.class);

        //Makes the click of the help button take you to the instructions page
        helpButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(helpIntent);

            }
        } );

        //Makes the click of the play button take you to the quiz page
        playButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(quizIntent);

            }
        } );

        //Makes the click of the highscore button take you to the highscore page
        highScoreButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(highScoreIntent);

            }
        } );
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
