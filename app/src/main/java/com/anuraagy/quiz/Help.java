package com.anuraagy.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Help extends Activity {

    //Create all the private button fields
    private Button playButton;
    private Button homeButton;

    //Create all private intent fields
    private Intent playIntent;
    private Intent homeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        Button homeButton = (Button)findViewById(R.id.button);
        Button playButton = (Button)findViewById(R.id.button2);

        final Intent playIntent = new Intent(this,Quiz.class);
        final Intent homeIntent = new Intent(this,MyActivity.class);

        //Makes the click of the help button take you to the instructions page
        homeButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(homeIntent);

            }
        } );

        //Makes the click of the play button take you to the quiz page
        playButton.setOnClickListener(new View.OnClickListener() {
            //Onclick button function
            public void onClick(View view) {
                startActivity(playIntent);

            }
        } );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.help, menu);
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
