package com.example.alex.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ServiceExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        /*
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
        */
    }

    public void buttonClick(View view){
//        Intent intent = new Intent(this, MyService.class);
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("EXTRA_MESSAGE", "Message for my Service");
        startService(intent);
    }

    public void buttonMultithreadClick(View view){
        for(int i=0; i<10; i++){
            Intent intent = new Intent(this, MyMultithreadService.class);
            intent.putExtra("EXTRA_MESSAGE", "Message for my Service");
            startService(intent);
        }
    }

    public void buttonMultithreadWithLooperClick(View view){
        for(int i=0; i<10; i++){
            Intent intent = new Intent(this, MyMultithreadWithLooper.class);
            intent.putExtra("EXTRA_MESSAGE", "Message for my Service");
            startService(intent);
        }
    }
}
