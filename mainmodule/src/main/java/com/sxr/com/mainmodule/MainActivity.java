package com.sxr.com.mainmodule;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

import com.sxr.com.mainmodule.activity.SingleFragmentActivity;
import com.sxr.com.mainmodule.event.MsgEvent11;
import com.sxr.com.mainmodule.fragment.MainFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new MainFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }


}
