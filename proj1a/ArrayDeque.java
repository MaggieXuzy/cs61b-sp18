public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    private void addResizing(){
        T[] a = (T[]) new Object[items.length * 2];
        int cur = nextFirst + 1;

        for (int cnt = 0; cnt < items.length; cnt++){
            if (cur == items.length){
                cur = 0;
            }
            a[cnt] = items[cur];
            cur++;
        }

        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item){
        if (size == items.length){
            addResizing();
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
        if (nextFirst == -1){
            nextFirst = items.length - 1;
        }
    }

    public void addLast(T item){
        if (size == items.length) addResizing();
        items[nextLast] = item;
        nextLast++;
        size++;
        if (nextLast == items.length){
            nextLast = 0;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int cur = nextFirst + 1;

        while (cur != nextLast){
            if (cur == items.length){
                cur = 0;
            }
            System.out.print(items[cur]);
            System.out.print(" ");
            cur++;
        }
    }

    private void removeResizing(){
        T[] a = (T[]) new Object[items.length / 2];
        int cur = nextFirst + 1;

        for (int cnt = 0; cnt < size; cnt++){
            if (cur == items.length){
                cur = 0;
            }
            a[cnt] = items[cur];
            cur++;
        }

        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public T removeFirst(){
        if (size < 0) {
            size = 0;
            return null;
        }
        else{
            if (nextFirst == items.length - 1) nextFirst = 0;
            else nextFirst++;
            T res = items[nextFirst];
            items[nextFirst] = null;
            size--;
            if ((double)size / items.length < 0.25 && items.length >= 16){
                removeResizing();
            }
            return res;
        }
    }

    public T removeLast() {
        if (size < 0) {
            size = 0;
            return null;
        }
        else{
            if (nextLast == 0) {
                nextLast = items.length - 1;
            }
            else {
                nextLast--;
            }
            T res = items[nextLast];
            items[nextLast] = null;
            size--;
            if ((double)size / items.length < 0.25 && items.length >= 16) {
                removeResizing();
            }
            return res;
        }

    }

    public T get(int index) {
        int cur = nextFirst + 1;
        if (cur == items.length) {
            cur = 0;
        }
        int cnt = 0;
        while (cnt != index) {
            cnt++;
            cur++;
            if (cur == items.length) {
                cur = 0;
            }
        }
        return items[cur];

    }



}
