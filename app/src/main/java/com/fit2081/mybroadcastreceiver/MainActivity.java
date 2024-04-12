package com.fit2081.mybroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    private MyCallsReceiver myCallsReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] requiredPermissions = new String[]{
                android.Manifest.permission.CALL_PHONE,
                android.Manifest.permission.READ_CALL_LOG,
                android.Manifest.permission.READ_PHONE_STATE
        };

        ActivityCompat.requestPermissions(this, requiredPermissions, 0);

    }

    // Register the receiver when the activity is started
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        registerReceiver(new MyCallsReceiver(), filter);
    }

    // Unregister the receiver when the activity is stopped
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myCallsReceiver);
    }


}