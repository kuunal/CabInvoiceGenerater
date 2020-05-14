package com.cabinvoice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    static HashMap<String, ArrayList<Ride>> map = new HashMap<>();


    public static void addUser(String userId, Ride[] rides) {
        ArrayList<Ride> rideArrayList = map.get(userId);
        if(rideArrayList==null){
            map.put(userId,new ArrayList<Ride>(Arrays.asList(rides)));
        }else{
            map.get(userId).addAll(Arrays.asList(rides));
        }

    }

    public static Ride[] getRides(String userId) {
        return map.get(userId).toArray(new Ride[0]);
    }
}
