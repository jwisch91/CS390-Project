package com.example.testing;

import java.util.Calendar;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Select_Workout_Days extends Activity{
	    public static long eventID = 42;
		private CheckBox mon, tues, wed, thurs, fri, sat, sun; //Variables for the checkboxes
	    private String REPEATDAYS= "BYDAY=";
	    private int ADAY = 1000*60*60*24; //24hrs
	    String[] wktdays = new String[3];

 	    
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_workout_days);
        addListenerOnSubmit(); //Listener for what to do with the days selected
    }
	
	

	public void addListenerOnSubmit(){
		// same thing with as with the checkbox listener, except I have the button here. 
		mon = (CheckBox) findViewById(R.id.Monday);
		tues = (CheckBox) findViewById(R.id.Tuesday);
		wed = (CheckBox) findViewById(R.id.Wednesday);
		thurs= (CheckBox) findViewById(R.id.Thursday);
		fri = (CheckBox) findViewById(R.id.Friday);
		sat = (CheckBox) findViewById(R.id.Saturday);
		sun = (CheckBox) findViewById(R.id.Sunday);
		Button submit = (Button) findViewById(R.id.SubmitDays);
				
		Intent timerIntent = new Intent(this, AlarmBroadcastReceiver.class);
		final PendingIntent pIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0 , timerIntent, 0);
		final AlarmManager myAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);
		final Intent calIntent = new Intent(Intent.ACTION_INSERT);
		calIntent.setType("vnd.android.cursor.item/event");
		
		final Calendar objCalendar = Calendar.getInstance();
		final int thisYear = objCalendar.get(Calendar.YEAR);
		final int thisMonth = objCalendar.get(Calendar.MONTH);
		final int thisWeek = objCalendar.get(Calendar.WEEK_OF_MONTH);
		final int today = objCalendar.get(Calendar.DAY_OF_WEEK);


		objCalendar.set(Calendar.YEAR, thisYear); 
		objCalendar.set(Calendar.MONTH, thisMonth);
		objCalendar.set(Calendar.WEEK_OF_MONTH, thisWeek); 
		objCalendar.set(Calendar.DAY_OF_WEEK, today);
		objCalendar.set(Calendar.HOUR_OF_DAY, 11); 
		objCalendar.set(Calendar.MINUTE, 0); 
		objCalendar.set(Calendar.SECOND, 0);
		objCalendar.set(Calendar.MILLISECOND, 0);
		//objCalendar.set(Calendar.MILLISECOND, 0);
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			/*
			This is a little trippy.  What this has changed into is a scheduler with a repeating alarm
			and notification.  It's a default notification that goes off every 24hrs starting with the
			day you create your workout.  It gives the user the option to click the notification to go into
			the app and view their workout.  It will only fill in the calendar on the days you select.  To emphaisze,
			the alarm and notification will go off every day.  See code for the spots that define these actions. 
			 */
			 
			  @Override
			  public void onClick(View v) {
				// Start checking for day selection.
				  
				  int count = 0;
				  
				  if (mon.isChecked()){
					  if(count < 3)
						  wktdays[count] = "Monday";
					  count++;
					  if (REPEATDAYS == "BYDAY=")
					  	  REPEATDAYS = REPEATDAYS + "MO";
					  else
						  REPEATDAYS = REPEATDAYS + ",MO";

				  }
				  if (tues.isChecked()){
					  if(count < 3)
						  wktdays[count] = "Tuesday";
					  count++;
					  if (REPEATDAYS == "BYDAY=")
						  	REPEATDAYS = REPEATDAYS + "TU";
					  else
						    REPEATDAYS = REPEATDAYS + ",TU";
				  }
				  if (wed.isChecked()){
					  count++;if(count < 3)
						  wktdays[count] = "Wednesday";
					  if (REPEATDAYS == "BYDAY=")
						  	REPEATDAYS = REPEATDAYS + "WE";
					  else
						    REPEATDAYS = REPEATDAYS + ",WE";
				  }
				  if (thurs.isChecked()){
					  if(count < 3)
						  wktdays[count] = "Thursday";
					  count++;
					  if (REPEATDAYS == "BYDAY=")
						  	REPEATDAYS = REPEATDAYS + "TH";
					  else
						    REPEATDAYS = REPEATDAYS + ",TH";
				  }
				  if (fri.isChecked()){
					  if(count < 3)
						  wktdays[count] = "Friday";
					  count++;
					  if (REPEATDAYS == "BYDAY=")
						  	REPEATDAYS = REPEATDAYS + "FR";
					  else
						    REPEATDAYS = REPEATDAYS + ",FR";
				  }
				  if (sat.isChecked()){
					  if(count < 3)
						  wktdays[count] = "Saturday";
					  count++;
					  if (REPEATDAYS == "BYDAY=")
						  	REPEATDAYS = REPEATDAYS + "SA";
					  else
						    REPEATDAYS = REPEATDAYS + ",SA";
				  }
				  if (sun.isChecked()){
					  if(count < 3)
						  wktdays[count] = "Sunday";
					  count++;
					  if (REPEATDAYS == "BYDAY=")
						  	REPEATDAYS = REPEATDAYS + "SU";
					  else
						    REPEATDAYS = REPEATDAYS + ",SU";
				  }
				  // end checking for day selection
				  
				  if(count != 3){
					  Toaster(R.string.choose3days);
					  REPEATDAYS = "BYDAY=";
				  }
				  else{
				  
				  	count = count*3;
				  	String events = String.valueOf(count);
				  	SharedPreferences prefs = getSharedPreferences("winFitPref", 0);
				  	boolean useCalendar = prefs.getBoolean("Use Calendar", true);
				  	Editor edit = prefs.edit();
				  	edit.putString("day1", wktdays[0]);
				  	edit.putString("day2", wktdays[1]);
				  	edit.putString("day3", wktdays[2]);
				  	edit.putBoolean("workoutInProgress", true);
				  	edit.commit();
				  
				  	
				  if(com.example.testing.Select_Workout.loseWeight == true){
					    Intent settingsScreen = new Intent(getApplicationContext(), Main_Menu_2.class);
					    startActivity(settingsScreen);
					    // set the calendar if the settings permit it
					    if (useCalendar){
						   calIntent.putExtra(Events._ID, eventID);
					       calIntent.putExtra(Events.TITLE, "Run Today"); 
				           calIntent.putExtra(Events.DESCRIPTION, "You are trying to lose weight.  Run a mile today.  Do it.");    
				           calIntent.putExtra(Events.ALL_DAY, 1); //Heres the all day event thing.  This can always be changed.
				           calIntent.putExtra(Events.VISIBLE, 1);
				           calIntent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT="+events+";WKST=SU;"+REPEATDAYS); 
				           startActivity(calIntent); 
					    }
					    // schedule the repeating alarm.  Need Ryan to show me what we talked about Friday at class. 
					    myAlarm.setRepeating(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis(), ADAY, pIntent); 
				  }
				  else if (com.example.testing.Select_Workout.gainMuscle == true){
					    Intent settingsScreen = new Intent(getApplicationContext(), Main_Menu_2.class);
					    startActivity(settingsScreen);
					    if(useCalendar){
					       calIntent.putExtra(Events._ID, eventID);
					       calIntent.putExtra(Events.TITLE, "Lift Weights Today"); 
				           calIntent.putExtra(Events.DESCRIPTION, "You are trying to beef up.  Life weights.  Do it.");    
				           calIntent.putExtra(Events.ALL_DAY, 1); //Heres the all day event thing.  This can always be changed.
				           calIntent.putExtra(Events.VISIBLE, 1);
				           calIntent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT="+events+";WKST=SU;"+REPEATDAYS);  
				           startActivity(calIntent);
					    }
					    myAlarm.setRepeating(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis(), ADAY, pIntent); // Alarm is set for start time of event
				  }
				  else if (com.example.testing.Select_Workout.both == true){
					    Intent settingsScreen = new Intent(getApplicationContext(), Main_Menu_2.class);
					    startActivity(settingsScreen);
					    if(useCalendar){
						   calIntent.putExtra(Events._ID, eventID);
					       calIntent.putExtra(Events.TITLE, "Special Run Today"); 
				           calIntent.putExtra(Events.DESCRIPTION, "You are trying to lose weight and gain muscl.  Run a mile today while curling small weights.  Do it.");    
				           calIntent.putExtra(Events.ALL_DAY, 1); 
				           calIntent.putExtra(Events.VISIBLE, 1);
				           calIntent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT="+events+";WKST=SU;"+REPEATDAYS);
				           startActivity(calIntent);
					    }
				        myAlarm.setRepeating(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis(), ADAY, pIntent); 
				  }
				  else{
					  //ERROR we should never get here without some type of workout being selected. 
				  }
				
				
				}
			  }

			  });

	}
	
	private void Toaster(int ErrorResId){
		Toast.makeText(this, ErrorResId, Toast.LENGTH_LONG).show();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_workout_days, menu);
        return true;
        
			}
    
}
