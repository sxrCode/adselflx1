package com.sxr.com.mainmodule.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */

public class CrimeLab {

    private List<Crime> mCrimes = new ArrayList<>();
    private static CrimeLab sCrimeLab;
    private static int CRIME_COUNT = 35;

    public CrimeLab() {
        for (int i = 1; i <= CRIME_COUNT; i++) {
            Crime crime = new Crime();
            crime.setCrimeId("00" + i);
            crime.setDescribe("crime " + i);
            mCrimes.add(crime);
        }
    }

    public Crime getCrime(int index) {
        return mCrimes.get(index % CRIME_COUNT);
    }

    public int getCrimeCount() {
        return CRIME_COUNT;
    }

    public static CrimeLab getInstance() {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab();
        }
        return sCrimeLab;
    }
}
