package com.example.testing;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Open_Page extends Activity {

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.new_file);
	    Button btnFirstScreen = (Button) findViewById(R.id.GPS_Button);
	    
        //Listening to button event
        btnFirstScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
		        //Starting a new Intent
		            Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
			    // TODO Auto-generated method stub
		            startActivity(nextScreen);
			}
        });
        Button btnSecondScreen = (Button) findViewById(R.id.Calender_Button);
	    
        //Listening to button event;
	    
        //Listening to button event
        btnSecondScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				timerAlert(view);
			}
        });
        Button btnThirdScreen = (Button) findViewById(R.id.About_Us);
	    
        //Listening to button event
        btnThirdScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
		        //Starting a new Intent
		            Intent thirdScreen = new Intent(getApplicationContext(), Third_Page.class);
			    // TODO Auto-generated method stub
		            startActivity(thirdScreen);
			}
        });
        Button btnFourthScreen = (Button) findViewById(R.id.Workout_Button);
	    
        //Listening to button event
        btnFourthScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
		        //Starting a new Intent
		            Intent thirdScreen = new Intent(getApplicationContext(), Select_workout.class);
			    // TODO Auto-generated method stub
		            startActivity(thirdScreen);
			}
        });
        Button btnSettings = (Button) findViewById(R.id.Settings);
	    
        //Listening to button event
        btnSettings.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
		        //Starting a new Intent
		            Intent settingsScreen = new Intent(getApplicationContext(), Settings.class);
			    // TODO Auto-generated method stub
		            startActivity(settingsScreen);
			}
        });

	}
	public void timerAlert(View view) {
		Toast.makeText(this, "Preparing Alarm...", Toast.LENGTH_LONG).show();
		Intent timerIntent = new Intent(this, AlarmBroadcastReceiver.class);
		PendingIntent pIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0 , timerIntent, 0);
		AlarmManager myAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);
		myAlarm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pIntent);
		
	}
}

