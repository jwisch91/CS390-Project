package com.example.testing;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.preference.*;


public class Second_Page extends Activity{
	
//    SharedPreferences prefs = getSharedPreferences("winFitPref", 0);
//    Editor edit = prefs.edit();
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        Intent i = getIntent();
        
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
            if (checked){
//                edit.putBoolean("English", true);
//            	edit.commit();
            break;
            }
        case R.id.radioMetric:
            if (checked){
//                edit.putBoolean("English", false);
//            	edit.commit();}
            break;
            }
	    }
	}

public void onRadioGrainClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.radioFineGrain:
            if (checked)
//            	edit.putBoolean("Fine Grain", true);
            break;
        case R.id.radioCoarseGrain:
            if (checked)
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
/**            	edit.putBoolean("Use Alarm", true);
            	edit.putBoolean("Use Notification", false);*/
            }
            break;
        case R.id.UseNotification:
            if (checked){
/**            	edit.putBoolean("Use Alarm", false);
            	edit.putBoolean("Use Notification", true);	*/
            }
            break;
        case R.id.UseBothNotes:
        	if (checked){
/**            	edit.putBoolean("Use Alarm", true);
            	edit.putBoolean("Use Notification", true);	*/
        	}
        		
	    }
	}
}