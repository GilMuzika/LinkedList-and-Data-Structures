package org.example.MyLinkedList;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Node<T> {

    @Getter
    @NonNull
    private T _data;
    @Getter
    @Setter
    private Node<T> _next;
    @Getter
    @Setter
    private Node<T> _prev;
}
