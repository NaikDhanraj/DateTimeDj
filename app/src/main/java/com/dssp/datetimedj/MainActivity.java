package com.dssp.datetimedj;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.dssp.datetimedj.util.SDF;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private static String LOG_TAG = MainActivity.class.getSimpleName();
    private Context context = MainActivity.this;
//    private Calendar currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.btnDate).setOnClickListener(this);
        findViewById(R.id.btnTime).setOnClickListener(this);


    }

    private void datepicker() {
        DatePickerDialog mDate = new DatePickerDialog(context,date,2015,2,24);
        mDate.getDatePicker().setMinDate(System.currentTimeMillis() - 1000 );
        mDate.show();
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            view.setMinDate(System.currentTimeMillis() - 1000);
            String pickedDate = year+"-"+ ++monthOfYear +"-"+dayOfMonth;

            Log.e(LOG_TAG, "DATE " + pickedDate);
            Log.e(LOG_TAG, "PARSED DATE " + SDF.parseDate(pickedDate));
            Date parsedDate = SDF.parseDate(pickedDate);
           // String formatedDate = SDF.formatDate(parsedDate);
            Log.e(LOG_TAG, "formatted DATE " + SDF.formatDate(parsedDate) );
         //   SDF.parseDate(pickedDate);

        }
    };

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnDate:
                datepicker();
                break;

            case R.id.btnTime:
                timePicker();
                break;
        }
    }

    private void timePicker() {
        Calendar currentTime = Calendar.getInstance();
//        Log.e(LOG_TAG,"timePicker "+"hourOfDay "+currentTime.HOUR_OF_DAY+" : "+"minute "+currentTime.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,timeListerner,currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),true);//true means 24 hrs format

        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener timeListerner = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar time = Calendar.getInstance();
            time.set(Calendar.HOUR_OF_DAY,hourOfDay);
            time.set(Calendar.MINUTE,minute);
           // view.
            Log.e(LOG_TAG,"time "+hourOfDay+":"+minute);
            Log.e(LOG_TAG,"formatted time "+SDF.sdf6.format(time.getTime()));
        }
    };
}
