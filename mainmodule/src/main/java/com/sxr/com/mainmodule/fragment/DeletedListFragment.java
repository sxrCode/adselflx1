package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.SlidingButtonViewAdapter;


public class DeletedListFragment extends Fragment implements SlidingButtonViewAdapter.IonSlidingViewClickListener {

    private final String TAG = "test";
    private RecyclerView mRecyclerView;
    private SlidingButtonViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deleted_list, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerview);
        setAdapter();
        return view;
    }

    private void setAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter = new SlidingButtonViewAdapter(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setIonSlidingButtonListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(TAG, "点击项：" + position);
    }

    @Override
    public void onDeleteBtnCilck(View view, int position) {
        Log.e(TAG, "删除项：" + position);
        mAdapter.removeData(position);
    }
}
