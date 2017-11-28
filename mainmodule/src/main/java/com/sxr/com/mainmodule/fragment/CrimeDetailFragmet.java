package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.model.Crime;
import com.sxr.com.mainmodule.model.CrimeLab;
import com.sxr.com.mainmodule.view.PairItemView;


public class CrimeDetailFragmet extends Fragment {

    private RecyclerView mRecyclerView;

    private Crime mCrime = CrimeLab.getInstance().getCrime(0);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_detail, container, false);
        //mRecyclerView = view.findViewById(R.id.crimedetail_form);
        //initUI();
        return view;
    }

    private void initUI() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position % 3) != 0) {
                    return 1;
                }
                return 2;
            }
        });

        mRecyclerView.setLayoutManager(gridLayoutManager);
        CrimeDetailFragmet.CrimeAdapter adapter = new CrimeAdapter();
        mRecyclerView.setAdapter(adapter);

    }

    private class CrimeViewHolder extends RecyclerView.ViewHolder {

        public CrimeViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Crime crime) {
            PairItemView item = itemView.findViewById(R.id.crime_item);
            item.setLabel("描述:");
            item.setValue(crime.getDescribe());
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeDetailFragmet.CrimeViewHolder> {

        @Override
        public CrimeDetailFragmet.CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.griditem_crime, parent, false);
            return new CrimeDetailFragmet.CrimeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeDetailFragmet.CrimeViewHolder holder, int position) {
            Crime crime = mCrime;
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }

}
