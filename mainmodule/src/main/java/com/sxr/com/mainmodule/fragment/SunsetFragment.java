package com.sxr.com.mainmodule.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sxr.com.mainmodule.R;

/**
 * Created by DELL on 2017/11/18.
 */

public class SunsetFragment extends Fragment {

    private ImageView mSun;
    private View mSky;
    private View mScene;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunset, container, false);
        mScene = view;
        mSun = view.findViewById(R.id.sun);
        mSky = view.findViewById(R.id.sky);

        mSky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });
        return view;
    }

    private void startAnimation() {
        mSun.getTop();
        mSky.getBottom();

        ObjectAnimator animator = ObjectAnimator.ofFloat(mSun, "y", mSun.getTop(), mSky.getBottom()).setDuration(3200);
        animator.start();
    }


}
