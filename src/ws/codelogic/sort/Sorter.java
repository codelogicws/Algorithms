package ws.codelogic.sort;

public interface Sorter <T extends Comparable<T>>{

    T[] sort(T[] array);

}
