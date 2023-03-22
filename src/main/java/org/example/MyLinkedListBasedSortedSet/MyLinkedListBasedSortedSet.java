package org.example.MyLinkedListBasedSortedSet;

import org.example.MyLinkedListBasedSet.MyLinkedListBasedSet;

import java.util.*;
import java.util.stream.Collectors;

public class MyLinkedListBasedSortedSet<T> extends MyLinkedListBasedSet<T> {

    @Override
    public boolean add(T t) {
        boolean isAdded = super.add(t);
        try {
            List<T> sortedList = this.stream().sorted().collect(Collectors.toList());
            _dataHold.clear();
            for (T one : sortedList) {
                _dataHold.add(one);
            }
        } catch(Exception ex) {

        }
        return isAdded;
    }



}
