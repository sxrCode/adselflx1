package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.event.MsgEvent11;

import org.greenrobot.eventbus.EventBus;


public class EventBusFragment extends Fragment {
    private Button mButton11;
    private Button mButton12;
    private Button mButton13;

    private Button mButton21;
    private Button mButton22;
    private Button mButton23;

    private Button mButton31;
    private Button mButton32;
    private Button mButton33;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventbus_test, container, false);
        initWidget(view);
        return view;
    }

    private void initWidget(View view) {
        mButton11 = view.findViewById(R.id.eventbus_bn11);
        mButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgEvent11 msgEvent11 = new MsgEvent11();
                msgEvent11.setInfo("Msg Event 11!");
                EventBus.getDefault().post(msgEvent11);
            }
        });
    }
}
