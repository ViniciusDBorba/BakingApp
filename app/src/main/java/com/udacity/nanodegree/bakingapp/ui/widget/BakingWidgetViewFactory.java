/***
 Copyright (c) 2008-2012 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 From _The Busy Coder's Guide to Advanced Android Development_
 http://commonsware.com/AdvAndroid
 */


package com.udacity.nanodegree.bakingapp.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.MainActivity;

import java.util.List;

public class BakingWidgetViewFactory implements RemoteViewsService.RemoteViewsFactory {


    private final Context context;
    private RecipeDTO recipe;

    public BakingWidgetViewFactory(Context applicationContext) {
        this.context = applicationContext;
        this.recipe = new RecipeDTO();
        this.recipe = recipe.getObject(context);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public int getCount() {
        RecipeDTO selectedRecipe = recipe;
        return selectedRecipe != null ? selectedRecipe.getSteps().size() : 0;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        List<StepsDTO> steps = recipe.getSteps();

        RemoteViews row = new RemoteViews(context.getPackageName(), R.layout.widget_row);
        row.setTextViewText(R.id.widget_step_description, steps.get(position).getShortDescription());
        Intent i = new Intent(context, MainActivity.class);
        row.setOnClickFillInIntent(R.id.widget_item_container, i);

        return row;
    }

    @Override
    public RemoteViews getLoadingView() {
        return (null);
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void onDataSetChanged() {
        Log.i("vini", "ch");
    }
}