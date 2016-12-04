package com.example.alex.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Alex on 6/28/2016.
 */
public class MyIntentService extends IntentService{

    private static final String TAG = "ServiceExample";

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Intent Service Started");

        final String intentMessage = intent.getStringExtra("EXTRA_MESSAGE");


        for (int i = 0; i < 3; i++) {
            long endTime = System.currentTimeMillis() + 10 * 1000;
            while (System.currentTimeMillis() < endTime) {
                synchronized (this) {
                    try {
                        wait(endTime - System.currentTimeMillis());
                    } catch (Exception e) {
                    }
                }
            }
            Log.i(TAG, "Service Running: " + intentMessage);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Service onDestroy");
    }
}
