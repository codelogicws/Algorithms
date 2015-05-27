package ws.codelogic.sort;

public class QuickSorter <T extends Comparable<T>> implements Sorter<T>{

    @Override
    public T[] sort(T[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(T[] array, int start, int end) {
        if(end-start <= 0) return;
        int pivotLocation = partition(array, start, end);
        quickSort(array, start, pivotLocation-1);
        quickSort(array, pivotLocation+1, end);
        partition(array, start, end);
    }

    private int partition(T[] array, int start, int end) {
        T pivot = array[end];
        int leftPointer = start-1;
        int rightPointer = end;
        while(true){
            //noinspection StatementWithEmptyBody (using to move the leftPointer)
            while(array[++leftPointer].compareTo(pivot) < 0);
            //noinspection StatementWithEmptyBody (using to move the rightPointer)
            while(rightPointer > 0 && array[--rightPointer].compareTo(pivot) >= 0);
            if(leftPointer>=rightPointer)break;
            else swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, end);

        return leftPointer;
    }



    private void swap(T[] array, int start, int end) {
        T temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
