package com.gk.ds.Theory.Collections;
//all types of collections in java are implemented in this package

import java.util.List;

public class Index {
    public static void main(String[] args){
        //ArrayList is a resizable array implementation of the List interface.
        //  It allows for dynamic resizing, meaning that it can grow or shrink in size as elements are added or removed. 
        // ArrayLists provide fast random access to elements, but inserting or deleting elements in the middle of the list can be slow, as it requires shifting elements to maintain the order.
        List<Integer> list = List.of(1,2,3,4,5);
        System.out.println(list);
        
    }

}
