package deque;

import java.util.ArrayList;

public class ArrayDeque<T> implements Deque<T>{
    private int maxSize;
    private T[] ArrayList;
    private int front;
    private int rear;
    public ArrayDeque(){
        maxSize = 1000;
        ArrayList = (T[]) new Object[maxSize];
        front = 0;
        rear = 0;
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize();
        }
        front = modMaxSize(front-1);
        ArrayList[front] = item;
    }
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize();
        }
        ArrayList[rear] = item;
        rear = modMaxSize(rear+1);
    }
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int size() {
        return modMaxSize(rear-front);
    }

    @Override
    public void printDeque() {
        for (int i=0; i<this.size(); i++){
            int target = modMaxSize(front + i);
            System.out.print(ArrayList[target]);
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T first = ArrayList[front];
        front = modMaxSize(front+1);
        return first;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        rear = modMaxSize(rear-1);
        return ArrayList[rear];
    }

    @Override
    public T get(int index) {
        if(index >= this.size()) return null;
        int target = front + index;
        return ArrayList[target];
    }

    //move front rear with mod
    private int modMaxSize(int num){
        num = num % maxSize;
        if(num < 0){
            num += maxSize;
        }
        return num;
    }

    private boolean isFull(){  //not implemented
        return front == modMaxSize(rear+1);
    }
    private void resize(){
        T[] newArrayList = (T[]) new Object[maxSize*2];
        for (int i=0; i<maxSize-1; i++){
            newArrayList[i] = ArrayList[front+i];
        }
        front = 0;
        rear = maxSize-1;
        maxSize = maxSize*2;
        ArrayList = newArrayList;
    }
}
