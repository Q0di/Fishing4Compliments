package com.example.q4573r.fishing4compliments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.MenuItem;
/**
 * Created by Q0di on 3/13/2016.
 */
public class AddComplimentActivity extends AppCompatActivity{

    private EditText addComplimentET;
    private Button addComplimentBTN;
    ComplimentsDatabase dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_compliment_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        addComplimentET = (EditText) findViewById(R.id.addComplimentET);
        addComplimentBTN = (Button) findViewById(R.id.addComplimentBTN);

        dbHandler = new ComplimentsDatabase(this,null,null,1);

    }


    public void addCompliment(View view) {
        Compliment compliment = new Compliment(addComplimentET.getText().toString());
        dbHandler.addCompliment(compliment);

        //show compliment that was added
        Toast.makeText(getBaseContext(),compliment.toString(),Toast.LENGTH_LONG);

        //notifies that the data was added
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification noti = new Notification.Builder(this)
                .setTicker("Fishing 4 Compliments")
                .setContentTitle("Wanted to Tell You")
                .setContentText("Your compliment was added to the database.")
                .setSmallIcon(com.example.q4573r.fishing4compliments.R.drawable.ic_launcher)
                .setContentIntent(pIntent).getNotification();
        noti.flags=Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);



    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

}
