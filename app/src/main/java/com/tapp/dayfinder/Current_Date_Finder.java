package com.tapp.dayfinder;

import java.util.Date;

 class Current_Date_Finder {

    //fetching current date.
  private Date cur_date_Date = new Date();
    private String cur_date_String = String.valueOf(cur_date_Date);


    //FETCHING CURRENT YEAR
   int current_year()
    {
        String cur_year ;
        if (cur_date_String.length() > 4)
        {
            cur_year = cur_date_String.substring(cur_date_String.length() - 4);
        }
        else
            cur_year = cur_date_String;

        return Integer.parseInt(cur_year);

    }


    //FETCHING CURRENT DAY

     int current_day()
    {
        String cur_day =cur_date_String.substring(8,10);
        return Integer.parseInt(cur_day);

    }

     //Fetching Current MONTH

     int current_month()
     {
         String cur_month =cur_date_String.substring(4,7);
         int cur_month_index;

         switch (cur_month)
         {
             case "Jan" : cur_month_index = 0;
                 break;
             case "Feb" : cur_month_index = 1;
                 break;
             case "Mar" : cur_month_index = 2;
                 break;
             case "Apr" : cur_month_index = 3;
                 break;
             case "May" : cur_month_index = 4;
                 break;
             case "Jun" : cur_month_index = 5;
                 break;
             case "Jul" : cur_month_index = 6;
                 break;
             case "Aug" : cur_month_index = 7;
                 break;
             case "Sep" : cur_month_index = 8;
                 break;
             case "Oct" : cur_month_index = 9;
                 break;
             case "Nov" : cur_month_index = 10;
                 break;
             case "Dec" : cur_month_index = 11;
                 break;
             default: cur_month_index = 0;

         }

         return cur_month_index;
     }

     boolean february_29 (int day, int month, int year)
     {
         boolean invalid;

         //If month is April || June || September || November
         if (month == 3 || month == 5 || month == 8 || month == 10)
         {
             if (day == 31)
                 invalid = true;
             else
                 invalid = false;
         }
         else
             invalid = false;

         //If month is February
         if (month == 1)
         {
             if(day > 29)
                 invalid = true;
             else
             {
                 if (day == 29 )
                 {
                     if(leap_year(year))
                         invalid = false;
                     else
                         invalid = true;
                 }
                 else
                 {
                     invalid = false;
                 }
             }
         }
         return invalid;
     }

    private boolean leap_year (int year)
     {
         boolean flag ;
         if(year % 400 == 0)
         {
             flag = true;
         }
         else if (year % 100 == 0)
         {
             flag = false;
         }
         else if(year % 4 == 0)
         {
             flag = true;
         }
         else
         {
             flag = false;
         }
         return flag;
     }
}
