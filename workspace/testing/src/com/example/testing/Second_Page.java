package com.example.testing;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.preference.*;


public class Second_Page extends Activity{
	
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
            if (checked)
                // Pirates are the best
            break;
        case R.id.radioMetric:
            if (checked)
                // Ninjas rule
            break;
	    }
	}

public void onRadioGrainClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.radioEnglish:
            if (checked)
                // Pirates are the best
            break;
        case R.id.radioMetric:
            if (checked)
                // Ninjas rule
            break;
	    }
	}

public void onRadioNotifyClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.UseAlarm:
            if (checked)
                // Pirates are the best
            break;
        case R.id.UseNotification:
            if (checked)
                // Ninjas rule
            break;
	    }
	}


public void onRadioAlarmClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();
    
    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.UseAlarm:
            if (checked)
                // Pirates are the best
            break;
        case R.id.UseNotification:
            if (checked)
                // Ninjas rule
            break;
	    }
	}


}