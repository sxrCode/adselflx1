package com.sxr.com.mainmodule.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CommonRecyclerViewHolder extends RecyclerView.ViewHolder {
    public CommonRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public void setText(int id, String text) {
        View view = itemView.findViewById(id);
        if (view != null && view instanceof TextView) {
            ((TextView) view).setText(text);
        }
    }

    public void setImg(int id, int resid) {
        View view = itemView.findViewById(id);
        if (view != null && view instanceof ImageView) {
            ((ImageView) view).setImageResource(resid);
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View v = itemView.findViewById(viewId);
        return (T) v;
    }
}
