package com.example.rizki.talentbdgproject.classes;

import java.io.UnsupportedEncodingException;

import Modules.FarFinder;
import Modules.FarFinderListener;

/**
 * Created by Rizki on 11/15/2017.
 */

public class DistanceFix implements FarFinderListener {
    private String distance;

    public DistanceFix(String origin, String destination) {
        try{
            new FarFinder(this, origin, destination).execute();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    public String getDistance() {
        return distance;
    }

    @Override
    public void onFarFinderStart() {

    }

    @Override
    public void onFarFinderSuccess(String distance) {
        this.distance = distance;
    }
}
