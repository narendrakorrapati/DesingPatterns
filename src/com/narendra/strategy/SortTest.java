package com.narendra.strategy;

public class SortTest {

    public static void main(String[] args) {
        SortItems primitives = new PrimitiveSortItems();
        SortItems references = new ReferenceSortItems();

        primitives.performSort();
        references.performSort();

        references.setSortingStrategy(new QuickSort());
        references.performSort();
    }
}

class SortItems {

    SortingStrategy sortingStrategy;

    void performSort() {
        sortingStrategy.sort();
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
}

class PrimitiveSortItems extends SortItems {
    PrimitiveSortItems() {
        sortingStrategy = new QuickSort();
    }
}

class ReferenceSortItems extends SortItems {
    ReferenceSortItems() {
        sortingStrategy = new MergeSort();
    }
}

interface SortingStrategy {
    void sort();
}

class MergeSort implements SortingStrategy {

    @Override
    public void sort() {
        System.out.println("Sorting using Merge Sort technique");
    }
}

class QuickSort implements SortingStrategy {

    @Override
    public void sort() {
        System.out.println("Sorting using Quick Sort technique");
    }
}
