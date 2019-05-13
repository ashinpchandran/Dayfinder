package com.tapp.dayfinder;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class DayCalculator extends AppCompatActivity {


    public TextView dayt;
    public NumberPicker np1,np2,np3;
    public String[] months;
    public String[] weekdays;
    public int[] days;
    public int[] calc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getSupportActionBar().hide();
        }

        setContentView(R.layout.daycalculator);

        dayt = (TextView) findViewById(R.id.textView2);

        np1 = (NumberPicker) findViewById(R.id.np1);
        np2 = (NumberPicker) findViewById(R.id.np2);
        np3 = (NumberPicker) findViewById(R.id.np3);

        np1.setMinValue(1);
        np1.setMaxValue(31);

        np3.setMinValue(1000);
        np3.setMaxValue(9999);
        np3.setValue(2019);

        String[] months = new String[12];
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10]= "November";
        months[11]= "December";

        np2.setMaxValue(months.length-1);
        np2.setMinValue(0);
        np2.setDisplayedValues(months);


    }

    public void onClick(View v)
    {
        if(v.getId()==R.id.day_calc_button)
        {
            int day, year,t,j=0,a,b=0,c,e=0,w;
            int mon;
            int[] calc = new int[3];
            int[] days = new int[12];
            days[0] = 6;
            days[1] = 2;
            days[2] = 2;
            days[3] = 5;
            days[4] = 0;
            days[5] = 3;
            days[6] = 5;
            days[7] = 1;
            days[8] = 4;
            days[9] = 6;
            days[10] =2;
            days[11] =4;
            day = np1.getValue();
            year = np3.getValue();
            mon = np2.getValue();
            calc[0] = (((year/100)/4)*4)*100;
            calc[1] = ((year-calc[0])/100)*100;
            calc[2] = year-(calc[0]+calc[1]);


            String[] weekdays = new String[7];
            weekdays[0] = "Sunday";
            weekdays[1] = "Monday";
            weekdays[2] = "Tuesday";
            weekdays[3] = "Wednesday";
            weekdays[4] = "Thursday";
            weekdays[5] = "Friday";
            weekdays[6] = "Saturday";
            switch(mon)
            {
                case 0:
                    b = days[0];
                    break;
                case 1:
                    b = days[1];
                    break;
                case 2:
                    b = days[2];
                    break;
                case 3:
                    b = days[3];
                    break;
                case 4:
                    b = days[4];
                    break;
                case 5:
                    b = days[5];
                    break;
                case 6:
                    b = days[6];
                    break;
                case 7:
                    b = days[7];
                    break;
                case 8:
                    b = days[8];
                    break;
                case 9:
                    b = days[9];
                    break;
                case 10:
                    b = days[10];
                    break;
                case 11:
                    b = days[11];
                    break;

            }
            if(calc[1]==100)
                e=5;
            if(calc[1]==200)
                e=3;
            if(calc[1]==300)
                e=1;
            t=calc[2]/4;
            a=(t%7)+calc[2];
            a=a+e;
            c=day%7;
            j=a+b+c;
            w=j%7;
            dayt.setText("The day is " + weekdays[w]);
        }
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

}


