package com.data.structure.array;

/**
 * Created by boss on 2019/10/8 21:25
 */
public class Main {

    public static void main(String[] args) {
        final Array array = new Array<Integer>(20);
        for (int i= 0; i<10;i++){
            array.addLast(i);

        }
        System.out.println(array);
    }
}
