package utils;

public class LinkedListQueue<T> implements  Queue<T> {
    private Node head, tail  =null;
    private int size ;

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

    public LinkedListQueue() {}

    @Override
    public void enqueue(T item) {
       Node x = new Node(item);

        if ( head == null)
        { head =tail =x ;}
        else {
            tail.Next= x ;
            x.previous = tail;
            tail = x ;

        }


    }

    @Override
    public T deque()  {
        if (!isEmpty())
        {
            Node p = head;
            head =head.Next;
            return p.Data;
        }
        return null;
    }

    @Override
    public T peak()  {

        if (!isEmpty())
        {
            return head.Data;
        }
       else return null;
    }

    @Override
    public boolean isEmpty() {
        if (tail == null)
            return true;
        else return false ;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
