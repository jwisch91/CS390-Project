package com.example.testing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.preference.*;
import android.provider.CalendarContract.Events;
import android.widget.TextView;


@SuppressLint("NewApi")
public class Settings extends Activity{
	
	public static final String PREFS_NAME = "winFitPref";
	public boolean measure;
	public boolean grain;
	public static boolean calendar;
	public static boolean notification;
	
	public Dialog reregisterDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to reregister?")
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	    SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
       	      	    	Editor edit = prefs.edit();  
       	      	    	edit.putBoolean("firstTime", true);
       	      	    	edit.commit();
       	      	    	Intent nextScreen = new Intent(getApplicationContext(), Initiator.class);
       	      	    	startActivity(nextScreen);
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
	}
	
	public Dialog clearWorkoutDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to clear your workout?")
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
                	   Editor edit = prefs.edit();  
                	   edit.putBoolean("workoutInProgress", false);
                	   edit.commit();
                	   Intent nextScreen = new Intent(getApplicationContext(), Initiator.class);
                	   startActivity(nextScreen);
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
	}

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Intent i = getIntent();
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        
        RadioButton btnEnglish = (RadioButton)findViewById(R.id.radioEnglish);
        RadioButton btnMetric = (RadioButton)findViewById(R.id.radioMetric);
        RadioButton btnFine = (RadioButton)findViewById(R.id.radioFineGrain);
        RadioButton btnCoarse = (RadioButton)findViewById(R.id.radioCoarseGrain);
        CheckBox boxCalendar = (CheckBox)findViewById(R.id.UseCalendar);
        CheckBox boxNotification = (CheckBox)findViewById(R.id.UseNotification);
        
        
        
        final Button btnReRegister = (Button)findViewById(R.id.Reregister);
        btnReRegister.setOnClickListener(new Button.OnClickListener(){

        	@Override
        	public void onClick(View arg0) {
        		Dialog confirm = reregisterDialog(null);
    			confirm.show();
        	}
        });
        
        final Button btnClearWorkout = (Button)findViewById(R.id.Clear_Workout);
        btnClearWorkout.setOnClickListener(new Button.OnClickListener(){

        	@Override
        	public void onClick(View arg0) {
        		Dialog confirm = clearWorkoutDialog(null);
    			confirm.show();
        	}
        });
        
       
        measure = prefs.getBoolean("English", true);
        grain = prefs.getBoolean("Grain", true);
        calendar = prefs.getBoolean("Use Calendar", true);
        notification = prefs.getBoolean("Use Notification", true);
        
        if (measure)
        	btnEnglish.setChecked(true);
        else
        	btnMetric.setChecked(true);
        
        if (grain)
        	btnFine.setChecked(true);
        else
        	btnCoarse.setChecked(true);

        if (calendar)
        	boxCalendar.setChecked(true);
        if (notification)
        	boxNotification.setChecked(true);
        
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

public void onAnnounceChecked(View view) {
    // Is the button now checked?
    boolean checked = ((CheckBox) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.UseCalendar:
        	if (checked)
        		calendar = true;
        	else
            	calendar = false;
        	break;
        case R.id.UseNotification:
            if (checked)
            	notification = true;
            else
            	notification = false;
            break;        		
	    }
	}



protected void onStop() {
    super.onStop();  // Always call the superclass method first

    // Save the settings preferences
    SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
    Editor edit = prefs.edit();   
    edit.putBoolean("English", measure);
    edit.putBoolean("Grain", grain);
    edit.putBoolean("Use Calendar", calendar);
    edit.putBoolean("Use Notification", notification);
    edit.commit();

	}
}