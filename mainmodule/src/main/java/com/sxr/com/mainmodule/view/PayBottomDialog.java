package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.flyco.animation.SlideEnter.SlideBottomEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.widget.base.BottomBaseDialog;
import com.sxr.com.mainmodule.R;


public class PayBottomDialog extends BottomBaseDialog<PayBottomDialog> {

    private FrameLayout mContentContainer;
    private View mContent;

    public PayBottomDialog(Context context, View animateView) {
        super(context, animateView);
    }

    public PayBottomDialog(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        showAnim(new SlideBottomEnter());
        dismissAnim(new SlideBottomExit());

        View view = View.inflate(mContext, R.layout.bottom_dialog_pay_confirm, null);
        mContentContainer = view.findViewById(R.id.dialog_content);
        return view;
    }

    public void setContent(View view) {
        mContent = view;
    }

    @Override
    public void setUiBeforShow() {
        if (mContentContainer != null && mContent != null) {
            mContentContainer.removeAllViews();
            mContentContainer.addView(mContent);
        }
    }
}
