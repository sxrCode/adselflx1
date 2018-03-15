package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxr.com.mainmodule.R;


public class NestedTestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nested_test, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().add(R.id.nested_one, new DatePickerLoopFragment()).add(R.id.nested_two, new FileChooserFragment()).commit();
    }
}
