package com.sxr.com.mainmodule.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.R;

public class AnimatorFragment extends Fragment {

    private TextView mTextView;

    private Button mExecute;

    private AnimatorSet animatorSet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animator_test, container, false);
        mTextView = view.findViewById(R.id.test_title);
        animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.alpha_fade);

        initExecute(view);
        return view;
    }

    private void initExecute(View view) {
        mExecute = view.findViewById(R.id.execute);
        mExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.setTarget(mTextView);
                animatorSet.start();
            }
        });
    }
}
