package com.tapp.dayfinder;

import android.content.Intent;
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

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();


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
            Intent day_difference_Intent = new Intent(Home.this,DayDifference.class);
            startActivity(day_difference_Intent);
        }

        if(v.getId()==R.id.imageButton3)
        {
            Intent week_difference_Intent = new Intent(Home.this,WeekDifference.class);
            startActivity(week_difference_Intent);
        }

        if(v.getId()==R.id.imageButton4)
        {
            Intent month_difference_Intent = new Intent(Home.this,MonthDifference.class);
            startActivity(month_difference_Intent);
        }
    }

    }