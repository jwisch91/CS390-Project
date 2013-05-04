package com.example.testing;

import android.app.NotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/*
 * Anytime the repeat alarm intends to go off, all of this code runs.  This is how I get the 
 * notifications and noises to play together.  It is seperate from the calendar.  If we want
 * to try to change this to only go off on the days you are supposed to workout, a little more
 * research and work will need to be done.  
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {
	int notifyID = 0; // A required notification parameter.
	long[] vpattern = new long[4];{
	vpattern[0] = 300;
	vpattern[1] = 300;
	vpattern[2] = 300;
	vpattern[3] = 800; }
	@Override
	public void onReceive(Context context, Intent intent) { 
		Intent openIntent = new Intent(context, View_Workout.class);
		PendingIntent openAPP = PendingIntent.getActivity(context, 0, openIntent,0);
		// If we were to make multiple notifications, notifyID can be incremented and we would have unique IDs.  Remeber: this stuff only
		// happens when the intent is received.  The intent is only received at the time specified by objCalendar (from Select_Workout_Days.java)
		
	    // Set the Uri and get a noise for the .setSound method when creating the notification. 
		Uri notifyNoise = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
			// start notification make
		if (com.example.testing.Settings.notification =  true){
			NotificationCompat.Builder notificationBuild =
			        new NotificationCompat.Builder(context)
			        .setSmallIcon(R.drawable.icon)
			        .setContentTitle("You have a workout!")
			        .setContentText("Click to enter WinFit and view the details.")
			        .setAutoCancel(true)
					.setLights(-16776961/*blue*/, 250, 350)
					.setSound(notifyNoise)
					.setVibrate(vpattern)
					.setContentIntent(openAPP);
			NotificationManager notifyUser = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			// end notification make
			notifyUser.notify(notifyID, notificationBuild.build()); // Builds and displays notification
		}
		
	}

}
