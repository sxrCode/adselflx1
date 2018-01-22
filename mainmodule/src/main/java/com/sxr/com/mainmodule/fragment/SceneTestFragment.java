package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;


public class SceneTestFragment extends Fragment {


    Transition transition;
    TextView mLabelText;
    private FrameLayout mSceneRoot;
    private Button mSceneToggle;
    private Scene mStartScene;
    private Scene mEndScene;
    private boolean toggle = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test_scene, container, false);
        mSceneRoot = v.findViewById(R.id.scene_root);

        initSceneToggle(v);
        mStartScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_a, this.getContext());
        mEndScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_b, this.getContext());

        return v;
    }

    private void initSceneToggle(View view) {
        mSceneToggle = view.findViewById(R.id.scene_toggle);
        transition = TransitionInflater.from(SceneTestFragment.this.getContext()).inflateTransition(R.transition.fade_transition);

        mLabelText = new TextView(getContext());
        mLabelText.setText("Label");
        mSceneToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (toggle) {
                    TransitionManager.go(mEndScene, new Slide());
                } else {
                    TransitionManager.go(mStartScene, new Slide());
                }
                toggle = !toggle;


            }
        });
    }
}
