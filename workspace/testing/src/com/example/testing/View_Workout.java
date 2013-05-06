package com.example.testing;

import java.util.Calendar;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class View_Workout extends Activity {
	public Boolean attempt;
	public String today;
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();

	    final SharedPreferences prefs1 = getSharedPreferences("winFitPref", 0);
		
		Editor edit1 = prefs1.edit();
		edit1.putBoolean("passfail", attempt);
		edit1.putString("todaysDate", today);
		edit1.commit();
	}
	
	
	@SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.view_workout);
	    
	    
	    

	    
	    final SharedPreferences prefs = getSharedPreferences("winFitPref", 0);
	    
	    	    
	    final String lastDate = prefs.getString("todaysDate", "0");
	    final Boolean passFail = prefs.getBoolean("passfail", false);
	    attempt = passFail;
	    
	    final Calendar objCalendar = Calendar.getInstance();
	    final String todayDay = objCalendar.getDisplayName(Calendar.DAY_OF_WEEK, 2, Locale.US);
	    final String todayMonth = objCalendar.getDisplayName(Calendar.MONTH, 2, Locale.US);
	    final int todayNum = objCalendar.get(Calendar.DAY_OF_MONTH);
	    final int todayYear = objCalendar.get(Calendar.YEAR);
	    
	    today = todayDay + ", " + todayMonth + " " + todayNum + ", " + todayYear;
	    
	    Boolean firstView = !today.equals(lastDate);
	    
	    if(firstView)
	    	attempt = false;
	    
	    ((TextView)findViewById(R.id.Date)).setText(today);
	    
	    
	    Button btnYes = (Button) findViewById(R.id.CompleteYes);
	    
        //Listening to button event
        btnYes.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				
				Editor edit1 = prefs.edit();
				edit1.putBoolean("passfail", true);
				edit1.putString("todaysDate", today);
				edit1.commit();
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
				
				Editor edit1 = prefs.edit();
				edit1.putBoolean("passfail", true);
				edit1.putString("todaysDate", today);
				edit1.commit();
				
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
	    
	    if(todayDay.equals(day1))
	    	if (workoutname.equals("BuildMuscle"))
			    ((TextView)findViewById(R.id.Workout)).setText(R.string.muscle1);
	    	else if(workoutname.equals("LoseWeight"))
	    		((TextView)findViewById(R.id.Workout)).setText("Run 3 Miles");
	    	else
	    		((TextView)findViewById(R.id.Workout)).setText("Do a Cardio Workout.");
	    else if (todayDay.equals(day2))
	    	if (workoutname.equals("BuildMuscle"))
		    	((TextView)findViewById(R.id.Workout)).setText(R.string.muscle2);
	    	else if(workoutname.equals("LoseWeight"))
	    		((TextView)findViewById(R.id.Workout)).setText("Run 4 Miles");
	    	else
	    		((TextView)findViewById(R.id.Workout)).setText("Play Basketball");
	    else if (todayDay.equals(day3))
	    	if (workoutname.equals("BuildMuscle"))
		    	((TextView)findViewById(R.id.Workout)).setText(R.string.muscle3);
	    	else if(workoutname.equals("LoseWeight"))
	    		((TextView)findViewById(R.id.Workout)).setText("Run 6 Miles");
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
	    
	    if(attempt){
	    	View text = findViewById(R.id.CompleteText);
	    	View yup = findViewById(R.id.CompleteYes);
	    	View nope = findViewById(R.id.CompleteNo);
	    	text.setVisibility(View.GONE);
	    	yup.setVisibility(View.GONE);
	    	nope.setVisibility(View.GONE);
	    }

	}
}
