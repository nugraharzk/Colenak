package com.example.rizki.talentbdgproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rizki on 11/18/2017.
 */

public class ResultResponse {

    @SerializedName("results")
    private List<Results> resultsList;

    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }
}
