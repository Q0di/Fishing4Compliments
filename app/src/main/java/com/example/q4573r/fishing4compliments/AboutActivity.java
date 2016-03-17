package com.example.q4573r.fishing4compliments;

/**
 * Created by Q0di on 3/12/2016.
 */
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class AboutActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //grabs about UI
        setContentView(com.example.q4573r.fishing4compliments.R.layout.about);
        //shows back arrow at top of activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        //grab id of menu item
        switch (menuItem.getItemId())
        {
            case android.R.id.home:
                //go to home pag when arrow is clicked
                onBackPressed();
                break;

            default:
                //otherwise
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }



}