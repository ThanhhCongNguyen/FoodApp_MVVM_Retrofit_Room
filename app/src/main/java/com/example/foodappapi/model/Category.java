package com.example.foodappapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Category implements Serializable {

    @SerializedName("idCategory")
    private String mIdCategory;
    @SerializedName("strCategory")
    private String mStrCategory;
    @SerializedName("strCategoryDescription")
    private String mStrCategoryDescription;
    @SerializedName("strCategoryThumb")
    private String mStrCategoryThumb;

    public String getIdCategory() {
        return mIdCategory;
    }

    public void setIdCategory(String idCategory) {
        mIdCategory = idCategory;
    }

    public String getStrCategory() {
        return mStrCategory;
    }

    public void setStrCategory(String strCategory) {
        mStrCategory = strCategory;
    }

    public String getStrCategoryDescription() {
        return mStrCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        mStrCategoryDescription = strCategoryDescription;
    }

    public String getStrCategoryThumb() {
        return mStrCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        mStrCategoryThumb = strCategoryThumb;
    }
}
