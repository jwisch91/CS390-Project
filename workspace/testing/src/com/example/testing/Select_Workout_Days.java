package com.example.testing;

import java.util.Calendar;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
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
		private CheckBox mon, tues, wed, thurs, fri, sat, sun; //Variables for the checkboxes
	    private String REPEATDAYS= "BYDAY=";

	    private final long BETADAYDELAY = 8300;// The delay we want for beta day.  This should be 6 seconds or so.  
 
	    
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_workout_days);
        
        
        addListenerOnSubmit(); //Listener for what to do with the days selected
        
    }
	
	
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) // Ok this will only work with any version after Ice Cream Sandwich
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
		final int thisHour = objCalendar.get(Calendar.HOUR_OF_DAY);
		final int thisMinute = objCalendar.get(Calendar.MINUTE);
		final int thisSecond = objCalendar.get(Calendar.SECOND);
		
		objCalendar.set(Calendar.YEAR, thisYear); 
		objCalendar.set(Calendar.MONTH, thisMonth);
		objCalendar.set(Calendar.WEEK_OF_MONTH, thisWeek); 
		objCalendar.set(Calendar.DAY_OF_WEEK, today);
		objCalendar.set(Calendar.HOUR_OF_DAY, thisHour); 
		objCalendar.set(Calendar.MINUTE, thisMinute); 
		objCalendar.set(Calendar.SECOND, thisSecond);
		//objCalendar.set(Calendar.MILLISECOND, 0);
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			/*
			This is a little trippy.  Basically, you create an alarm intent based on the days you pick.  This alarm is a notification noise
			and it is set to go off on the day at 10AM for any checkbox that was selected.  When that broadcast is recieved, it now knows
			to put a notification with the alarm noise when it is received and hence we will have a notification with a noise pop up
			at these times.  This connects the notification and alarms intricately.  
			 */
			 
			  @Override
			  public void onClick(View v) {
		             
				  if (mon.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "MO";
					  	// probably have to set the alarm to know that it is suppose to go off on Mondays at 10AM here. Should also do Alarm.setRepeat(...)
				  }
				  if (tues.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "TU";
				  }
				  if (wed.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "WE";
				  }
				  if (thurs.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "TH";
				  }
				  if (fri.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "FR";
				  }
				  if (sat.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "SA";
				  }
				  if (sun.isChecked()){
					  	REPEATDAYS = REPEATDAYS + "SU";
				  }
				  
				  if(com.example.testing.Select_workout.loseWeight == true){
					    Intent settingsScreen = new Intent(getApplicationContext(), Main_Menu.class);
					    startActivity(settingsScreen);
					  calIntent.putExtra(Events.TITLE, "Run Today"); 
				        calIntent.putExtra(Events.DESCRIPTION, "You are trying to lose weight.  Run a mile today.  Do it.");    
				        calIntent.putExtra(Events.ALL_DAY, 1); //Heres the all day event thing.  This can always be changed.
				        calIntent.putExtra(Events.VISIBLE, 1);
				        calIntent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;" + REPEATDAYS); 
				        startActivity(calIntent); // for some reason we can't ge the calendar to pop up now.
						myAlarm.set(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis() + BETADAYDELAY, pIntent); // Alarm is set for start time of event
						
		
					  
				  }
				  else if (com.example.testing.Select_workout.gainMuscle == true){
					    Intent settingsScreen = new Intent(getApplicationContext(), Main_Menu.class);
					    startActivity(settingsScreen);
					  calIntent.putExtra(Events.TITLE, "Lift Weights Today"); 
				        calIntent.putExtra(Events.DESCRIPTION, "You are trying to beef up.  Life weights.  Do it.");    
				        calIntent.putExtra(Events.ALL_DAY, 1); //Heres the all day event thing.  This can always be changed.
				        calIntent.putExtra(Events.VISIBLE, 1);
				        calIntent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;" + REPEATDAYS); 
				        startActivity(calIntent);// for some reason we get an error b/c of the manifest with this right now.
						myAlarm.set(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis() + BETADAYDELAY, pIntent); // Alarm is set for start time of event
						
					  
				  }
				  else if (com.example.testing.Select_workout.both == true){
					    Intent settingsScreen = new Intent(getApplicationContext(), Main_Menu.class);
					    startActivity(settingsScreen);
					  calIntent.putExtra(Events.TITLE, "Special Run Today"); 
				        calIntent.putExtra(Events.DESCRIPTION, "You are trying to lose weight and gain muscl.  Run a mile today while curling small weights.  Do it.");    
				        calIntent.putExtra(Events.ALL_DAY, 1); //Heres the all day event thing.  This can always be changed.
				        calIntent.putExtra(Events.VISIBLE, 1);
				        calIntent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;" + REPEATDAYS); 
				        startActivity(calIntent);// for some reason we get an error b/c of the manifest with this right now.
						myAlarm.set(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis() + BETADAYDELAY, pIntent); // Alarm is set for start time of event
						
					  
				  }
				  else{
					  //ERROR we should never get here without some type of workout being selected. 
				  }
				
				
				}

			  });

	}
		

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_workout_days, menu);
        return true;
        
			}
    
}
