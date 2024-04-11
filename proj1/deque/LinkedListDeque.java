package deque;

public class LinkedListDeque<T> implements Deque<T>{
    //define a double linked list  TNode
    private class TNode<T>{
        //double linked list
        public T item;
        public TNode<T> next;
        public TNode<T> prev;

        public TNode(T item, TNode<T> next, TNode<T> prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
        public TNode(T item){
            this(item,null,null);
        }
    }

    //create dummy node for linked list
    private final TNode<T> head = new TNode<T>(null);
    private final TNode<T> tail = new TNode<T>(null);
    int count = 0;
    public LinkedListDeque(){
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void addFirst(T item) {
        TNode<T> newNode = new TNode<T>(item);
        newNode.next = head.next;
        newNode.prev = head;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        count++;
    }

    @Override
    public void addLast(T item) {
        TNode<T> newNode = new TNode<T>(item);
        newNode.next = tail;
        newNode.prev = tail.prev;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        count++;
    }

    @Override
    public boolean isEmpty(){
        return count == 0;
    }
    @Override
    public int size(){
        return count;
    }
    @Override
    public void printDeque(){
        TNode<T> targetNode = head;
        for (int i=0; i<count; i++){
            targetNode = targetNode.next;
            System.out.print(targetNode.item);
            System.out.print(" ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst(){
        if (count ==0) return null;
        TNode<T> deleteNode = head.next;
        deleteNode.next.prev = head;
        head.next = deleteNode.next;
        count--;
        return deleteNode.item;
    }
    @Override
    public T removeLast(){
        if (count ==0) return null;
        TNode<T> deleteNode = tail.prev;
        deleteNode.prev.next = tail;
        tail.prev = deleteNode.prev;
        count--;
        return deleteNode.item;
    }
    @Override
    public T get(int index){
        if (index >= count) return null; //Error: no such element
        TNode<T> targetNode = head;
        for (int i=0; i< index+1; i++){
            targetNode = targetNode.next;
        }
        return targetNode.item;
    }
}
