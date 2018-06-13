import java.util.*;


public class MyArrayList<T> implements List<T> {

    private T[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        this(15);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0)
            capacity = initialCapacity;
        size = 0;
        array = (T[]) new Object[capacity];

    }

    @Override
    public void sort(Comparator<? super T> c) {
        Arrays.sort(array, 0, size, c);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T element) {
        add(size, element);
        return true;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (size == capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
        System.arraycopy(array, index, array, index + 1, size++ - index);
        array[index] = element;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        int cSize = c.size();

        if (size + cSize >= capacity) {
            capacity += cSize;
            array = Arrays.copyOf(array, capacity);
        }

        System.arraycopy(array, index, array, index + cSize, size - index);
        size += cSize;

        int i = index;
        for (T t : c) {
            array[i] = t;
            i++;
        }
        return true;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return new MyItr();
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public boolean remove(Object o) {
        return false;
    }

    public void clear() {
        size = 0;
        array = (T[]) new Object[capacity];
    }

    public T get(int index) {
        if (index >= 0 && index < size)
            return array[index];
        return null;
    }

    public T set(int index, T element) {
        T respond = null;
        if (index >= 0 && index < size){
            respond = array[index];
            array[index] = element;
        }
        return respond;
    }

    public T remove(int index) {
        T response = null;
        if (index >= 0 && index < size){
            response = array[index];
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
        return response;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private class MyItr implements Iterator<T>{
        int nextElem;

        public MyItr() {
            nextElem = 0;
        }

        @Override
        public boolean hasNext() {
            return nextElem != size;
        }

        @Override
        public T next() {
            if(hasNext()){
                return array[nextElem++];
            }
            return null;
        }
    }
}
