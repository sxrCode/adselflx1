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
import android.widget.PopupMenu;
import android.widget.Toast;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.PayBottomDialog;


public class AnimationTestFragment extends Fragment {

    private View mTestView;
    private View mLevelView;
    private Button mAnimBtn;

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


        mAnimBtn = view.findViewById(R.id.anim_btn);
        mAnimBtn.setOnClickListener(new View.OnClickListener() {
            private ViewGroup popContainer;
            private View payView;

            @Override
            public void onClick(View v) {
                PayBottomDialog dialog = new PayBottomDialog(getActivity());
                dialog.show();

                popContainer = dialog.getContentContainer();
                View selectPage = LayoutInflater.from(getActivity()).inflate(R.layout.content_pay_code, popContainer, false);
                popContainer.addView(selectPage);


                Button nextBtn = selectPage.findViewById(R.id.next_btn);
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        enter();
                    }
                });

            }

            private View createPayView(ViewGroup container) {
                final View pay = LayoutInflater.from(getActivity()).inflate(R.layout.sub_popview, container, false);
                container.addView(pay);
                pay.setClickable(true);
                Button exitBtn = pay.findViewById(R.id.exit_btn);
                exitBtn.setOnClickListener(new View.OnClickListener() {
                    private View parentView = pay;

                    @Override
                    public void onClick(View v) {
                        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.view_hor_exit);
                        animation.setFillAfter(true);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                popContainer.removeView(parentView);
                                parentView = null;
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        parentView.startAnimation(animation);
                    }
                });

                return pay;
            }

            private void enter() {
                if (popContainer != null) {
                    payView = createPayView(popContainer);
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.view_hor_enter);
                    payView.startAnimation(animation);
                }
            }
        });

        return view;
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
