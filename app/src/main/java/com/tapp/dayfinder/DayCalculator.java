package com.tapp.dayfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;



public class DayCalculator extends AppCompatActivity {

    Current_Date_Finder CDF = new Current_Date_Finder();
    public TextView day_display_text_view;
    public NumberPicker number_picker_day,number_picker_month,number_picker_year;
    public int cur_year_int;
    public int cur_day_int;
    public int cur_month_index;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();


        setContentView(R.layout.daycalculator);

        day_display_text_view =  findViewById(R.id.textView2);


        //FETCHING CURRENT YEAR,MONTH AND DAY
        cur_year_int = CDF.current_year();
        cur_day_int = CDF.current_day();
        cur_month_index = CDF.current_month();

//        Log.i("cur_day==>", Integer.toString(cur_day_int));
//        Log.i("cur_month_index==>", Integer.toString(cur_month_index));
//        Log.i("cur_year==>", Integer.toString(cur_year_int));


        number_picker_day =  findViewById(R.id.number_picker_day);
        number_picker_month =  findViewById(R.id.number_picker_month);
        number_picker_year =  findViewById(R.id.number_picker_year);

        //Minimum and maximum values for the day selecting number picker.
        number_picker_day.setMinValue(1);
        number_picker_day.setMaxValue(31);
        number_picker_day.setValue(cur_day_int);

        //Minimum and maximum values for the year selecting number picker.
        number_picker_year.setMinValue(1000);
        number_picker_year.setMaxValue(9999);
        number_picker_year.setValue(cur_year_int);

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
        number_picker_month.setValue(cur_month_index);


    }

    public void onClick(View v)
    {
        if(v.getId()==R.id.day_calc_button)
        {
            int day, year,t,j,a,b=0,c,e=0,w;
            int month;
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

            //fetching the inputs from the number pickers to the variables. Assume input is 14 august 1994
            //day=14
            //year=1994
            //month=7
            day = number_picker_day.getValue();
            year = number_picker_year.getValue();
            month = number_picker_month.getValue();

            //checking for invalid entry
           if (CDF.february_29(day,month,year))

               day_display_text_view.setText("Invalid Entry!!!");

           else {


               //Since year is 1994, calc[0] will hold 1600
               calc[0] = (((year / 100) / 4) * 4) * 100;


               //if input year is 2019, then calc[1] will hold 300
               calc[1] = ((year - calc[0]) / 100) * 100;


               //if input year is 2019, then calc[2] will hold 94
               calc[2] = year - (calc[0] + calc[1]);


               String[] weekdays = new String[7];
               weekdays[0] = "Sunday";
               weekdays[1] = "Monday";
               weekdays[2] = "Tuesday";
               weekdays[3] = "Wednesday";
               weekdays[4] = "Thursday";
               weekdays[5] = "Friday";
               weekdays[6] = "Saturday";

               //Since month is august then value of month will be 7 and then the b = days[7] = 1
               switch (month) {
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

               //calc[1] is 300 and so e = 1
               if (calc[1] == 100)
                   e = 5;
               if (calc[1] == 200)
                   e = 3;
               if (calc[1] == 300)
                   e = 1;


               // calc[2] = 94 so t= 94/4 = 23
               t = calc[2] / 4;


               // a= (23%7) + 94 = 96
               a = (t % 7) + calc[2];


               //a= 96 + 1 = 97
               a = a + e;


               //if day = 14 then c = 14%7 = 0
               c = day % 7;

               //j = 97+1+0= 98
               j = a + b + c;


               //w=98%7=0
               w = j % 7;


               int display_month = month + 1;
               String display_string;

               if (year == cur_year_int && month == cur_month_index && day == cur_day_int) {
                   display_string = day + "/" + display_month + "/" + year + " is " + weekdays[w];
               } else {
                   if (year > cur_year_int) {
                       display_string = day + "/" + display_month + "/" + year + " will be " + weekdays[w];
                   } else {
                       if (year == cur_year_int) {
                           if (month > cur_month_index) {
                               display_string = day + "/" + display_month + "/" + year + " will be " + weekdays[w];
                           } else {
                               if (month == cur_month_index) {
                                   if (day > cur_day_int) {
                                       display_string = day + "/" + display_month + "/" + year + " will be " + weekdays[w];
                                   } else {
                                       display_string = day + "/" + display_month + "/" + year + " was " + weekdays[w];
                                   }
                               } else {
                                   display_string = day + "/" + display_month + "/" + year + " was " + weekdays[w];
                               }
                           }
                       } else {
                           display_string = day + "/" + display_month + "/" + year + " was " + weekdays[w];
                       }
                   }
               }
               day_display_text_view.setText(display_string);
           }
        }
    }
    @Override
    protected void onPause() {

        super.onPause();
    }

}


