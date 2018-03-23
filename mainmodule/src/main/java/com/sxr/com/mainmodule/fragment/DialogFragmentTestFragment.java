package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;

public class DialogFragmentTestFragment extends Fragment {

    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_menu, container, false);
        initButton(view);
        return view;
    }

    private void initButton(View root) {
        mButton = root.findViewById(R.id.con1_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMyDialogFragment();
            }
        });
    }

    private void createMyDialogFragment() {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        /*
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.view_ver_enter, R.anim.view_ver_exit);
        myDialogFragment.show(transaction, "myDialogFragment");
        */
        myDialogFragment.show(getFragmentManager(), "myDialogFragment");
        //getFragmentManager().beginTransaction().add(new ColorOptionsFragment(), "color option").commit();
    }
}
