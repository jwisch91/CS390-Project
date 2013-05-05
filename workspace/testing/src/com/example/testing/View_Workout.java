package com.example.testing;

import java.util.Calendar;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class View_Workout extends Activity {
	@SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.view_workout);
	    
	    final Calendar objCalendar = Calendar.getInstance();
	    final String today = objCalendar.getDisplayName(Calendar.DAY_OF_WEEK, 2, Locale.US);
	    final String todayMonth = objCalendar.getDisplayName(Calendar.MONTH, 2, Locale.US);
	    final int todayNum = objCalendar.get(Calendar.DAY_OF_MONTH);

	    
	    SharedPreferences prefs = getSharedPreferences("winFitPref", 0);
	    
	    ((TextView)findViewById(R.id.Date)).setText(today + ", " + todayMonth + " " + todayNum);
	    
	    final String name = prefs.getString("workout", "Something's Not Right");
	    
	    ((TextView)findViewById(R.id.Workout)).setText(name);
	    
	    
	    Button btnYes = (Button) findViewById(R.id.CompleteYes);
	    
        //Listening to button event
        btnYes.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
		        //Starting a new Intent
		            Intent nextScreen = new Intent(getApplicationContext(), Congrats.class);
			    // TODO Auto-generated method stub
		            startActivity(nextScreen);
			}
        });
        
	    Button btnNo = (Button) findViewById(R.id.CompleteNo);
	    
        //Listening to button event
        btnNo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
		        //Starting a new Intent
		            Intent nextScreen = new Intent(getApplicationContext(), Sorry.class);
			    // TODO Auto-generated method stub
		            startActivity(nextScreen);
			}
        });

	    final String workoutname = prefs.getString("workout", "Error");
	    final String day1 = prefs.getString("day1", "Error");
	    final String day2 = prefs.getString("day2", "Error");
	    final String day3 = prefs.getString("day3", "Error");
	    
	    if(today.contains(day1))
	    	if (workoutname.contains("BuildMuscle"))
			    ((TextView)findViewById(R.id.Workout)).setText("Dumbbell Bench Press: 3x10\n" +
			    		"Incline Bench Press: 3x10\n" +
			    		"Tricep Dips: 3x10\n" +
			    		"Lying Tricep Extension: 3x10\n" +
			    		"Russian Twists: 3x10");
	    	else if(workoutname.contains("LoseWeight"))
	    		((TextView)findViewById(R.id.Workout)).setText("Go Running.");
	    	else
	    		((TextView)findViewById(R.id.Workout)).setText("Cardio Workout.");
	    else if (today.contains(day2))
	    	if (workoutname.contains("BuildMuscle"))
		    	((TextView)findViewById(R.id.Workout)).setText("One Arm Dumbbell Row: 3x10 ea. arm\n" +
		    			"Dumbbell Reverse Fly: 3x10\n" +
		    			"Dumbbell Curl: 3x10\n" +
		    			"Hammer Curl: 3x10" +
		    			"Plank: 3x60 seconds");
	    	else if(workoutname.contains("LoseWeight"))
	    		((TextView)findViewById(R.id.Workout)).setText("Go Running.");
	    	else
	    		((TextView)findViewById(R.id.Workout)).setText("Play Basketball");
	    else if (today.contains(day3))
	    	if (workoutname.contains("BuildMuscle"))
		    	((TextView)findViewById(R.id.Workout)).setText("Dumbbell Squat: 3x10\n" +
		    			"Dumbbell Lunge: 3x10\n" +
		    			"Dumbbell Shoulder Press: 3x10\n" +
		    			"Dumbbell Lateral Raise: 3x10\n" +
		    			"Toe Touches: 3x10");
	    	else if(workoutname.contains("LoseWeight"))
	    		((TextView)findViewById(R.id.Workout)).setText("Go Running.");
	    	else
	    		((TextView)findViewById(R.id.Workout)).setText("Go Running.");
	    else{
	    	((TextView)findViewById(R.id.Workout)).setText("You have no workout today");
	    	View text = findViewById(R.id.CompleteText);
	    	View yup = findViewById(R.id.CompleteYes);
	    	View nope = findViewById(R.id.CompleteNo);
	    	text.setVisibility(View.GONE);
	    	yup.setVisibility(View.GONE);
	    	nope.setVisibility(View.GONE);
	    	
	    }

	}
}
