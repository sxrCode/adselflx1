package com.sxr.com.mainmodule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.model.Crime;
import com.sxr.com.mainmodule.model.CrimeLab;

/**
 * Created by Administrator on 2017/11/16.
 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private CrimeAdapter mCrimeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container);
        mRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void updateUI() {
        mCrimeAdapter = new CrimeAdapter();
        mRecyclerView.setAdapter(mCrimeAdapter);
    }

    private class CrimeViewHolder extends RecyclerView.ViewHolder {

        public CrimeViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Crime crime) {
            TextView crimeId = itemView.findViewById(R.id.crime_id);
            crimeId.setText(crime.getCrimeId());
            TextView crimeDes = itemView.findViewById(R.id.crime_des);
            crimeDes.setText(crime.getDescribe());
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeViewHolder> {
        private CrimeLab mCrimeLab = CrimeLab.getInstance();
        private int i = 0;

        @Override
        public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_crime, parent, false);
            return new CrimeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeViewHolder holder, int position) {
            Crime crime = mCrimeLab.getCrime(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimeLab.getCrimeCount();
        }
    }
}
