package org.example.MyLinkedListBasedSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyLinkedListBasedSet<Integer> intSet = new MyLinkedListBasedSet<>();
        Random rnd = new Random();
        for(int i = 0; i < 1000; i++) {
            intSet.add(rnd.nextInt(5));
        }

        Object[] arr = intSet.toArray();

        var lst = Arrays.stream(arr).toList();

        var t = intSet.containsAll(lst);

        System.out.println(intSet);

        var r  = intSet;


    }
}
