package com.example.testing;

import java.util.Calendar;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Select_Workout_Days extends Activity{
		private CheckBox mon, tues, wed, thurs, fri, sat, sun; //Variables for the checkboxes
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
		
		//Toast.makeText(this, "Preparing Alarms and Calendar...", Toast.LENGTH_LONG).show();
		
		// OK we're not using Intents for this
		final long calId=0;// necessary to ID the calendar.  we will always use the same one, so this is global
	    final int allDayBaby = 1; //Im not commenting this.
	    final ContentResolver cr = getContentResolver();
	    final ContentValues values = new ContentValues();
		
		

		Intent timerIntent = new Intent(this, AlarmBroadcastReceiver.class);
		final PendingIntent pIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0 , timerIntent, 0);
		final AlarmManager myAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);
		
		
		final Calendar objCalendar = Calendar.getInstance();
		
		objCalendar.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR)); 
		objCalendar.set(Calendar.MONTH, objCalendar.get(Calendar.MONTH));
		objCalendar.set(Calendar.WEEK_OF_MONTH, objCalendar.get(Calendar.WEEK_OF_MONTH)); //sets it up starting this week.  Gives users time to prepare
		objCalendar.set(Calendar.DAY_OF_WEEK, objCalendar.get(Calendar.DAY_OF_WEEK));
		objCalendar.set(Calendar.HOUR_OF_DAY, 21); //10 AM is when the all day reminder starts
		objCalendar.set(Calendar.MINUTE, 38);
		objCalendar.set(Calendar.SECOND, 0);
		objCalendar.set(Calendar.MILLISECOND, 0);
		
		
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
						//objCalendar.set(Calendar.DAY_OF_WEEK, 2); // Monday is the day we mess with here
					
							if(com.example.testing.Select_workout.loseWeight == true){
								// calendar stuff
							     values.put(Events.TITLE, "Run a mile!");
							     values.put(Events.DESCRIPTION, "Run a mile!");
							     values.put(Events.CALENDAR_ID, calId);
							    // values.put(Events.DTSTART, ); These three must be set for this to work.  Dumb dumb dumb dumb dumb.
							    // values.put(Events.EVENT_TIMEZONE, );
							    // values.put(Events.DURATION, "America/" );
							     values.put(Events.ALL_DAY, allDayBaby);
							     values.put(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;BYDAY=MO");
							     values.put(Events.STATUS, 0); // Tentative.  1 = Confirmed.
							    // values.put(Events.VISIBLE, 1); // no timing conflict allowed
							     
								//
								myAlarm.set(AlarmManager.RTC_WAKEUP, (objCalendar.getTimeInMillis()), pIntent); // Alarm is set for start time of event
							
							}
							
							else if (com.example.testing.Select_workout.gainMuscle == true){
								
								// calendar stuff
							     values.put(Events.TITLE, "Run a mile!");
							     values.put(Events.DESCRIPTION, "Run a mile!");
							     values.put(Events.CALENDAR_ID, calId);
							     values.put(Events.ALL_DAY, allDayBaby);
							     values.put(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;BYDAY=MO");
							     values.put(Events.STATUS, 0); // Tentative.  1 = Confirmed.
							//     values.put(Events.VISIBLE, 1); // no timing conflict allowed
								//
								myAlarm.set(AlarmManager.RTC_WAKEUP, (objCalendar.getTimeInMillis()), pIntent);	
								//Intent nextScreen = new Intent(getApplicationContext(), Third_Page.class);
						        //startActivity(thirdScreen);
							}
							
							else if (com.example.testing.Select_workout.both == true){
								// calendar stuff
								// calendar stuff
							     values.put(Events.TITLE, "Run a mile!");
							     values.put(Events.DESCRIPTION, "Run a mile!");
							     values.put(Events.CALENDAR_ID, calId);
							     values.put(Events.ALL_DAY, allDayBaby);
							     values.put(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;BYDAY=MO");
							     values.put(Events.STATUS, 0); // Tentative.  1 = Confirmed.
							   //  values.put(Events.VISIBLE, 1); // no timing conflict allowed
								//
								myAlarm.set(AlarmManager.RTC_WAKEUP, (objCalendar.getTimeInMillis()), pIntent);
							
							}
							// may need an else here in case none of them happen
				  }
					
					
					
					if (tues.isChecked()){
						objCalendar.set(Calendar.DAY_OF_WEEK, 3); // Monday is the day we mess with here
						
						if(com.example.testing.Select_workout.loseWeight == true){
							// calendar stuff
						     values.put(Events.TITLE, "Run a mile!");
						     values.put(Events.DESCRIPTION, "Run a mile!");
						     values.put(Events.CALENDAR_ID, calId);
						     values.put(Events.ALL_DAY, allDayBaby);
						     values.put(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;BYDAY=MO");
						     values.put(Events.STATUS, 0); // Tentative.  1 = Confirmed.
						  //   values.put(Events.VISIBLE, 1); // no timing conflict allowed
							//
							myAlarm.set(AlarmManager.RTC_WAKEUP, (objCalendar.getTimeInMillis()), pIntent); // Alarm is set for start time of event
						
						}
						
						else if (com.example.testing.Select_workout.gainMuscle == true){
							
							// calendar stuff
						     values.put(Events.TITLE, "Run a mile!");
						     values.put(Events.DESCRIPTION, "Run a mile!");
						     values.put(Events.CALENDAR_ID, calId);
						     values.put(Events.ALL_DAY, allDayBaby);
						     values.put(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;BYDAY=MO");
						     values.put(Events.STATUS, 0); // Tentative.  1 = Confirmed.
						//     values.put(Events.VISIBLE, 1); // no timing conflict allowed
							//
							myAlarm.set(AlarmManager.RTC_WAKEUP, (objCalendar.getTimeInMillis()), pIntent);	
						
						}
						
						else if (com.example.testing.Select_workout.both == true){
							// calendar stuff
							// calendar stuff
						     values.put(Events.TITLE, "Run a mile!");
						     values.put(Events.DESCRIPTION, "Run a mile!");
						     values.put(Events.CALENDAR_ID, calId);
						     values.put(Events.ALL_DAY, allDayBaby);
						     values.put(Events.RRULE, "FREQ=WEEKLY;COUNT=2;WKST=SU;BYDAY=MO");
						     values.put(Events.STATUS, 0); // Tentative.  1 = Confirmed.
						   //  values.put(Events.VISIBLE, 1); // no timing conflict allowed
							//
							myAlarm.set(AlarmManager.RTC_WAKEUP, (objCalendar.getTimeInMillis()), pIntent);
						
						}
						// may need an else here in case none of them happen
			  }
					/*
					if (wed.isChecked()){
						if(com.example.testing.Select_workout.loseWeight == true){
							
						}
					
						else if (com.example.testing.Select_workout.gainMuscle == true){
						
						}
					
						else if (com.example.testing.Select_workout.both == true){
						
						}
						else{
						//ERROR
						}
					}
					if (thurs.isChecked()){
						if(com.example.testing.Select_workout.loseWeight == true){
							
						}
					
						else if (com.example.testing.Select_workout.gainMuscle == true){
						
						}
					
						else if (com.example.testing.Select_workout.both == true){
						
						}
						else{
						//ERROR
						}
					}
					if (fri.isChecked()){
						if(com.example.testing.Select_workout.loseWeight == true){
							
						}
					
						else if (com.example.testing.Select_workout.gainMuscle == true){
						
						}
					
						else if (com.example.testing.Select_workout.both == true){
						
						}
						else{
						//ERROR
						}
					}
					if (sat.isChecked()){
						if(com.example.testing.Select_workout.loseWeight == true){
							
						}
					
						else if (com.example.testing.Select_workout.gainMuscle == true){
						
						}
					
						else if (com.example.testing.Select_workout.both == true){
						
						}
						else{
						//ERROR
						}
					}
					if (sun.isChecked()){
						if(com.example.testing.Select_workout.loseWeight == true){
							
						}
					
						else if (com.example.testing.Select_workout.gainMuscle == true){
						
						}
					
						else if (com.example.testing.Select_workout.both == true){
						
						}
						else{
						//ERROR
						} */
				
				cr.insert(Events.CONTENT_URI, values); // Actually load the values into the calendar through the content resolver.  This gives the error that made me put that thing about ICS above.
				//	Log.v("++++test", applyUri.toString());
					}
		 
			  });

		//	long useThisId = Long.parseLong(uri.getLastPathSegment()); // officially gives us the Id for this event.
		// we can then put other stuff for this event down here if we want it.  Otherwise, this is good as is. 
	}
		

		
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_workout_days, menu);
        return true;
        
			}
    
}
