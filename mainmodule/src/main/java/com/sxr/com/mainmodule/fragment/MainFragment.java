package com.sxr.com.mainmodule.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.activity.DialogTestActivity;
import com.sxr.com.mainmodule.activity.EventBusActivity;
import com.sxr.com.mainmodule.event.MsgEvent11;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainFragment extends Fragment {

    private TextView mTextMessage;

    private Button mTrueButton;

    private Button mFalseButtom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        initWidget(view);
        return view;
    }


    private void initWidget(View view) {
        startOnFormal(view);
        mTextMessage = view.findViewById(R.id.ViewTitle);
    }

    private void startOnFormal(View view) {
        mTrueButton = view.findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.e("select true!");
                Intent intent = new Intent();
                intent.setClass(getActivity(), DialogTestActivity.class);
                startActivity(intent);
            }
        });

        mFalseButtom = view.findViewById(R.id.false_button);
        mFalseButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), EventBusActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMsg11(MsgEvent11 event) {
        mTextMessage.setText(event.getInfo());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }
}
