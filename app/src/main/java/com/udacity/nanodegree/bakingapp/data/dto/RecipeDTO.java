package com.udacity.nanodegree.bakingapp.data.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO  {

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
}
