public class LinkedListDeque<T> implements Deque<T>{
    public class Node<T>{
        private Node prev;
        private T item;
        private Node next;

        public Node(Node prevIn, T itemIn, Node nextIn){
            prev = prevIn;
            item = itemIn;
            next = nextIn;
        }
    }

    private int size;
    private Node sentinel;


    public LinkedListDeque(){
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

    }

    @Override
    public void addFirst(T item){
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    @Override
    public void addLast(T item){
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size ++;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        Node cur = sentinel.next;
        while (cur.item != null){
            System.out.print(cur.item);
            System.out.print(" ");
            cur = cur.next;
        }
    }

    @Override
    public T removeFirst(){
        Node returnNode = sentinel.next;
        sentinel.next = returnNode.next;
        sentinel.next.prev = returnNode.prev;
        size--;
        return (T) returnNode.item;
    }

    @Override
    public T removeLast(){
        Node returnNode = sentinel.prev;
        sentinel.prev = returnNode.prev;
        returnNode.prev.next = returnNode.next;
        size--;
        return (T) returnNode.item;
    }

    @Override
    public T get(int index){
        if (index > size){
            return null;
        }
        Node cur = sentinel.next;
        for (int i = 0; i <= index; i++) cur = cur.next;
        return (T) cur.item;

    }

    private T getRecursiveHelp(Node cur, int index){
        if (index == 0) return (T) cur.item;
        else{
            return (T) getRecursiveHelp(cur.next, index - 1);
        }
    }

    public T getRecursive(int index){
        if (index > size){
            return null;
        }
        else return (T) getRecursiveHelp(sentinel.next, index);
    }
}
