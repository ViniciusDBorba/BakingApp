package com.udacity.nanodegree.bakingapp.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO implements Parcelable {

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
}
