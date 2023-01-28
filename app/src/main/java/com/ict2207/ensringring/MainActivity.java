package com.ict2207.ensringring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.telephony.SmsManager;
import android.widget.Toast;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0;
    Button jootingbutton;
    Button zoiebutton;
    Button thiamaikbutton;
    Button marhakimbutton;
    Button peishanbutton;
    Button claudiabutton;
    TextView output;
    String result;

    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jootingbutton = findViewById(R.id.jootingbutton);
        zoiebutton = findViewById(R.id.zoiebutton);
        thiamaikbutton = findViewById(R.id.thiamaikbutton);
        marhakimbutton = findViewById(R.id.marhakimbutton);
        peishanbutton = findViewById(R.id.peishanbutton);
        claudiabutton = findViewById(R.id.claudiabutton);
        output = findViewById(R.id.output);

        jootingbutton.setOnClickListener(this);
        zoiebutton.setOnClickListener(this);
        thiamaikbutton.setOnClickListener(this);
        marhakimbutton.setOnClickListener(this);
        peishanbutton.setOnClickListener(this);
        claudiabutton.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.jootingbutton) {
            result = "Name: Chiam Joo Ting\nStudent ID: 2102927";
            output.setText(result);
            sendSMSMessage();
        }
        if(view.getId() == R.id.zoiebutton) {
            result = "Name: Zoie Chew\nStudent ID: 2102930";
            output.setText(result);
            sendSMSMessage();
        }
        if(view.getId() == R.id.thiamaikbutton) {
            result = "Name: Goh Thiam Aik\nStudent ID: 2102924";
            output.setText(result);
            sendSMSMessage();
        }
        if(view.getId() == R.id.marhakimbutton) {
            result = "Name: MUHAMMAD MARHAKIM BIN MARZUKI\nStudent ID: 2102932";
            output.setText(result);
            sendSMSMessage();
        }
        if(view.getId() == R.id.peishanbutton) {
            result = "Name: LI PEISHAN\nStudent ID: 2102934";
            output.setText(result);
            sendSMSMessage();
        }
        if(view.getId() == R.id.claudiabutton) {
            result = "Name: CLAUDIA CHEE XIN LIN\nStudent ID: 2102929";
            output.setText(result);
            sendSMSMessage();
        }
    }

    protected void sendSMSMessage() {
        phoneNo = "81115555";
        message = result;

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}