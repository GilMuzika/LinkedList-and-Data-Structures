package org.example.MyLinkedListBasedSortedSet;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyLinkedListBasedSortedSet<Integer> intSortedSet = new MyLinkedListBasedSortedSet<>();
        MyLinkedListBasedSortedSet<Person> personSortedSet = new MyLinkedListBasedSortedSet<>();
        Random rnd = new Random();
        for(int i = 0; i < 20; i++){
            intSortedSet.add(rnd.nextInt(100));
            personSortedSet.add(new Person());
        }


        System.out.println(intSortedSet);
    }
}
