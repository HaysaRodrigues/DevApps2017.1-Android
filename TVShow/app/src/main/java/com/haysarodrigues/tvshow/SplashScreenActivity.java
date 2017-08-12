package com.haysarodrigues.tvshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by Haysa on 06/08/17.
 */

public class SplashScreenActivity extends Activity implements Runnable{


    int TIME_SPLASH = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, TIME_SPLASH);
    }

    @Override
    public void run() {

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}
