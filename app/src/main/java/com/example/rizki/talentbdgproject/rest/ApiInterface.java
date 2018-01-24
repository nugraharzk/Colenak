package com.example.rizki.talentbdgproject.rest;

import com.example.rizki.talentbdgproject.models.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rizki on 11/18/2017.
 */

public interface ApiInterface {

    @GET("/maps/api/place/nearbysearch/json")
    Call<ResultResponse> getNearbyResults(@Query("types") String types, @Query("location") String location, @Query("radius") Integer radius, @Query("key") String key);
}
