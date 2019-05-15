package com.tapp.dayfinder;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity {

    Button imageButton1, imageButton2, imageButton3, imageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();
        }

        setContentView(R.layout.home);
        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
    }
    public void onClick(View v)
    {
         if(v.getId()==R.id.imageButton1)
         {
             Intent dayIntent = new Intent(Home.this,DayCalculator.class);
             startActivity(dayIntent);
         }

        if(v.getId()==R.id.imageButton2)
        {
            Intent daydifferenceIntent = new Intent(Home.this,DayDifference.class);
            startActivity(daydifferenceIntent);
        }

        if(v.getId()==R.id.imageButton3)
        {
            Intent weekdifferenceIntent = new Intent(Home.this,WeekDifference.class);
            startActivity(weekdifferenceIntent);
        }

        if(v.getId()==R.id.imageButton4)
        {
            Intent monthdifferenceIntent = new Intent(Home.this,MonthDifference.class);
            startActivity(monthdifferenceIntent);
        }
    }

    }