package com.sxr.com.mainmodule.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;

public class Com1Fragment extends Fragment {

    private Button mBeforeBtn;
    private Button mNextBtn;

    private Activity mActivity;
    private Delegate mDelegate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiitem_1, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        mBeforeBtn = view.findViewById(R.id.before_btn);
        mNextBtn = view.findViewById(R.id.next_btn);

        mBeforeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDelegate != null) {
                    mDelegate.onBefore();
                }
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDelegate != null) {
                    mDelegate.onNext();
                }
            }
        });
    }

    public void setDelegate(Delegate delegate) {
        mDelegate = delegate;
    }

    public interface Delegate {
        public void onNext();

        public void onBefore();
    }
}
