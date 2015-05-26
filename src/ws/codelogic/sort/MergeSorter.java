package ws.codelogic.sort;

import java.util.Arrays;

public class MergeSorter<T extends Comparable<T>> implements Sorter<T>{

    @Override
    public T[] sort(T[] array) {
        mergeSort(array, 0, array.length-1);
        return array;
    }

    private void mergeSort(T[] array, int start, int end) {
        if(start >= end) return;
        int mid = (start+end)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid, end);
    }

    private void merge(T[] array, int start, int mid, int end) {
        if(start == end) return;
        T[] left = Arrays.copyOfRange(array, start, mid + 1);
        T[] right = Arrays.copyOfRange(array, mid+1, end+1);
        int leftPointer = 0;
        int rightPointer = 0;
        int mainPointer = start;

        while(leftPointer < left.length || rightPointer < right.length){
            if(leftPointer >= left.length){
                array[mainPointer++] = right[rightPointer++];
            }else if(rightPointer >= right.length){
                array[mainPointer++] = left[leftPointer++];
            }else if(left[leftPointer].compareTo(right[rightPointer]) <= 0){
                array[mainPointer++] = left[leftPointer++];
            }else{
                array[mainPointer++] = right[rightPointer++];
            }
        }
    }

}
