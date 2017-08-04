package com.example.hazem.gameofthrones.Utils;

import android.support.annotation.StringRes;

import com.example.hazem.gameofthrones.Base.GOTapplications;

/**
 * Created by Hazem on 6/15/2017.
 */

public class StringUtil {
    public static String getStringRes(@StringRes int RestInt)
    {
        return GOTapplications.getmInstance().getString(RestInt);
    }
}
