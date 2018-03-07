package com.sxr.com.mainmodule.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.flyco.animation.FadeEnter.FadeEnter;
import com.flyco.animation.ZoomExit.ZoomOutBottomExit;
import com.flyco.dialog.entity.DialogMenuItem;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.flyco.dialog.widget.NormalListDialog;
import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.PayBottomDialog;

import java.util.ArrayList;


public class DialogTestFragment extends Fragment {

    private Button mButtonA;
    private Button mButtonB;
    private Button mButtonC;
    private Button mButtonD;
    private Button mButtonE;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_test, container, false);
        initButton(view);
        return view;
    }

    private void initButton(final View view) {

        final Context activity = getActivity();

        mButtonA = view.findViewById(R.id.dialog_a);
        mButtonB = view.findViewById(R.id.dialog_b);
        mButtonC = view.findViewById(R.id.dialog_c);
        mButtonD = view.findViewById(R.id.dialog_d);
        mButtonE = view.findViewById(R.id.dialog_e);

        final ArrayList<DialogMenuItem> menuItems = new ArrayList<>();
        menuItems.add(new DialogMenuItem("menu1", 1));
        menuItems.add(new DialogMenuItem("menu2", 2));
        menuItems.add(new DialogMenuItem("menu3", 3));
        menuItems.add(new DialogMenuItem("menu4", 4));


        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final NormalDialog normalDialog = new NormalDialog(activity);
                normalDialog.showAnim(new FadeEnter())
                        .dismissAnim(new ZoomOutBottomExit())
                        .content("特有的!").title("this is title!")
                        .isTitleShow(false).btnText("btn1", "btn2");
                normalDialog.contentGravity(Gravity.BOTTOM);

                normalDialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        Toast.makeText(activity, "left", Toast.LENGTH_SHORT).show();
                        normalDialog.dismiss();
                    }
                });

                normalDialog.show();
            }
        });

        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog dialog = new MaterialDialog(activity);
                dialog.content("this is content").isTitleShow(false).showAnim(new FadeEnter()).dismissAnim(new ZoomOutBottomExit());
                dialog.contentGravity(Gravity.BOTTOM);
                dialog.show();
            }
        });

        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final NormalListDialog dialog = new NormalListDialog(activity, menuItems);

                dialog.isTitleShow(false).showAnim(new FadeEnter());
                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(activity, menuItems.get((int) id).mOperName, Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ActionSheetDialog dialog = new ActionSheetDialog(activity, menuItems, mButtonA);

                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(activity, menuItems.get((int) id).mOperName, Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                dialog.isTitleShow(false);
                dialog.show();
            }
        });

        mButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayBottomDialog dialog = new PayBottomDialog(activity);
                dialog.show();

                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.content_pay_code, dialog.getContentContainer(), false);
                dialog.getContentContainer().addView(view1);
            }
        });
    }
}
