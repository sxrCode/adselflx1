package com.sxr.com.mainmodule.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxr.com.mainmodule.R;


public class AnimationTestFragment extends Fragment {

    private View mTestView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation_test, container, false);
        mTestView = view.findViewById(R.id.anim_test_view);
        AnimatorSet anim = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.alpha_fade);
        anim.setTarget(mTestView);
        anim.start();
        return view;
    }


}
