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
        if(end-start <= 0) return;
        int pivotLocation = partition(start, end);
        quickSort(start, pivotLocation-1);
        quickSort(pivotLocation+1, end);
        partition(start, end);
    }

    private int partition(int start, int end) {
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
