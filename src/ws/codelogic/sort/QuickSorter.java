package ws.codelogic.sort;

import java.util.Arrays;

public class QuickSorter <T extends Comparable<T>> implements Sorter<T>{

    @Override
    public T[] sort(T[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(T[] array, int start, int end) {
        if(end-start <= 0) return;
        T pivot = array[end];
        int pivotLocation = partition(array, start, end, pivot);
        quickSort(array, start, pivotLocation-1);
        quickSort(array, pivotLocation+1, end);
        partition(array, start, end, pivot);
    }

    private int partition(T[] array, int start, int end, T pivot) {
        int leftPointer = start-1;
        int rightPointer = end;
        while(true){
            while(array[++leftPointer].compareTo(pivot) < 0);
            while(rightPointer > 0 && array[--rightPointer].compareTo(pivot) >= 0);
            if(leftPointer>=rightPointer)break;
            else swap(array, leftPointer, rightPointer);
        }
        if(array[leftPointer].compareTo(array[end]) > 0)swap(array, leftPointer, end);
        return leftPointer;
    }



    private void swap(T[] array, int start, int end) {
        T temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
