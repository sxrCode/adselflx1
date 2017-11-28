package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.utils.StringUtils;


public class PairItemView extends LinearLayout {
    private TextView mLabel;
    private TextView mValue;
    private TextView mUnit;

    public PairItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.itemOptions, 0, 0);
        String label = typedArray.getString(R.styleable.itemOptions_labelText);
        String value = typedArray.getString(R.styleable.itemOptions_valueText);
        String unit = typedArray.getString(R.styleable.itemOptions_unitText);
        int labelColor = typedArray.getColor(R.styleable.itemOptions_labelFontColor, getResources().getColor(R.color.blue_sky));
        int valueColor = typedArray.getColor(R.styleable.itemOptions_valueFontColor, getResources().getColor(R.color.blue_sky));
        int unitColor = typedArray.getColor(R.styleable.itemOptions_unitFontColor, getResources().getColor(R.color.blue_sky));
        float labelFontSize = typedArray.getDimension(R.styleable.itemOptions_labelFontSize, getResources().getDimension(R.dimen.activity_horizontal_margin));
        float valueFontSize = typedArray.getDimension(R.styleable.itemOptions_valueFontSize, getResources().getDimension(R.dimen.activity_horizontal_margin));
        float unitFontSize = typedArray.getDimension(R.styleable.itemOptions_unitFontSize, getResources().getDimension(R.dimen.activity_horizontal_margin));
        typedArray.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_item_kv, this);
        }

        mLabel = (TextView) getChildAt(0);
        mValue = (TextView) getChildAt(1);
        mUnit = (TextView) getChildAt(2);

        mLabel.setTextColor(labelColor);
        mLabel.setTextSize(labelFontSize);
        setLabel(label);

        mValue.setTextSize(valueFontSize);
        mValue.setTextColor(valueColor);
        setValue(value);

        mUnit.setTextSize(unitFontSize);
        mUnit.setTextColor(unitColor);
        setUnit(unit);
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

    public void setUnit(String unit) {
        if (StringUtils.isBlank(unit)) {
            mUnit.setVisibility(View.GONE);
        } else {
            mUnit.setVisibility(VISIBLE);
            mUnit.setText(unit);
        }
    }
}
