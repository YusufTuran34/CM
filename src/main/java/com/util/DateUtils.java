package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nexus on 23.06.2017.
 */
public class DateUtils {

    public static Date initialDate = new Date();

    private DateUtils(){

    }

    public static String toISO8601(Date date){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return df.format(date);
    }

    public static Date toDate(String ISO8601){

        try {

            Calendar cal = Calendar.getInstance();
            TimeZone tz = cal.getTimeZone();

            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(ISO8601);
            int gmtOffset = TimeZone.getDefault().getRawOffset();
            date = new Date(date.getTime() + gmtOffset);

          /*  Log.d(TAG, "toDate: ---------------------------------------" + ISO8601);
            Log.d(TAG, "toDate: year = " + date.getYear());
            Log.d(TAG, "toDate: month = " + date.getMonth());
            Log.d(TAG, "toDate: day = " + date.getDate());
            Log.d(TAG, "toDate: hour = " + date.getHours());
            Log.d(TAG, "toDate: minute = " + date.getMinutes());
            Log.d(TAG, "toDate: second = " + date.getSeconds());
            Log.d(TAG, "toDate: ---------------------------------------");*/
            return date;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
//        cal.add(Calendar.SECOND, 10); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date addHourse(Date date, int hours)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hours); //minus number would decrement the days
//        cal.add(Calendar.SECOND, 10); //minus number would decrement the days
        return cal.getTime();
    }
}
