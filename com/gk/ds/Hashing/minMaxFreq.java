package com.gk.ds.Hashing;

import java.util.HashMap;
import java.util.Map;

public class minMaxFreq {
    public static void main(String[] args){

    }
    public static int[] minMax(int[] nums){
        int[] res = new int[2];
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums){            
            freq.put(i,freq.getOrDefault(i, 0)+1);
        }
        //sort based on frequencies
        //no need to sort just get the max and min in one iteration ,but it is fun to learn how to do so

        int max = 0; 
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> a : freq.entrySet()){
            if(max <a.getValue()){
                max=a.getValue();
                res[0]=a.getKey();
            }
            if(min>a.getValue()){
                min = a.getValue();
                res[1]=a.getKey();
            }
        }

        return res;
    }
}
