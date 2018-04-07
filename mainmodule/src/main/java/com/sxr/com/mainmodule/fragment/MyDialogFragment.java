package com.sxr.com.mainmodule.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.FullScreenDialog;


public class MyDialogFragment extends DialogFragment {

    private Button mChooserBtn;

    private MyDialogFragmentDelegate mDelegate;

    private FrameLayout mContainer;

    private Com1Fragment mCom1Fragment;
    private Com1Fragment mCom2Fragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_dialog_container, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mContainer = view.findViewById(R.id.dialog_content);
        mCom1Fragment = new Com1Fragment();
        mCom2Fragment = new Com1Fragment();

        mCom1Fragment.setDelegate(new Com1Fragment.Delegate() {
            @Override
            public void onNext() {
                getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.view_hor_enter, R.anim.activity_keep).hide(mCom1Fragment).show(mCom2Fragment).commit();
            }

            @Override
            public void onBefore() {
                dismiss();
            }
        });
        mCom2Fragment.setDelegate(new Com1Fragment.Delegate() {
            @Override
            public void onNext() {
                dismiss();
            }

            @Override
            public void onBefore() {
                getChildFragmentManager().beginTransaction().hide(mCom2Fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).show(mCom1Fragment).commit();
            }
        });
        getChildFragmentManager().beginTransaction().add(R.id.dialog_content, mCom1Fragment).add(R.id.dialog_content, mCom2Fragment).hide(mCom2Fragment).commit();

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(getContext());
        return fullScreenDialog;
    }

    public void setDelegate(MyDialogFragmentDelegate delegate) {
        mDelegate = delegate;
    }

    public interface MyDialogFragmentDelegate {
        public void choose();
    }
}
