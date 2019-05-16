package com.tapp.dayfinder;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MonthDifference extends AppCompatActivity {

    public NumberPicker np1,np2,np3,np4,np5,np6;
    public String[] months;
    public int dif=0,mt=0,r=0;
    Button calculate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();


        setContentView(R.layout.daydifference);

//        dynamically changing the background and text color of the button. Since 3 classes (DayDifference, WeekDifference and MonthDifference)
//        are using the same layout file. The button color used to be same for the three. For making it different the below code is used.

        calculate = findViewById(R.id.day_diff_button);
        calculate.setBackgroundColor(getColor(R.color.colorPrimary));
        calculate.setTextColor(getColor(R.color.white));

        np1 =  findViewById(R.id.np1);
        np2 =  findViewById(R.id.np2);
        np3 =  findViewById(R.id.np3);
        np4 =  findViewById(R.id.np4);
        np5 =  findViewById(R.id.np5);
        np6 =  findViewById(R.id.np6);

        np1.setMinValue(1);
        np1.setMaxValue(31);
        np4.setMinValue(1);
        np4.setMaxValue(31);

        np3.setMinValue(1000);
        np3.setMaxValue(9999);
        np3.setValue(2017);
        np6.setMinValue(1000);
        np6.setMaxValue(9999);
        np6.setValue(2017);

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
        np5.setMaxValue(months.length-1);
        np5.setMinValue(0);
        np5.setDisplayedValues(months);
    }

    public void open()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(mt+" Months and "+ r +" Days").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void open1()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(mt + " Months").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void open2()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Invalid Entry!!!").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void onClick(View v)
    {
        if(v.getId()==R.id.day_diff_button)
        {
            int y1,m1,d1,y2,m2,d2;
            y1=np3.getValue();
            y2=np6.getValue();
            m1=np2.getValue();
            m2=np5.getValue();
            d1=np1.getValue();
            d2=np4.getValue();
            if((y1==y2)&&(m1==m2)&&(d2>d1))
            {
                dif=d2-d1;
                r=dif;
                open();
            }
            if((y1==y2)&&(m1!=m2)&&(m2>m1))
            {
                int rd1=0,rd2=0;
                if(m1==0||m1==2||m1==4||m1==6||m1==7||m1==9||m1==11)
                    rd1=31-d1;
                if((y1%4==0)&&(m1==1))
                    rd1=29-d1;
                if((y1%4!=0)&&(m1==1))
                    rd1=28-d1;
                if(m1==3||m1==5||m1==8||m1==10)
                    rd1=30-d1;

                rd2=d2-1;
                if((m2-m1)==0)
                {
                    dif=rd1+rd2;
                    mt=dif/30;
                    r=dif%30;
                    if(r==0)
                        open1();
                    else
                        open();
                }
                else
                {
                    int mid=0;
                    for(int i = m1+1;i<m2;i++)
                    {
                        mid++;
                    }
                    dif=mid+((rd2+rd1)/30);
                    mt=dif;
                    r=((rd2+rd1)%30);
                    if(r==0)
                        open1();
                    else
                        open();
                }


            }
            if(((y1==y2)&&(m1>m2))||(y1>y2)||((y1==y2)&&(m1==m2)&&(d1>d2)))
                open2();
            if((y1!=y2)&&(y1<y2))
            {
                int rd1=0,rd2=0;
                int mid=0;
                if(m1==0||m1==2||m1==4||m1==6||m1==7||m1==9||m1==11)
                    rd1=31-d1;
                if((y1%4==0)&&(m1==1))
                    rd1=29-d1;
                if((y1%4!=0)&&(m1==1))
                    rd1=28-d1;
                if(m1==3||m1==5||m1==8||m1==10)
                    rd1=30-d1;

                rd2=d2-1;


                for(int i = m1+1;i<=11;i++)
                {
                    mid++;
                }
                for(int j=y1+1;j<y2;j++)
                {

                    mid=mid+12;

                }
                for(int h=0;h<m2;h++)
                {
                    mid++;
                }
                dif=mid+((rd2+rd1)/30);
                mt=dif;
                r=((rd2+rd1)%30);
                if(r==0)
                    open1();
                else
                    open();
            }

        }
    }


}

