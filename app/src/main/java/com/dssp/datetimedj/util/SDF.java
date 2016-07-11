package com.dssp.datetimedj.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dhanrajnaik522 on 7/12/2016.
 */
public class SDF {

    private static String LOG_TAG = SDF.class.getSimpleName();
    public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat sdf5 = new SimpleDateFormat("EEEE");
    public static SimpleDateFormat sdf6 = new SimpleDateFormat("hh:mm a");

    public static Date parseDate(String selectedDate){

        Date parsedDate = null;
        try {
            parsedDate = sdf1.parse(selectedDate);
            Log.e(LOG_TAG,"parsed date "+parsedDate);
        } catch (ParseException e) {
            Log.e(LOG_TAG,"parsed date exception ");
            e.printStackTrace();
        }

        return parsedDate;
    }

    public static String formatDate(Date parsedDate){

        String formatedDate = sdf2.format(parsedDate);
        Log.e(LOG_TAG,"formatedDate "+formatedDate);

        return formatedDate;

    }
}
