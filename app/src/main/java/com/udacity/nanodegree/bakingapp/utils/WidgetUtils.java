package com.udacity.nanodegree.bakingapp.utils;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.ui.widget.BakingWidgetProvider;

public class WidgetUtils {

    public static void updateWidget(Activity activity) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(activity);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(activity, BakingWidgetProvider.class));
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_step_list);
        BakingWidgetProvider.updateWidgets(activity, appWidgetManager, appWidgetIds);
    }
}
