package org.example.MyLinkedList;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.zip.InflaterInputStream;

public class Main {
    public static void main(String[] args){
        MyLinkedList<Integer> intList = new MyLinkedList<>();
        for(int i = 0; i < 10; i++) {
            intList.add(i);
        }
        System.out.println(intList);
        System.out.println(intList.getLength());
        /*intList.addAtPosition(5, 10000);
        System.out.println(intList);
        System.out.println(intList.getLength());
        intList.remove(4);
        intList.remove(0);
        System.out.println(intList);
        System.out.println(intList.getLength());*/

        for(var one : intList) {

        }

        //intList.removeAtPosition(3);
        intList.iterator().remove();
        System.out.println(intList);
        System.out.println(intList.getLength());


        var r  = intList.contains(8);
        intList.removeAtPosition(8);
        System.out.println("---------------------------------------------------------");



        System.out.println("---------------------------------------------------------");
        System.out.println(intList);
        System.out.println("The length: " + intList.getLength());
        System.out.println("The last: " + intList.getLast());

        intList.addAtPosition(intList.getLength(), 10000);

        System.out.println(intList);
        System.out.println("The length: " + intList.getLength());
        System.out.println("The last: " + intList.getLast());



        var t = intList.getLast();
    }
}
