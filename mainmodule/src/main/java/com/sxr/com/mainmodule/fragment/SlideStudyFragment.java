package com.sxr.com.mainmodule.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.CustomHorScrollView;


public class SlideStudyFragment extends Fragment {

    private Button mTransferRightBtn;
    private Button mTransferLeftBtn;
    private CustomHorScrollView mContainerLat;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_study, container, false);
        initWidget(view);
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    private void initWidget(View view) {
        mContainerLat = view.findViewById(R.id.cus_hors_lat);

        mTransferRightBtn = view.findViewById(R.id.slide_transfer_right_btn);

        mTransferRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfer(detractOffset(240));
            }
        });

        mTransferLeftBtn = view.findViewById(R.id.slide_transfer_left_btn);
        mTransferLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfer(addOffset(240));
            }
        });
    }

    private void transfer(int newOffset) {
        if (mContainerLat != null) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(mContainerLat.getOldOffset(), newOffset).setDuration(200);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int offset = (int) animation.getAnimatedValue();
                    mContainerLat.move(offset);
                }
            });
            valueAnimator.start();
        }
    }

    private int addOffset(int add) {
        return mContainerLat.getOldOffset() + add;
    }

    private int detractOffset(int detract) {
        return mContainerLat.getOldOffset() - detract;
    }

}
