package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;


public class CoordinateTestFragment extends Fragment {

    private FloatingActionButton mFloatingActionButton;
    private Button mButton;
    private CoordinatorLayout mContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_md_widget, container, false);
        initWidget(view);
        return view;
    }

    private void initWidget(View view) {
        mContainer = view.findViewById(R.id.cor_container);
        mFloatingActionButton = view.findViewById(R.id.cor_fab);
        mButton = view.findViewById(R.id.cor_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mContainer, "this is snackbat", 2000).show();
            }
        });
    }
}
