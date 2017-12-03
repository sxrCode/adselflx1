package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.CircleView;


public class CircleFragment extends Fragment {
    private CircleView mCircleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        mCircleView = view.findViewById(R.id.circle);
        mCircleView.setRate(80);
        return view;
    }
}
