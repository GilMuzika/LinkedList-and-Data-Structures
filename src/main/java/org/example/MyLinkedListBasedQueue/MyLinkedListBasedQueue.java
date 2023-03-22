package org.example.MyLinkedListBasedQueue;

import org.example.MyLinkedList.MyLinkedList;

import java.util.Queue;

public class MyLinkedListBasedQueue<T> {

    private boolean _reversed = false;

    private MyLinkedList<T> _dataHold = new MyLinkedList<>();

    public void enqueue(T data) {
        if(!_reversed)
            _dataHold.add(data);
        else
            _dataHold.addAtPosition(0, data);
    }

    public T dequeue() {
        T value = null;
        if(!_reversed) {
            value = _dataHold.getFirst();
            _dataHold.removeAtPosition(0);
        } else{
            value = _dataHold.getLast();
            _dataHold.removeAtPosition(_dataHold.getLength() - 1);
        }
        return value;
    }

    public void reverse (boolean reverse){
        _reversed = reverse;
    }
    public boolean isReversed() {
        return _reversed;
    }

    public int size() {
        return _dataHold.getLength();
    }

    @Override
    public String toString() {
        return _dataHold.toString();
    }
}
