package com.example.q4573r.fishing4compliments;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Button getComplimentBTN;
    private TextView complimentTV;
    ComplimentsDatabase complimentsDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.q4573r.fishing4compliments.R.layout.activity_main);

        getComplimentBTN = (Button) findViewById(R.id.getComplimentBTN);
        complimentTV = (TextView) findViewById(R.id.complimentTV);

        complimentsDatabase = new ComplimentsDatabase(this,null,null,1);

        //fill table with lovely sentiments
        complimentsDatabase.addCompliment(new Compliment("Your smile is contagious"));
        complimentsDatabase.addCompliment(new Compliment("You look great today"));
        complimentsDatabase.addCompliment(new Compliment("You should be proud of yourself."));
        complimentsDatabase.addCompliment(new Compliment("You're more helpful than you realize"));
        complimentsDatabase.addCompliment(new Compliment("Your eyes are breath taking"));
        complimentsDatabase.addCompliment(new Compliment("If cartoon bluebirds were real, a bunch of them would be sitting on your shoulders singing right now"));
        complimentsDatabase.addCompliment(new Compliment("How is it that you always look great, even in sweatpants?"));
        complimentsDatabase.addCompliment(new Compliment("Hanging out with you is always a blast"));
        complimentsDatabase.addCompliment(new Compliment("You smell really good"));
        complimentsDatabase.addCompliment(new Compliment("Being around you makes everything better"));
        complimentsDatabase.addCompliment(new Compliment("That thing you don't like about yourself is what makes you so interesting."));
        complimentsDatabase.addCompliment(new Compliment("You're wonderful."));
        complimentsDatabase.addCompliment(new Compliment("You're better than a triple-scoop ice cream cone. With sprinkles."));
        complimentsDatabase.addCompliment(new Compliment("Your hair looks stunning"));
        complimentsDatabase.addCompliment(new Compliment("You're inspiring"));
        complimentsDatabase.addCompliment(new Compliment("You're one of a kind!"));
        complimentsDatabase.addCompliment(new Compliment("If you were a box of crayons, you'd be the giant name-brand one with the built-in sharpener"));
        complimentsDatabase.addCompliment(new Compliment("Our community is better because you're in it"));
        complimentsDatabase.addCompliment(new Compliment("You have the best ideas"));
        complimentsDatabase.addCompliment(new Compliment("You always know how to find that silver lining"));
        complimentsDatabase.addCompliment(new Compliment("You're always learning new things and trying to better yourself, which is awesome."));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflates and adds options to action bar
        getMenuInflater().inflate(com.example.q4573r.fishing4compliments.R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //handle actionbar clicks here
        int id = item.getItemId();

        //noinspection simplifiableIfStatement
        if(id == com.example.q4573r.fishing4compliments.R.id.aboutOption){
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);

            //notification
            Intent intent = new Intent();
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
            Notification noti = new Notification.Builder(this)
                    .setTicker("Fishing 4 Compliments")
                    .setContentTitle("Fishing 4 Compliments")
                    .setContentText("You're brighter than the sun.")
                    .setSmallIcon(com.example.q4573r.fishing4compliments.R.drawable.sun)
                    .setContentIntent(pIntent).getNotification();
            noti.flags=Notification.FLAG_AUTO_CANCEL;
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0, noti);
        }else{
            //add compliment activity
            Intent i = new Intent(MainActivity.this, AddComplimentActivity.class);
            startActivity(i);
        }


            return  super.onOptionsItemSelected(item);
    }


    public void showCompliment(View view){
        complimentTV.setText(complimentsDatabase.grabRandomCompliment());

    }




}
