package com.tapp.dayfinder;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);
        Thread logotimer = new Thread(){
            public void run(){

                try
                {
                    sleep(4000);
                    Intent HomeIntent = new Intent("android.intent.action.HOME");
                    startActivity(HomeIntent);
                }
                catch (InterruptedException e) {

                    e.printStackTrace();
                }

                finally
                {
                    finish();
                }
            }
        };
        logotimer.start();

    }

    @Override
    protected void onPause() {

        super.onPause();

    }



}
