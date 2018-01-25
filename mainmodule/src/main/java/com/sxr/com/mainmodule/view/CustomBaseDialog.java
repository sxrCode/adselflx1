package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.view.View;

import com.flyco.dialog.widget.base.BaseDialog;
import com.sxr.com.mainmodule.R;

/**
 * Created by Administrator on 2018/1/25.
 */

public class CustomBaseDialog extends BaseDialog<CustomBaseDialog> {
    public CustomBaseDialog(Context context, boolean isPopupStyle) {
        super(context, isPopupStyle);
    }

    @Override
    public View onCreateView() {
        View view = View.inflate(getContext(), R.layout.activity_main, null);
        return view;
    }

    @Override
    public void setUiBeforShow() {

    }
}
