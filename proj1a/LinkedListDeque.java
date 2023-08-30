public class LinkedListDeque<T> {
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

    public void addFirst(T item){
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    public void addLast(T item){
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size ++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node cur = sentinel.next;
        while (cur.item != null){
            System.out.print(cur.item);
            System.out.print(" ");
            cur = cur.next;
        }
    }

    public T removeFirst(){
        Node returnNode = sentinel.next;
        sentinel.next = returnNode.next;
        sentinel.next.prev = returnNode.prev;
        size--;
        if (size < 0){
            size = 0;
        }
        return (T) returnNode.item;
    }

    public T removeLast(){
        Node returnNode = sentinel.prev;
        sentinel.prev = returnNode.prev;
        returnNode.prev.next = returnNode.next;
        size--;
        if (size < 0){
            size = 0;
        }
        return (T) returnNode.item;
    }

    public T get(int index){
        Node cur = sentinel.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return (T) cur.item;

    }

    private T getRecursiveHelp(Node cur, int index){
        if (index == 0){
            return (T) cur.item;
        }
        else{
            return (T) getRecursiveHelp(cur.next, index - 1);
        }
    }

    public T getRecursive(int index){
        if (index > size){
            return null;
        }
        else{
            return (T) getRecursiveHelp(sentinel.next, index);
        }
    }
}
