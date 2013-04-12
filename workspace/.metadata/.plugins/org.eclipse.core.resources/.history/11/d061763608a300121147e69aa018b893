package com.example.testing;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public class Initiator extends Activity {

	public static final String PREFS_NAME = "winFitPref";
	
	
	protected void onCreate(Bundle state){
       super.onCreate(state);

       // Restore preferences
       SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
       boolean firstTime = prefs.getBoolean("firstTime", true);
       Editor edit = prefs.edit();
       edit.commit();
       if (firstTime == true){
    	   Intent i = new Intent(getApplicationContext(), LoginActivity.class);
    	   startActivity(i);
       }
       if (firstTime == false){
    	   Intent i = new Intent(getApplicationContext(), Open_Page.class);
    	   startActivity(i);
       }
    }
}
