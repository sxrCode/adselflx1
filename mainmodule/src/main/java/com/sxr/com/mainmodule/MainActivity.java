package com.sxr.com.mainmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sxr.com.mainmodule.activity.CrimeListActivity;
import com.sxr.com.mainmodule.fragment.CrimentFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private Button mTrueButton;

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
                intent.setClass(MainActivity.this, CrimeListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startOnFrame() {
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new CrimentFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
