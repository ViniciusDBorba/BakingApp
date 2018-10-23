package com.udacity.nanodegree.bakingapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class InternetUtils {

    public static boolean hasInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = cm.getActiveNetworkInfo();
        return i != null && i.isConnected();
    }
}
