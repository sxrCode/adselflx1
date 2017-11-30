package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.utils.StringUtils;

/**
 * Created by Administrator on 2017/11/29.
 */

public class SeparateItemView extends RelativeLayout {
    private TextView mLabel;
    private TextView mValue;

    public SeparateItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.itemOptions, 0, 0);
        String label = typedArray.getString(R.styleable.itemOptions_labelText);
        String value = typedArray.getString(R.styleable.itemOptions_valueText);
        int labelColor = typedArray.getColor(R.styleable.itemOptions_labelFontColor, getResources().getColor(R.color.blue_sky));
        int valueColor = typedArray.getColor(R.styleable.itemOptions_valueFontColor, getResources().getColor(R.color.blue_sky));
        float labelFontSize = typedArray.getDimension(R.styleable.itemOptions_labelFontSize, getResources().getDimension(R.dimen.activity_horizontal_margin)) / 2;
        float valueFontSize = typedArray.getDimension(R.styleable.itemOptions_valueFontSize, getResources().getDimension(R.dimen.activity_horizontal_margin)) / 2;
        typedArray.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_item_separate, this);
        }

        mLabel = (TextView) getChildAt(1);
        mValue = (TextView) getChildAt(0);

        mLabel.setTextColor(labelColor);
        mLabel.setTextSize(labelFontSize);
        setLabel(label);

        mValue.setTextSize(valueFontSize);
        mValue.setTextColor(valueColor);
        setValue(value);


    }

    public void setLabel(String label) {
        if (StringUtils.isBlank(label)) {
            mLabel.setVisibility(View.GONE);
        } else {
            mLabel.setVisibility(VISIBLE);
            mLabel.setText(label);
        }

    }

    public void setValue(String value) {
        if (StringUtils.isBlank(value)) {
            mValue.setVisibility(View.GONE);
        } else {
            mValue.setVisibility(VISIBLE);
            mValue.setText(value);
        }

    }
}

