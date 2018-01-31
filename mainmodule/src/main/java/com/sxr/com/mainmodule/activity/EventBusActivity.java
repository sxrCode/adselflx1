package com.sxr.com.mainmodule.activity;


import android.support.v4.app.Fragment;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.event.MsgEvent11;
import com.sxr.com.mainmodule.fragment.EventBusFragment;

import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new EventBusFragment();
    }


    @Subscribe
    public void onMsg11(MsgEvent11 event) {
        Logger.e("receive msg11: " + event.getInfo());
    }
}
