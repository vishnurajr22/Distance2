package com.app.distance2.directionhelpers;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

public class DistanceCalculator {
    DistanceDuration distanceDuration;

    public DistanceCalculator(DistanceDuration distanceDuration) {
        this.distanceDuration = distanceDuration;
    }

    public void distanceList(List<HashMap<String,String>> distance, List<HashMap<String,String>> duration){
        distanceDuration.distance(distance,duration);
        Log.d("TAG","distance:durs"+distance);

    }
}
