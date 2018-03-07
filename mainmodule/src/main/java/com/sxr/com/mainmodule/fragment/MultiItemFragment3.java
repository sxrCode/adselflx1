package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.activity.MultiFragmentActivity;


public class MultiItemFragment3 extends Fragment {

    private Button mNextBtn;

    private Button mBeforeBtn;

    private MultiFragmentActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiitem_3, container, false);
        mActivity = (MultiFragmentActivity) getActivity();

        initWidget(view);
        return view;
    }

    private void initWidget(View rootView) {
        mBeforeBtn = rootView.findViewById(R.id.before_btn);
        mNextBtn = rootView.findViewById(R.id.next_btn);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mActivity.nextFragment();
            }
        });

        mBeforeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.beforeFragment();
            }
        });
    }
}
