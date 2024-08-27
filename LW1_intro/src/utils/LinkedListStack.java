package utils;

import org.jetbrains.annotations.NotNull;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<T> implements  stack <T> {
    private Node top  ;
    private int size ;

    public class Node
    {

        private T Data ;
        private Node Next ;


        public Node ()
        {
        }
        public Node (T Data)
        {
            this.Data=Data;
        }
    }
    @Override
    public T pop() {
        if (!isEmpty())
        {
            T temp = top.Data;
            top = top.Next ;
            size--;
            return  temp;
        }
        throw new EmptyStackException();
    }

    @Override
    public void push(T item) {
        Node x = new Node((item));
        if (top == null){
            top = x ;

        }
        else {
            x.Next =top;
            top=x;
        }
        size ++ ;
    }

    @Override
    public T peak() {
        if ( top == null ){
            throw  new EmptyStackException();
        }
        return top.Data;
    }

    @Override
    public boolean isEmpty() {
        if ( top == null)
        {return true ;}
        else return false;
    }

    @NotNull
    @Override

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node iteratorposition = top;


            @Override
            public boolean hasNext() {

                return iteratorposition != null;

                //throw new UnsupportedOperationException("Method needs to be implemented");
            }

            @Override
            public T next() {
                T d = iteratorposition.Data;
                iteratorposition = iteratorposition.Next;
                return d;

                //throw new UnsupportedOperationException("Method needs to be implemented");
            }

        };
    }
}