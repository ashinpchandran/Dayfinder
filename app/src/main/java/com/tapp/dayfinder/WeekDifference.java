package com.tapp.dayfinder;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;

public class WeekDifference extends AppCompatActivity {

    public NumberPicker number_picker_day_start,number_picker_month_start,number_picker_year_start,number_picker_day_end,number_picker_month_end,number_picker_year_end;
    public int dif=0,w=0,r=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            assert getSupportActionBar() != null;
            getSupportActionBar().hide();


        setContentView(R.layout.daydifference);


        number_picker_day_start =  findViewById(R.id.number_picker_day_start);
        number_picker_month_start =  findViewById(R.id.number_picker_month_start);
        number_picker_year_start =  findViewById(R.id.number_picker_year_start);
        number_picker_day_end =  findViewById(R.id.number_picker_day_end);
        number_picker_month_end =  findViewById(R.id.number_picker_month_end);
        number_picker_year_end =  findViewById(R.id.number_picker_year_end);

        number_picker_day_start.setMinValue(1);
        number_picker_day_start.setMaxValue(31);
        number_picker_day_end.setMinValue(1);
        number_picker_day_end.setMaxValue(31);

        number_picker_year_start.setMinValue(1000);
        number_picker_year_start.setMaxValue(9999);
        number_picker_year_start.setValue(2017);
        number_picker_year_end.setMinValue(1000);
        number_picker_year_end.setMaxValue(9999);
        number_picker_year_end.setValue(2019);


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


        number_picker_month_start.setMaxValue(months.length-1);
        number_picker_month_start.setMinValue(0);
        number_picker_month_start.setDisplayedValues(months);
        number_picker_month_end.setMaxValue(months.length-1);
        number_picker_month_end.setMinValue(0);
        number_picker_month_end.setDisplayedValues(months);



    }

    public void open()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(w+" Weeks and "+ r +" Days").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

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
        alertDialogBuilder.setTitle(w + " Weeks").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

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
            y1=number_picker_year_start.getValue();
            y2=number_picker_year_end.getValue();
            m1=number_picker_month_start.getValue();
            m2=number_picker_month_end.getValue();
            d1=number_picker_day_start.getValue();
            d2=number_picker_day_end.getValue();
            if((y1==y2)&&(m1==m2)&&(d2>d1))
            {
                dif=d2-d1;
                w=dif/7;
                r=dif%7;
                if(r==0)
                    open1();
                else
                    open();
            }
            if((y1==y2)&&(m2>m1))
            {
                int rd1=0,rd2;
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
                    w=dif/7;
                    r=dif%7;
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
                        if(i==0||i==2||i==4||i==6||i==7||i==9||i==11)
                            mid=mid+31;
                        if(i==3||i==5||i==8||i==10)
                            mid=mid+30;
                        if(i==1)
                        {
                            if(y1%4==0)
                                mid=mid+29;
                            else
                                mid=mid+28;
                        }
                    }
                    dif=rd1+mid+rd2;
                    w=dif/7;
                    r=dif%7;
                    if(r==0)
                        open1();
                    else
                        open();
                }


            }
            if(((y1==y2)&&(m1>m2))||(y1>y2)||((y1==y2)&&(m1==m2)&&(d1>d2)))
                open2();
            if((y1<y2))
            {
                int rd1=0,rd2;
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
                    if(i==0||i==2||i==4||i==6||i==7||i==9||i==11)
                        mid=mid+31;
                    if(i==3||i==5||i==8||i==10)
                        mid=mid+30;
                    if(i==1)
                    {
                        if(y1%4==0)
                            mid=mid+29;
                        else
                            mid=mid+28;
                    }
                }
                for(int j=y1+1;j<y2;j++)
                {

                    if(j%4==0)
                        mid=mid+366;
                    else
                        mid=mid+365;

                }
                for(int h=0;h<m2;h++)
                {
                    if(h==0||h==2||h==4||h==6||h==7||h==9||h==11)
                        mid=mid+31;
                    if(h==3||h==5||h==8||h==10)
                        mid=mid+30;
                    if(h==1)
                    {
                        if(y1%4==0)
                            mid=mid+29;
                        else
                            mid=mid+28;
                    }
                }
                dif=rd1+mid+rd2;
                w=dif/7;
                r=dif%7;
                if(r==0)
                    open1();
                else
                    open();
            }

        }
    }


}

