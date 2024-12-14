package com.narendra.decorator;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 3, 2};

        ArrayComponent component = new MultiplyWith2Decorator(new BaseOperation());
        component.apply(array);
        System.out.println(Arrays.toString(array));
    }
}

interface ArrayComponent {
    void apply(int[] array);
}

class BaseOperation implements ArrayComponent{

    @Override
    public void apply(int[] array) {
        Arrays.sort(array);
    }
}

class ArrayDecorator implements ArrayComponent {

    ArrayComponent arrayComponent;

    ArrayDecorator(ArrayComponent arrayComponent) {
        this.arrayComponent = arrayComponent;
    }

    @Override
    public void apply(int[] array) {
        arrayComponent.apply(array);
    }
}

class MultiplyWith2Decorator extends ArrayDecorator {

    MultiplyWith2Decorator(ArrayComponent arrayComponent) {
        super(arrayComponent);
    }

    @Override
    public void apply(int[] array) {
        super.apply(array);

        for(int i = 0; i < array.length; i ++) {
            array[i] = array[i] * 2;
        }
    }
}
