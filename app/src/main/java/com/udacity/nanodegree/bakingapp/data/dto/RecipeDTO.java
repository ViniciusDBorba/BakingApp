package com.udacity.nanodegree.bakingapp.data.dto;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;

import com.udacity.nanodegree.bakingapp.utils.WidgetUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipeDTO implements Parcelable, Serializable {

    public static final String SHARED_PREF = "SAVE";

    private static final int INGREDIENTS_FLAG = 0;
    private static final int STEPS_FLAG = 1;
    private int id;
    private String name;
    private List<IngredientsDTO> ingredients = new ArrayList<>();
    private List<StepsDTO> steps = new ArrayList<>();
    private int servings;
    private String image;

    public RecipeDTO() {

    }

    public RecipeDTO(Parcel in) {
        id = in.readInt();
        name = in.readString();
        in.readTypedList(ingredients, IngredientsDTO.CREATOR);
        in.readTypedList(steps, StepsDTO.CREATOR);
        servings = in.readInt();
        image = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public List<StepsDTO> getSteps() {
        return steps;
    }

    public void setSteps(List<StepsDTO> steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeTypedList(ingredients);
        dest.writeTypedList(steps);
        dest.writeInt(servings);
        dest.writeString(image);
    }

    public static final Creator<RecipeDTO> CREATOR = new Creator<RecipeDTO>() {
        @Override
        public RecipeDTO createFromParcel(Parcel in) {
            return new RecipeDTO(in);
        }

        @Override
        public RecipeDTO[] newArray(int size) {
            return new RecipeDTO[size];
        }
    };

    public boolean saveObject(RecipeDTO obj, Context context) {
        final File folder = new File(context.getCacheDir(), "recipe");
        if (!folder.exists()) {
            folder.mkdir();
        }
        final File suspend_f = new File(folder.getAbsolutePath(), "recipe");
        if (!suspend_f.exists()) {
            try {
                suspend_f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean keep = true;

        try {
            fos = new FileOutputStream(suspend_f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            keep = false;
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
                if (keep == false) suspend_f.delete();
            } catch (Exception e) { /* do nothing */ }
        }

        if (keep) {
            WidgetUtils.updateWidget((Activity) context);
        }

        return keep;
    }

    public RecipeDTO getObject(Context c) {
        final File suspend_f = new File(c.getCacheDir() + "/recipe", "recipe");

        RecipeDTO simpleClass = null;
        FileInputStream fis = null;
        ObjectInputStream is = null;

        try {
            fis = new FileInputStream(suspend_f);
            is = new ObjectInputStream(fis);
            simpleClass = (RecipeDTO) is.readObject();
        } catch (Exception e) {
            String val = e.getMessage();
        } finally {
            try {
                if (fis != null) fis.close();
                if (is != null) is.close();
            } catch (Exception e) {
            }
        }

        return simpleClass;
    }
}
