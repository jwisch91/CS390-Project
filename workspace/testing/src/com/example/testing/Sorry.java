package com.example.testing;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Sorry extends Activity{
public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.sorry);
	    
	    SharedPreferences prefs = getSharedPreferences("winFitPref", 0);
	    
	    int successes = prefs.getInt("successes", 0);
	    int workouts = prefs.getInt("workouts", 0);
	    workouts++;
	    int percent = 100*successes/workouts;
	    
	    int firstweight = Integer.parseInt(prefs.getString("userWeight", "0"));
	    int lastweight = Integer.parseInt(prefs.getString("new weight", String.valueOf(firstweight)));
	    int weightchange = lastweight-firstweight;
	    boolean useEnglish = prefs.getBoolean("English", true);
	    
	    ((TextView)findViewById(R.id.SuccessesTextS)).setText("Completed Workouts: " + successes);
	    ((TextView)findViewById(R.id.AttemptedTextS)).setText("Total Workouts Attempted: " + workouts);
	    ((TextView)findViewById(R.id.PercentTextS)).setText("Percent Successful: " + percent + "%");

	    
	    if(useEnglish){
	    	((TextView)findViewById(R.id.InitialWeightS)).setText("Weight at Start of Plan: " + firstweight + " lbs");
	    	((TextView)findViewById(R.id.LastWeightS)).setText("Last Measured Weight: " + lastweight + " lbs");
	    	((TextView)findViewById(R.id.WeightChangeS)).setText("Weight Change: " + weightchange + " lbs");
	    }
	    else{
	    	((TextView)findViewById(R.id.InitialWeightS)).setText("Weight at Start of Plan: " + firstweight + " kg");
	    	((TextView)findViewById(R.id.LastWeightS)).setText("Last Measured Weight: " + lastweight + " kg");
	    	((TextView)findViewById(R.id.WeightChangeS)).setText("Weight Change: " + weightchange + " kg");
	    }
	    
	    Editor edit = prefs.edit();
	    edit.putInt("successes", successes);
	    edit.putInt("workouts", workouts);
	    edit.commit();
	    
	    new CountDownTimer(5000,1000){
	        @Override
	        public void onTick(long millisUntilFinished){} 

	        @Override
	        public void onFinish(){
	               //set the new Content of your activity
	        	Intent nextScreen = new Intent(getApplicationContext(), Main_Menu_2.class);
			    // TODO Auto-generated method stub
		            startActivity(nextScreen);
	        }
	   }.start();
	}

}

