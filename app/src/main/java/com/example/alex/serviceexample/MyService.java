package com.example.alex.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "ServiceExample";

    /*
    Implemented
     */
    @Override
    public void onCreate(){
        Log.i(TAG, "Service onCreate");
    }

    /*
    Implemented
    -> This method is mandatory to be implemented
     */
    @Override
    public int onStartCommand(Intent intent, int flag, int startId) {
        Log.i(TAG, "Service onStartService");

        final String intentMessage = intent.getStringExtra("EXTRA_MESSAGE");

        final int currentId = startId;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
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
                    Log.i(TAG, "Service Running: " + currentId + " ," + intentMessage);
                }
                stopSelf();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy(){
        Log.i(TAG, "Service onDestroy");
    }
}
