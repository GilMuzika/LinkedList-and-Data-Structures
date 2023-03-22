package org.example.MyLinkedListBasedQueue;

public class Main {
    public static void main(String[] args) {
        MyLinkedListBasedQueue<Integer> intQueue = new MyLinkedListBasedQueue<>();
        for(int i = 0; i < 20; i++) {
            intQueue.enqueue(i);
        }
        System.out.println(intQueue);
        System.out.println(intQueue.size());
        intQueue.reverse(true);
        int deq1 = intQueue.dequeue();
        int deq2 = intQueue.dequeue();
        System.out.printf("The first dequeue is %s, the second dequeue is %s \n", deq1, deq2);
        System.out.println(intQueue);
        System.out.println(intQueue.size());
        int enq1 = 1235;
        System.out.println("The enqueue is " + enq1);
        intQueue.enqueue(enq1);
        System.out.println(intQueue);
        System.out.println(intQueue.size());



    }
}
