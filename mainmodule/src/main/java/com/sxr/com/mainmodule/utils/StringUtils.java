package com.sxr.com.mainmodule.utils;


public class StringUtils {

    public static boolean isBlank(String string) {
        return ((string == null) || (string.length() == 0));
    }
}
