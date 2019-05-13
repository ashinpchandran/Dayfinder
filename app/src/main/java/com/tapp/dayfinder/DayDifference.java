package com.tapp.dayfinder;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;

public class DayDifference extends AppCompatActivity {

    public NumberPicker np1,np2,np3,np4,np5,np6;
    public String[] months;
    public int dif=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getSupportActionBar().hide();
        }

        setContentView(R.layout.daydifference);

        np1 = (NumberPicker) findViewById(R.id.np1);
        np2 = (NumberPicker) findViewById(R.id.np2);
        np3 = (NumberPicker) findViewById(R.id.np3);
        np4 = (NumberPicker) findViewById(R.id.np4);
        np5 = (NumberPicker) findViewById(R.id.np5);
        np6 = (NumberPicker) findViewById(R.id.np6);

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
        alertDialogBuilder.setTitle("The difference is " + dif + " days").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub


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
                // TODO Auto-generated method stub


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
                open();

            }


        }
    }


}




