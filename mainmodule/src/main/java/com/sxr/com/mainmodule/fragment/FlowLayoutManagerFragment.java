package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.gravity.IChildGravityResolver;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IRowBreaker;
import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.common.CommonRecyclerViewHolder;


public class FlowLayoutManagerFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        mRecyclerView = view.findViewById(R.id.tags_recycler);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        ChipsLayoutManager chipsLayoutManager = ChipsLayoutManager.newBuilder(getActivity())
                //set vertical gravity for all items in a row. Default = Gravity.CENTER_VERTICAL
                .setChildGravity(Gravity.TOP)
                //whether RecyclerView can scroll. TRUE by default
                .setScrollingEnabled(true)
                //set maximum views count in a particular row
                .setMaxViewsInRow(200)
                //set gravity resolver where you can determine gravity for item in position.
                //This method have priority over previous one
                .setGravityResolver(new IChildGravityResolver() {
                    @Override
                    public int getItemGravity(int position) {
                        return Gravity.CENTER;
                    }
                })
                //you are able to break row due to your conditions. Row breaker should return true for that views
                .setRowBreaker(new IRowBreaker() {
                    @Override
                    public boolean isItemBreakRow(@IntRange(from = 0) int position) {
                        return false;
                    }
                })
                //a layoutOrientation of layout manager, could be VERTICAL OR HORIZONTAL. HORIZONTAL by default
                .setOrientation(ChipsLayoutManager.HORIZONTAL)
                // row strategy for views in completed row, could be STRATEGY_DEFAULT, STRATEGY_FILL_VIEW,
                //STRATEGY_FILL_SPACE or STRATEGY_CENTER
                .setRowStrategy(ChipsLayoutManager.STRATEGY_DEFAULT)
                // whether strategy is applied to last row. FALSE by default
                .withLastRow(true)
                .build();
        mRecyclerView.setLayoutManager(chipsLayoutManager);

        mRecyclerView.setAdapter(new RecyclerView.Adapter<CommonRecyclerViewHolder>() {

            @Override
            public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View condition = LayoutInflater.from(getActivity()).inflate(R.layout.item_condition_text, parent, false);
                CommonRecyclerViewHolder holder = new CommonRecyclerViewHolder(condition);
                return holder;
            }

            @Override
            public void onBindViewHolder(CommonRecyclerViewHolder holder, int position) {
                int p = position + 1;
                if (p % 3 == 0) {
                    holder.setText(R.id.conditon_txt, "转让金额有高到低");
                } else if (p % 2 == 0) {
                    holder.setText(R.id.conditon_txt, "转让金额由低到高");
                } else {
                    holder.setText(R.id.conditon_txt, "不限");
                }
            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }
}
