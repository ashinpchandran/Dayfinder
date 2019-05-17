package com.tapp.dayfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class DayCalculator extends AppCompatActivity {


    public TextView day_display_text_view;
    public NumberPicker number_picker_day,number_picker_month,number_picker_year;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();


        setContentView(R.layout.daycalculator);

        day_display_text_view =  findViewById(R.id.textView2);

        number_picker_day =  findViewById(R.id.number_picker_day);
        number_picker_month =  findViewById(R.id.number_picker_month);
        number_picker_year =  findViewById(R.id.number_picker_year);

        //Minimum and maximum values for the day selecting number picker.
        number_picker_day.setMinValue(1);
        number_picker_day.setMaxValue(31);

        //Minimum and maximum values for the year selecting number picker.
        number_picker_year.setMinValue(1000);
        number_picker_year.setMaxValue(9999);
        number_picker_year.setValue(2019);

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

        //Minimum and maximum values for the month selecting number picker.
        number_picker_month.setMaxValue(months.length-1);
        number_picker_month.setMinValue(0);
        number_picker_month.setDisplayedValues(months);


    }

    public void onClick(View v)
    {
        if(v.getId()==R.id.day_calc_button)
        {
            int day, year,t,j=0,a,b=0,c,e=0,w;
            int mon;
            int[] calc = new int[3];
            int[] days = new int[12];

            //Array of key values corresponding to the months
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

            //fetching the inputs from the number pickers to the variables.
            day = number_picker_day.getValue();
            year = number_picker_year.getValue();
            mon = number_picker_month.getValue();


            //if input year is 2019, then calc[0] will hold 2000
            calc[0] = (((year/100)/4)*4)*100;

            //if input year is 2019, then calc[1] will hold 0
            calc[1] = ((year-calc[0])/100)*100;

            //if input year is 2019, then calc[2] will hold 19
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

            //19/4=4
            t=calc[2]/4;

            a=(t%7)+calc[2];
            a=a+e;
            c=day%7;
            j=a+b+c;
            w=j%7;

            int display_month = mon + 1;
            day_display_text_view.setText(day + "/" + display_month + "/" + year + " is " + weekdays[w]);
        }
    }
    @Override
    protected void onPause() {

        super.onPause();
    }

}


