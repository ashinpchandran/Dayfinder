package com.tapp.dayfinder;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    ImageButton imageButton1, imageButton2, imageButton3, imageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
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
            Toast.makeText(this,
                    "ImageButton2 is clicked!", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.imageButton3)
        {
            Toast.makeText(this,
                    "ImageButton3 is clicked!", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.imageButton4)
        {
            Toast.makeText(this,
                    "ImageButton4 is clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    }