package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;

public class RegisterSimilarFragment extends Fragment {

    private Button mButton;

    private CheckCodeFragment mCheckCodeFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_menu, container, false);
        initButton(view);
        return view;
    }

    private void initButton(View root) {
        mButton = root.findViewById(R.id.con1_btn);
        createMyDialogFragment();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCheckCodeFragment.show(getChildFragmentManager(), "checkcode");
            }
        });
    }

    private void createMyDialogFragment() {
        mCheckCodeFragment = new CheckCodeFragment();
        mCheckCodeFragment.setCount(300);
    }
}
