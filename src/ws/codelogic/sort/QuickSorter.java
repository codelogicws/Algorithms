package ws.codelogic.sort;

public class QuickSorter <T extends Comparable<T>> implements Sorter<T>{

    private T[] array;

    @Override
    public T[] sort(T[] array) {
        if(array == null || array.length == 0) return null;
        this.array = array;
        quickSort(0, array.length-1);
        return array;
    }

    private void quickSort(int start, int end) {
        int i = start;
        int j = end;
        T pivot = array[start+(end-start)/2];

        while(i<=j){
            while(array[i].compareTo(pivot) < 0) i++;
            while(array[j].compareTo(pivot) > 0) j--;
            if(i<=j){
                swap(i,j);
                j--;
                i++;
            }
        }

        if(j > start) quickSort(start, j);
        if(i < end) quickSort(i, end);
    }

    private void swap(int start, int end) {
        T temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
