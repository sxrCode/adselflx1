package com.sxr.com.mainmodule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sxr.com.mainmodule.fragment.CrimentFragment;
import com.sxr.com.mainmodule.model.CrimeLab;

/**
 * Created by Administrator on 2017/11/16.
 */

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startOnFrame();
    }


    private void startOnFrame() {
        Log.e("CrimeActivity", "startOnFrame");
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            CrimentFragment fragment = new CrimentFragment();
            fragment.setCrime(CrimeLab.getInstance().getCrime(2));
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();

        }
    }
}
