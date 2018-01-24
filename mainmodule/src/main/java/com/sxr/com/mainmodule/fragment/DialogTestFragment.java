package com.sxr.com.mainmodule.fragment;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.sxr.com.mainmodule.R;


public class DialogTestFragment extends Fragment {

    private Button mButtonA;
    private Button mButtonB;
    private Button mButtonC;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        initButton(view);
        return view;
    }

    private void initButton(View view) {
        mButtonA = view.findViewById(R.id.dialog_a);
        mButtonB = view.findViewById(R.id.dialog_b);
        mButtonC = view.findViewById(R.id.dialog_c);

        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogTestFragment.this.getActivity());
                AlertDialog dialog = builder.setTitle("dialog a").setMessage("this is a dialog").setNegativeButton("Cancel", null).create();
                dialog.setCancelable(false);
                dialog.show();
                */

                Button floatButton = new Button(DialogTestFragment.this.getActivity());
                floatButton.setText("float button");

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0,
                        PixelFormat.TRANSPARENT);
                layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
                layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
                layoutParams.gravity = Gravity.BOTTOM;
                WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
                manager.addView(floatButton, layoutParams);
            }
        });
    }
}
