package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.sxr.com.mainmodule.R;


public class FilterMenuFragment extends Fragment {

    private Button mButton1;
    private FrameLayout mContent;

    private LinearLayout mSelectContentLayout;

    private SelectContentDelegate mSelectContentDelegate = new SelectContentDelegate();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_menu, container, false);
        initWidget(view);
        return view;
    }

    private void initWidget(View view) {
        mButton1 = view.findViewById(R.id.con1_btn);
        mContent = view.findViewById(R.id.con_container);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelectContentLayout == null) {
                    LayoutInflater.from(getActivity()).inflate(R.layout.content_filter_menu, mContent);
                    mSelectContentLayout = mContent.findViewById(R.id.filter_content_root);
                    Button select1 = mSelectContentLayout.findViewById(R.id.menu_select1_btn);
                    select1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mSelectContentDelegate.onSelectFinish();
                        }
                    });
                } else {
                    mSelectContentLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    class SelectContentDelegate {
        private int data = 0;

        public void onSelectFinish() {
            data = 1;
            if (mSelectContentLayout != null) {
                mSelectContentLayout.setVisibility(View.GONE);
            }
        }

        public int getData() {
            return data;
        }
    }

}


