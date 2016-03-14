package com.example.q4573r.fishing4compliments;

/**
 * Created by Q0di on 3/12/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.q4573r.fishing4compliments.R.layout.splash_activity);

        final ImageView iv = (ImageView) findViewById(com.example.q4573r.fishing4compliments.R.id.splashIV);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), com.example.q4573r.fishing4compliments.R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), com.example.q4573r.fishing4compliments.R.anim.abc_fade_out);

        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();

                //Intent to change screens
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

          }

}