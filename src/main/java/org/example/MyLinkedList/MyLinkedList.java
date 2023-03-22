package org.example.MyLinkedList;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> _head;
    private Node<T> _tail;
    private int _length = 0;

    public void add(T data){
        Node<T> tempNode = new Node<>(data);
        if(this._head == null) {
            this._head = tempNode;
        } else{
            Node<T> lastNode = _head;
            while(lastNode.get_next() != null) { //find the last node
                lastNode = lastNode.get_next();
            }
            tempNode.set_prev(lastNode);
            lastNode.set_next(tempNode);
            _tail = tempNode;
        }
        _length++;
    }

    public void addAtPosition(int position, T data) {
        if(position > _length) //The bount is not the length - 1 but just the length. Of course the zero based index is taken into consideration, but adding the new member is increases the length by 1
            throw new IndexOutOfBoundsException(String.format("The position %s is out of bounds of the current list which max possible position is %s", position, _length));

        Node<T> lastNode = _head;
        if(position == 0) {
            _head = new Node<>(data);
            _head.set_next(lastNode);
        } else {
            Node<T> previuos = new Node<>((T) new Object());
            while(position - 1 >= 0) {
                previuos = lastNode;
                lastNode = lastNode.get_next();
                position--;
            }
            Node<T> newNode = new Node<T>(data);
            newNode.set_prev(previuos);
            previuos.set_next(newNode);
            if(lastNode != null) {
                previuos.get_next().set_next(lastNode); //Analoguos to node.next.next
                lastNode.set_prev(newNode);
                _tail = lastNode;
            } else {
                _tail = previuos.get_next();
            }
        }
        _length++;
    }

    public void remove(T dataKey) {
        Node<T> tempNode = _head;
        Node<T> previous = new Node<>((T) new Object());
        if(tempNode.get_data() != dataKey) {
           while(tempNode.get_data() != dataKey) {
               previous = tempNode;
               tempNode = tempNode.get_next();
           }
        }
        if(tempNode == _head) {
            _head = _head.get_next();
            _head.set_prev(null);
        } else {
            tempNode = tempNode.get_next();
            tempNode.set_prev(previous);
            previous.set_next(tempNode);
            _tail = tempNode;
        }
        _length--;
    }

    public void removeAtPosition(int position){
        if(position > _length - 1)
            throw new IndexOutOfBoundsException(String.format("The position %s is out of bounds of the current list which max possible position is %s", position, _length - 1));

        if(position == 0) {
            _head = _head.get_next();
            _head.set_prev(null);
        } else {
            Node<T> tempNode = _head;
            int count = 0;
            while(count != position - 1){
                tempNode = tempNode.get_next();
                count++;
            }
            Node<T> newNode = tempNode.get_next().get_next();
            if(newNode != null){
                newNode.set_prev(tempNode);
                _tail = newNode;
            } else {
                _tail = tempNode;
            }
            tempNode.set_next(newNode);
        }
        _length--;
    }

    public void clear() {
        _head = null;
        _tail = null;
        _length = 0;
    }

    public boolean isEmpty() {
        return _head == null && _length == 0;
    }

    public int getLength() {
        return _length;
    }

    public T getFirst() {
        return _head.get_data();
    }
    public T getLast() {
        return _tail.get_data();
    }



    private Node<T> getHeadNode() {
        return _head;
    }

    public boolean contains(T data) {
        Iterator<T> currentIterator = this.iterator();
        while(currentIterator.hasNext()) {
            if(data == currentIterator.next())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(_head == null)
            return "[ the list is empty ]";

        Node<T> tempNode = _head;
        StringBuilder sb = new StringBuilder("[ ");
        while(tempNode.get_next() != null) {
            sb.append(tempNode.get_data() + ", ");
            tempNode = tempNode.get_next();
        }
        sb.append(tempNode.get_data() + " ]");
        return sb.toString();
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator<T>(this);
    }

    class MyLinkedListIterator<T> implements Iterator<T> {

        private Node<T> _current;
        private Node<T> _tail;

        //private constructor makes impossible to instantiate this nested iterator class independently of its housing class,
        //so the only way to get this iterator instance is to call the method "iterator()" on the housing class
        private MyLinkedListIterator(MyLinkedList<T> currentList) {
            _current = currentList.getHeadNode();
            _tail = currentList._tail;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return _current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws //NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            T data = _current.get_data();
            _current = _current.get_next();
            return  data;
        }


        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            Node<T> beforeLastNode = new Node<T>((T) new Object());
            /* The criterion to stop the loop is to find the node that is previous to the last node
            *
            */
            while(_current.get_next().get_next() != null) {
                this.next(); //Here I have to do nothing with the returned value, the aim of calling "this.next()" is to replace "_current" with the next element
                beforeLastNode = _current;
            }
            beforeLastNode.set_next(null);
            _tail = beforeLastNode;
            _length--;
        }
    }
}
