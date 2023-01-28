package com.ict2207.ensringring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button jootingbutton;
    Button zoiebutton;
    Button thiamaikbutton;
    Button marhakimbutton;
    Button peishanbutton;
    Button claudiabutton;
    TextView output;

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
        String result;
        if(view.getId() == R.id.jootingbutton) {
            result = "Name: Chiam Joo Ting\nStudent ID: 2102927";
            output.setText(result);
        }
        if(view.getId() == R.id.zoiebutton) {
            result = "Name: Zoie Chew\nStudent ID: 2102930";
            output.setText(result);
        }
        if(view.getId() == R.id.thiamaikbutton) {
            result = "Name: Goh Thiam Aik\nStudent ID: 2102924";
            output.setText(result);
        }
        if(view.getId() == R.id.marhakimbutton) {
            result = "Name: MUHAMMAD MARHAKIM BIN MARZUKI\nStudent ID: 2102932";
            output.setText(result);
        }
        if(view.getId() == R.id.peishanbutton) {
            result = "Name: LI PEISHAN\nStudent ID: 2102934";
            output.setText(result);
        }
        if(view.getId() == R.id.claudiabutton) {
            result = "Name: CLAUDIA CHEE XIN LIN\nStudent ID: 2102929";
            output.setText(result);
        }
    }
}