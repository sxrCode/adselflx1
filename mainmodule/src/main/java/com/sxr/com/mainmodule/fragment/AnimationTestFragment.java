package com.sxr.com.mainmodule.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.sxr.com.mainmodule.R;


public class AnimationTestFragment extends Fragment {

    private View mTestView;
    private View mLevelView;
    private Button mAnimBtn;
    private FrameLayout mContentArea;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation_test, container, false);
        mTestView = view.findViewById(R.id.anim_test_view);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.view_hor_enter);
        animation.setDuration(1000);
        mTestView.startAnimation(animation);


        mLevelView = view.findViewById(R.id.level_test_view);
        Drawable background = mLevelView.getBackground();
        background.setLevel(background.getLevel() + 1000);

        registerForContextMenu(mLevelView);
        registerForContextMenu(mTestView);

        mLevelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getActivity(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_main, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(), "click " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });

        mContentArea = view.findViewById(R.id.pop_content);

        mAnimBtn = view.findViewById(R.id.anim_btn);
        mAnimBtn.setOnClickListener(new View.OnClickListener() {
            private View popView;

            @Override
            public void onClick(View v) {
                if (popView == null) {
                    popView = getPopView();
                    mContentArea.addView(popView);
                }

                Button exitBtn = popView.findViewById(R.id.exit_btn);
                exitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        exit();
                    }
                });
                enter();
            }

            private void exit() {
                if (popView != null) {
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.view_hor_exit);
                    animation.setFillAfter(true);
                    popView.startAnimation(animation);
                    mContentArea.removeView(popView);
                    popView = null;
                }
            }

            private void enter() {
                if (popView != null) {
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.view_hor_enter);
                    popView.startAnimation(animation);
                }
            }
        });

        return view;
    }

    private View getPopView() {
        return LayoutInflater.from(getActivity()).inflate(R.layout.sub_popview, mContentArea, false);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(getActivity(), "select " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
