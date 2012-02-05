package hut.financesaver;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinanceSaverActivity extends Activity {

	private static final int ID_NT_BTNCLICKED = 1;
	protected TextView txtMessage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        
        txtMessage = (TextView) findViewById(R.id.txt_message);
        Button btnNotify = (Button) findViewById(R.id.btnNotify);
        
        
        
        btnNotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	/* show locale in txtMessage */
    			String locale = getApplicationContext().getResources().getConfiguration().locale.getDisplayName();
    			txtMessage.setText(locale);
    			
    			/* notify that button was clicked */
    			int icon = R.drawable.notification_icon;        // icon from resources
    	        CharSequence tickerText = getResources().getText(R.string.first_notification_ticker);
    	        Context context = getApplicationContext();      // application Context
    	        CharSequence contentTitle = getResources().getText(R.string.first_notification_title);
    	        CharSequence contentText = getResources().getText(R.string.first_notification_text);

    	        Intent notificationIntent = new Intent(context, FinanceSaverActivity.class);      
    	        
    			long when = System.currentTimeMillis();
    			
    	        Notification notification = new Notification(icon, tickerText, when);
    	        
    	        notification.defaults |= Notification.DEFAULT_ALL;
    	        notification.flags |= Notification.FLAG_AUTO_CANCEL;
    	        
    	        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
    	        
    	        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
    	        
    	        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);
    	        mNotificationManager.notify(ID_NT_BTNCLICKED, notification);
            }
        });
        
              
    }

}