package com.example.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Select_workout extends Activity{
		static boolean loseWeight = false;
	    static boolean gainMuscle = false;
	    static boolean both = false;
		
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_workout);
        Intent i = getIntent();
    
	    Button weightLoss = (Button) findViewById(R.id.Lose_Weight_Button);
	    
        //Listening to button event
        weightLoss.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				loseWeight = true;
		        //Starting a new Intent
		            Intent nextScreen = new Intent(getApplicationContext(), Select_Workout_Days.class);
			    // TODO Auto-generated method stub
		            startActivity(nextScreen);
			};
        });
        
        Button muscle = (Button) findViewById(R.id.Muscle_Building_Button);
	    
        //Listening to button event
        muscle.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				gainMuscle = true;
		        //Starting a new Intent
		            Intent nextScreen = new Intent(getApplicationContext(), Select_Workout_Days.class);
			    // TODO Auto-generated method stub
		            startActivity(nextScreen);
			};
        });
	
	
	Button mixed = (Button) findViewById(R.id.Mixed_Button);
    
    //Listening to button event
    mixed.setOnClickListener(new View.OnClickListener() {

		public void onClick(View arg0) {
			both = true;
	        //Starting a new Intent
	            Intent nextScreen = new Intent(getApplicationContext(), Select_Workout_Days.class);
		    // TODO Auto-generated method stub
	            startActivity(nextScreen);
		};
    });
}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_workout, menu);
        return true;
			}
	}

