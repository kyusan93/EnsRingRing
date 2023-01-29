package com.ict2207.ensringring;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.app.AlertDialog;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    int STUDENT_SELECTED = 0;
    int ALLOWED_SMS_PERMISSION = 0;
    Button jootingbutton;
    Button zoiebutton;
    Button thiamaikbutton;
    Button marhakimbutton;
    Button peishanbutton;
    Button claudiabutton;
    TextView output;
    EditText editPhone;
    Button sendsmsbutton;
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
        editPhone = findViewById(R.id.editPhone);
        sendsmsbutton = findViewById(R.id.sendsmsbutton);

        jootingbutton.setOnClickListener(this);
        zoiebutton.setOnClickListener(this);
        thiamaikbutton.setOnClickListener(this);
        marhakimbutton.setOnClickListener(this);
        peishanbutton.setOnClickListener(this);
        claudiabutton.setOnClickListener(this);
        sendsmsbutton.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.jootingbutton) {
            STUDENT_SELECTED = 1;
            result = "Name: Chiam Joo Ting\nStudent ID: 2102927";
            output.setText(result);
            if(ALLOWED_SMS_PERMISSION != 0) {
                phoneNo = "81118888";
                sendSMSMessage(phoneNo);
            }
        }
        if(view.getId() == R.id.zoiebutton) {
            STUDENT_SELECTED = 1;
            result = "Name: Zoie Chew\nStudent ID: 2102930";
            output.setText(result);
            if(ALLOWED_SMS_PERMISSION != 0) {
                phoneNo = "81118888";
                sendSMSMessage(phoneNo);
            }
        }
        if(view.getId() == R.id.thiamaikbutton) {
            STUDENT_SELECTED = 1;
            result = "Name: Goh Thiam Aik\nStudent ID: 2102924";
            output.setText(result);
            if(ALLOWED_SMS_PERMISSION != 0) {
                phoneNo = "81118888";
                sendSMSMessage(phoneNo);
            }
        }
        if(view.getId() == R.id.marhakimbutton) {
            STUDENT_SELECTED = 1;
            result = "Name: MUHAMMAD MARHAKIM BIN MARZUKI\nStudent ID: 2102932";
            output.setText(result);
            if(ALLOWED_SMS_PERMISSION != 0) {
                phoneNo = "81118888";
                sendSMSMessage(phoneNo);
            }
        }
        if(view.getId() == R.id.peishanbutton) {
            STUDENT_SELECTED = 1;
            result = "Name: LI PEISHAN\nStudent ID: 2102934";
            output.setText(result);
            if(ALLOWED_SMS_PERMISSION != 0) {
                phoneNo = "81118888";
                sendSMSMessage(phoneNo);
            }
        }
        if(view.getId() == R.id.claudiabutton) {
            STUDENT_SELECTED = 1;
            result = "Name: CLAUDIA CHEE XIN LIN\nStudent ID: 2102929";
            output.setText(result);
            if(ALLOWED_SMS_PERMISSION != 0) {
                phoneNo = "81118888";
                sendSMSMessage(phoneNo);
            }
        }
        if(view.getId() == R.id.sendsmsbutton) {
            if(STUDENT_SELECTED == 1) {
                phoneNo = editPhone.getText().toString();
                if(phoneNo.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please input your phone number.", Toast.LENGTH_LONG).show();
                } else {
                    sendSMSMessage(phoneNo);
                    ALLOWED_SMS_PERMISSION = 1;
                }
            } else {
                Toast.makeText(getApplicationContext(),"Please select a student first.", Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void sendSMSMessage(String phoneNo) {
        message = result;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        else {
            requestSMSPermission();
        }
    }

    private void requestSMSPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("Permission is needed to send sms from your device...")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);
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
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}