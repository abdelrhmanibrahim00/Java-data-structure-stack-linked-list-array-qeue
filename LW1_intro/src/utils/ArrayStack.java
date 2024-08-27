package utils;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack <T> extends Array<T> implements stack<T>  {

    private  int size ;
    private T [] stackArray;
    int initialsize = 4 ;

    private int top;
    public ArrayStack ()
    {
        this.size =0 ;
        this.top=-1;
        this.stackArray=(T [] ) new Object [initialsize];
    }
    @Override
    public T pop() {
        if (!isEmpty() )
        {
            T removed = peak();
            top -- ;
            size -- ;
            return  removed ;
        }
        else return null;
    }
    @Override
    public void push(T item) {
        stackArray[++top]=item;
        size++;
    }
    @Override
    public T peak() {
        if (!isEmpty() )
        {
            return  stackArray[top];
        }
        else return null ;
    }
    public void Resize () {
        int newsize = stackArray.length*2 ;
        T []  temporary = (T[]) new Object [newsize];
        for ( int i=0; i<stackArray.length; i++){
            temporary[i] = stackArray[i];

        }
        stackArray = temporary;
    }
//    public boolean  Remove (T item ) {
//        for (Object k : stackArray ) {
//            if (k.equals(item))
//            {
//
//            }
//
//        }
//    }



public  int length ( ){return stackArray.length;}
    @Override
    public boolean isEmpty() {
        if (stackArray[0] == null)
        {return true ;}
        else return false;
    }

    public  boolean isFull() {
        return  size==stackArray.length;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = top;

            @Override
            public boolean hasNext() {
                return currentIndex <= stackArray.length  && peak() != null && currentIndex!=-1;
            }

            @Override
            public T next() {

                return stackArray[currentIndex--];



            }
        };
    }
}
