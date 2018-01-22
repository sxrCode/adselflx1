package com.sxr.com.mainmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.activity.AnimationTestActivity;
import com.sxr.com.mainmodule.activity.CusContainerTestActivity;
import com.sxr.com.mainmodule.activity.SceneTestActivity;

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
        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.e("select true!");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SceneTestActivity.class);
                startActivity(intent);
            }
        });

        mFalseButtom = findViewById(R.id.false_button);
        mFalseButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnimationTestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
