package utils;

public interface Queue <T>{

    public void enqueue (T item );
    public T deque () ;
    public T peak() ;
    public boolean isEmpty() ;
    public  boolean isFull();

}
