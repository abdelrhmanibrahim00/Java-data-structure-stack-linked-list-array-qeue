package utils;

public class ArrayQueue<T> implements Queue<T> {
    private  int front , rear ;
    private T[] qArray ;
int size =6;
   // public ArrayQueue (){this.front=this.rear=-1;}

    public ArrayQueue( ) {
        this.front=this.rear=-1;
        this.qArray=(T[]) new Object[size];

    }



    @Override
    public void enqueue(T item) {

        if (isEmpty()){
            front++ ;
        }
        qArray[++rear]=item;


    }

    @Override
    public T deque()  {
        if (!isEmpty())
        {
        T temp = qArray[front];
        if (front==rear)
            front=rear=-1;
        else front ++;
        return temp;
        }
        else return null;
    }

    @Override
    public T peak()  {
        if ((!isEmpty()))
            return qArray[front];
        else return null;


    }

    @Override
    public boolean isEmpty() {
        return front ==-1;
    }

    @Override
    public boolean isFull() {
        return rear == qArray.length-1;
    }
}
