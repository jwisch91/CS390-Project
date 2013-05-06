package com.example.testing;
 

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
 

public class Login extends Activity {
	@Override
	public void onBackPressed() {
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
	}
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.login);
        
        TextView openPage = (TextView) findViewById(R.id.btnLogin);
        
        openPage.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				EditText nameText = (EditText)findViewById(R.id.Name);
		        String name = nameText.getText().toString();
		        EditText weightText = (EditText)findViewById(R.id.Weight);
		        String weight = weightText.getText().toString();
		        
				// Switching to Open Page
				Intent i = new Intent(getApplicationContext(), Main_Menu.class);
				
				if (name.length()>0 && weight.length()>0){
					
					String upperName = name.substring(0,1).toUpperCase() + name.substring(1);
					SharedPreferences prefs = getSharedPreferences("winFitPref", 0);
					Editor edit = prefs.edit();
					edit.putBoolean("firstTime", false);
					edit.putString("userName", upperName);
					edit.putString("userWeight", weight);
					edit.commit();
					
					startActivity(i);
				}
				else
					if (name.length()==0){
						nameText.setHint("ENTER A NAME");
						nameText.setHintTextColor(-65536);
					}
					if (weight.length()==0){
						weightText.setHint("ENTER A WEIGHT");
						weightText.setHintTextColor(-65536);
					}
			}
		});
    }
}