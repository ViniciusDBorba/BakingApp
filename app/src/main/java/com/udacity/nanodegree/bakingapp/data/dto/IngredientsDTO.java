package com.udacity.nanodegree.bakingapp.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class IngredientsDTO implements Parcelable {

    private float quantity;
    private String measure;
    private String ingredient;

    public IngredientsDTO() {
    }

    public IngredientsDTO(Parcel in) {
        quantity = in.readFloat();
        measure = in.readString();
        ingredient = in.readString();
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(quantity);
        dest.writeString(measure);
        dest.writeString(ingredient);
    }

    public static final Creator<IngredientsDTO> CREATOR = new Creator<IngredientsDTO>() {
        @Override
        public IngredientsDTO createFromParcel(Parcel in) {
            return new IngredientsDTO(in);
        }

        @Override
        public IngredientsDTO[] newArray(int size) {
            return new IngredientsDTO[size];
        }
    };
}
