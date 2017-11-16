package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.model.Crime;

/**
 * Created by Administrator on 2017/11/16.
 */

public class CrimentFragment extends Fragment {

    private Crime mCrime;
    private View mView;

    private TextView mCrimeId;
    private TextView mCrimeDes;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_crime, container, false);
        mCrimeId = mView.findViewById(R.id.crime_id);
        mCrimeDes = mView.findViewById(R.id.crime_des);

        mCrimeDes.setText(mCrime.getDescribe());
        mCrimeId.setText(mCrime.getCrimeId());
        return mView;

    }

    public void setCrime(Crime crime) {
        mCrime = crime;
    }
}
