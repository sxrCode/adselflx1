package com.sxr.com.mainmodule.model;


public class Crime {

    private String mDescribe;
    private String mCrimeId;

    public Crime(String describe, String id) {
        this.mCrimeId = id;
        this.mDescribe = describe;
    }

    public Crime() {
    }

    public String getDescribe() {
        return mDescribe;
    }

    public void setDescribe(String describe) {
        mDescribe = describe;
    }

    public String getCrimeId() {
        return mCrimeId;
    }

    public void setCrimeId(String crimeId) {
        mCrimeId = crimeId;
    }
}
