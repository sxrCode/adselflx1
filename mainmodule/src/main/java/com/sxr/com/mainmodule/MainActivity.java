package com.sxr.com.mainmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sxr.com.mainmodule.activity.ColorOptionsActivity;
import com.sxr.com.mainmodule.activity.ContractDetailActivity;
import com.sxr.com.mainmodule.activity.ScrollActivity;
import com.sxr.com.mainmodule.activity.SunsetActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private Button mTrueButton;

    private Button mFalseButtom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startOnFormal();
    }

    private void startOnFormal() {
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "startOnFormal");
        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ColorOptionsActivity.class);
                startActivity(intent);
            }
        });

        mFalseButtom = findViewById(R.id.false_button);
        mFalseButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ContractDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
