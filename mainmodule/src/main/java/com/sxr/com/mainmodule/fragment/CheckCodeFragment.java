package com.sxr.com.mainmodule.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.FullScreenDialog;

public class CheckCodeFragment extends DialogFragment {

    private ImageView mRightIcon;
    private TextView mTipTxt;
    private boolean isStart = true;

    private Activity mActivity;

    private int count = 100;

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this, 1000);
            onTick();
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_pay_code, container, false);
        initWidget(view);
        if (isStart) {
            mHandler.postDelayed(mRunnable, 1000);
            isStart = false;
        }
        return view;
    }

    private void initWidget(View root) {
        mActivity = getActivity();
        mRightIcon = root.findViewById(R.id.right_icon_img);
        mTipTxt = root.findViewById(R.id.tip_txt);
        initTipTxt();
        mRightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void onTick() {
        if (count >= 0) {
            count--;
            initTipTxt();
        }
    }

    private void initTipTxt() {
        if (mTipTxt != null) {
            mTipTxt.setText(count + "s");
        }
    }

    public void setCount(int count) {
        this.count = count;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(getContext());
        return fullScreenDialog;
    }
}
