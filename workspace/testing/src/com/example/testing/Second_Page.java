package com.example.testing;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
//import android.preference.*;
import android.widget.TextView;


public class Second_Page extends Activity{
	
	public static final String PREFS_NAME = "winFitPref";
	public boolean measure;
	public boolean grain;
	public boolean alarm;
	public boolean notification;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        Intent i = getIntent();
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        
        measure = prefs.getBoolean("English", true);
        grain = prefs.getBoolean("Grain", true);
        alarm = prefs.getBoolean("Use Alarm", false);
        notification = prefs.getBoolean("Use Notification", true);
        
        TextView Debug = (TextView)findViewById(R.id.Debug);
	    Debug.setText(measure + ", " + grain + ", " + alarm + ", " + notification);
        
//        Editor edit = prefs.edit();
//        edit.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second_page, menu);
        return true;
			}
	

public void onRadioMeasureClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.radioEnglish:
            if (checked)
            	measure = true;
//                edit.putBoolean("English", true);
//            	edit.commit();
            break;
            
        case R.id.radioMetric:
            if (checked)
            	measure = false;
//                edit.putBoolean("English", false);
//            	edit.commit();}
            break;
            
	    }
	}

public void onRadioGrainClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.radioFineGrain:
            if (checked)
            	grain = true;
//            	edit.putBoolean("Fine Grain", true);
            break;
        case R.id.radioCoarseGrain:
            if (checked)
            	grain = false;
//            	edit.putBoolean("Fine Grain", false);
            break;
	    }
	}

public void onRadioAnnounceClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.UseAlarm:
            if (checked){
            	alarm = true;
            	notification = false;
//            	edit.putBoolean("Use Alarm", true);
//            	edit.putBoolean("Use Notification", false);
            }
            break;
        case R.id.UseNotification:
            if (checked){
            	alarm = false;
            	notification = true;
//            	edit.putBoolean("Use Alarm", false);
//            	edit.putBoolean("Use Notification", true);
            }
            break;
        case R.id.UseBothNotes:
        	if (checked){
        		alarm = true;
        		notification = true;
//            	edit.putBoolean("Use Alarm", true);
//            	edit.putBoolean("Use Notification", true);
        	}
        		
	    }
	}

protected void onStop() {
    super.onStop();  // Always call the superclass method first

    // Save the settings preferences
    SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
    Editor edit = prefs.edit();   
    edit.putBoolean("English", measure);
    edit.putBoolean("Grain", grain);
    edit.putBoolean("Use Alarm", alarm);
    edit.putBoolean("Use Notification", notification);
    edit.commit();

}
}