package com.example.testing;

import java.util.Calendar;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
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
	    
	    final String name = prefs.getString("userName", "Something's Not Right");
	    
	    ((TextView)findViewById(R.id.Workout)).setText(name);
	    
	    if (name.contains("Jordan"))
		    ((TextView)findViewById(R.id.Workout)).setText("Dumbbell Bench Press: 3x10\n" +
		    		"Incline Bench Press: 3x10\n" +
		    		"Tricep Dips: 3x10\n" +
		    		"Lying Tricep Extension: 3x10\n" +
		    		"Russian Twists: 3x10");
	    else if (name == "BackWorkout")
	    	((TextView)findViewById(R.id.Workout)).setText("One Arm Dumbbell Row: 3x10 ea. arm\n" +
	    			"Dumbbell Reverse Fly: 3x10\n" +
	    			"Dumbbell Curl: 3x10\n" +
	    			"Hammer Curl: 3x10" +
	    			"Plank: 3x60 seconds");
	    else if (name == "LegWorkout")
	    	((TextView)findViewById(R.id.Workout)).setText("Dumbbell Squat: 3x10\n" +
	    			"Dumbbell Lunge: 3x10\n" +
	    			"Dumbbell Shoulder Press: 3x10\n" +
	    			"Dumbbell Lateral Raise: 3x10\n" +
	    			"Toe Touches: 3x10");
	}
}
