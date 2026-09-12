package core.basesyntax;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size;

    @Override
    public void add(T value) {
        if (size == elements.length) {
            double elementsSIze = elements.length * 1.5;
            Object[] newArray = new Object[(int) elementsSIze];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;

        }
        elements[size] = value;
        size++;

    }

    @Override
    public void add(T value, int index) {
        if (size == elements.length) {
            double elementsSIze = elements.length * 1.5;
            Object[] newArray = new Object[(int) elementsSIze];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;

        }
        if (index > size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Index of bound");
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        int inCommingSize = list.size();
        for (int i = 0; i < inCommingSize; i++) {
            this.add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Index of bound");
        }
        return (T) elements[index];
    }

    @Override
    public void set(T value, int index) {
        if (index >= size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Index of bound");
        }
        elements[index] = value;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Index of bound");
        }
        final T removeElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
        return removeElement;
    }

    @Override
    public T remove(T element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && null == element)
                    || (!(elements[i] == null) && elements[i].equals(element))) {
                return remove(i);

            }
        }
        throw new NoSuchElementException("Element not");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
