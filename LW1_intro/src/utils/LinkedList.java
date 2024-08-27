package utils;

import models.Student;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
/*
Implement all interface methods based on a linked list.
Do not use the java class LinkedList <E>, try to write all the logic yourself.
Additional methods and variables can be developed as needed.
*/


public class LinkedList<T extends Comparable<T>>  implements List<T>  {

    private Node head , tail , current  =null;
    private int size ;

    public LinkedList() {}










    public class Node
    {
        private T Data ;
        private Node Next ;
        private Node previous;
        public Node ()
        {
        }
        public Node (T Data)
        {
            this.Data=Data;
        }


    }

    @Override
    public void add(T item) {
        Node x = new Node(item);
        if (head == null){
            head = tail =x;
        }
        else {
            tail.Next= x ;
            x.previous = tail;
            tail = x ;
           // tail.Next= null ;
        }
        size ++ ;
        // throw new UnsupportedOperationException("Method needs to be implemented");
    }

    @Override
    public T get(int index) {

        int L=0 ;
        Node c = new Node() ;
        for ( Node p = head ; p !=null ; p=p.Next)
        {
            if (L== index)
            {
                c=p;
                break ;
            }

            L ++ ;
        }
        return c.Data;





        //throw new UnsupportedOperationException("Method needs to be implemented");
    }

    public  boolean isEmpty() { return head==null;}

    @Override
    public boolean remove(T item) {

        boolean b = false;
        //Node p = head;
        if ( head == null)
        { return false ;}

        else if ( head.Data.equals(item)) {

            head= head.Next;
            //head.previous= null;
            size --;
            return  true;
        }
        else if(tail.Data.equals((item))){

            tail=tail.previous;
            tail.Next=null;
            size --;
            return true ;
        }

          Node p = head ;
        while (p.Next != null){
            if ( item.equals(p.Data))
            {
                //  Node L = p;
                p.previous.Next = p.Next;
                p.Next.previous=p.previous;
                p=p.Next;
                p.previous = null ;
                b= true ;
                size --;
            }
            else p=p.Next;
        }




        return b;


      //  throw new UnsupportedOperationException("Method needs to be implemented");
    }

    public boolean Contains (Object o ){

        boolean x = false;
        if (head != null){
            for ( Node p = head ; p !=null ; p=p.Next)
            {
                if (p.Data.equals(o) )
                {
                    x= true ;
                }
            }
        }

        return x;
    }
    public boolean retainAll(LinkedList<T> X){


        boolean zx = false ;
        for ( Node p = head ; p !=null ; p=p.Next)
        {
            for (Object S:X)
            {
                if (!p.Data.equals(S))
                {
                    remove(p.Data);
                    zx= true;
                }
            }
        }

        return zx ;
    }

    public void Sort () {

        for (Node s1 = head; s1 != null; s1 = s1.Next)
        {
            Node maxv = s1;
            for (Node s2 = s1; s2 != null; s2 = s2.Next)
                if (s2.Data.compareTo(maxv.Data) <0)
                    maxv = s2;
            T St = s1.Data;
            s1.Data = maxv.Data;
            maxv.Data = St;
        }
    }

    @Override
    public Iterator<T> iterator() { return new Iterator<T>() {

        private Node  iteratorposition = head ;



            @Override
            public boolean hasNext() {

                return iteratorposition != null ;

                //throw new UnsupportedOperationException("Method needs to be implemented");
            }

            @Override
            public T next() {
                T d = iteratorposition.Data ;
                iteratorposition = iteratorposition.Next;
                return d ;

                //throw new UnsupportedOperationException("Method needs to be implemented");
            }
        };
    }
}
