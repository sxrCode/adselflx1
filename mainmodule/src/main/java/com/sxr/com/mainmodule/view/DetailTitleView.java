package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;

/**
 * Created by DELL on 2017/11/26.
 */

public class DetailTitleView extends RelativeLayout {

    private TextView mTitleView;
    private TextView mStateView;


    public DetailTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_detail_title, this);

        mTitleView = (TextView) getChildAt(0);
        mStateView = (TextView) getChildAt(1);
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public void setTitleView(TextView titleView) {
        mTitleView = titleView;
    }

    public TextView getStateView() {
        return mStateView;
    }

    public void setStateView(TextView stateView) {
        mStateView = stateView;
    }
}
