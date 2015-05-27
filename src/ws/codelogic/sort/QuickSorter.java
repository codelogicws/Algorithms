package ws.codelogic.sort;

public class QuickSorter <T extends Comparable<T>> implements Sorter<T>{

    @Override
    public T[] sort(T[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(T[] array, int start, int end) {
        if(start == end) return;
        partition(array, start, end);
        int mid = (start+end)/2;
        quickSort(array, start, mid);
        quickSort(array, mid+1, end);
    }

    private void partition(T[] array, int start, int end) {
        System.out.println("debug-QuickSorter: Start: " + start + " End: " + end);
    }
}
