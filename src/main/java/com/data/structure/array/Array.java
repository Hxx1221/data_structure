package com.data.structure.array;

/**
 * 数组
 */
public class Array<E> {
    private E[] data;
    private int size;


    public Array(int capacity) {

        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造 默认数组容量capaciy=10
    public Array() {
        this(10);
    }

    //获取数组中的元素格式
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacit() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("容量已经不够了");
//        }
////        data[size]=e;
////        size++;
//        data[size++] = e;

        add(size, e);
    }


    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index<0||index>size");
        }
        if (size == data.length) {
            reSize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void reSize(final int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.
                append(String.format("Array: size=%d,capacity=%d\n", size, data.length));
        stringBuffer.append('[');
        for (int i = 0; i < size; i++) {

            stringBuffer.append(data[i]);
            if (i != size - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index<0||index>size");
        }
        return data[index];
    }


    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index<0||index>size");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置元素，返回删除元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index<0||index>size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//loitering objects != memory leak
        if (size==data.length/2){
            reSize(data.length/2);
        }

        return ret;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


}
