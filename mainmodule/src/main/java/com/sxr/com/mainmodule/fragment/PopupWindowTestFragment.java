package com.sxr.com.mainmodule.fragment;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sxr.com.mainmodule.R;


public class PopupWindowTestFragment extends Fragment {

    private Button mButtonA;
    private Button mButtonB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_content, container, false);
        initWidget(view);
        return view;
    }

    private void initWidget(View view) {
        mButtonA = view.findViewById(R.id.true_button);
        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity context = PopupWindowTestFragment.this.getActivity();
                final PopupWindow popupWindow = new PopupWindow(context);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(LayoutInflater.from(context).inflate(R.layout.content_pupup, null));
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x800f001f));
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(v);

                View content = popupWindow.getContentView();
                content.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });

        mButtonB = view.findViewById(R.id.false_button);
        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
