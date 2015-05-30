package ws.codelogic.sort;

import java.util.Arrays;

public class MergeSorter<T extends Comparable<T>> implements Sorter<T>{

    private T[] array;
    private T[] temp;

    @Override
    public T[] sort(T[] array) {
        //need to throw error instead;
        if(array == null || array.length == 0)return null;
        this.array = array;
        temp = Arrays.copyOf(array, array.length);
        mergeSort(0, array.length - 1);
        return array;
    }

    private void mergeSort(int start, int end) {
        if(start >= end) return;
        int mid = (start+end)/2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        merge(start, mid, end);
    }

    private void merge(int start, int mid, int end) {
        if(start == end) return;
        copyArrayToTemp(start, end);
        int i = start;
        int j = mid+1;
        int k = start;

        while(i<=mid && j<=end){
            assert i <= end;
            assert j <= end;
            if(temp[i].compareTo(temp[j]) <= 0){
                array[k] = temp[i];
                i++;
            }else{
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            array[k] = temp[i];
            i++;
            k++;
        }

    }

    private void copyArrayToTemp(int start, int end) {
        for(int i=start;i<=end;i++){
            temp[i] = array[i];
        }
    }

}
