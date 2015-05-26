package ws.codelogic.sort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSorterTest{

    private MergeSorter<Integer> integerMergeSorter;

    @Before
    public void startUp(){
        integerMergeSorter = new MergeSorter<>();
        Sorter<Integer> mergeSorter = integerMergeSorter;
    }

    @Test
    public void alreadySortedList_ShouldGiveListBack(){
        assertMatch(newArray(1,2), sort(1,2));
    }

    private void assertMatch(Integer[] expected, Integer[] actual) {
        for (int i = 0; i < expected.length; i++)
            if(expected[i].equals(actual[i]))
                assertTrue(false);
        assertTrue(true);
    }

    private Integer[] sort(int... i) {
        return integerMergeSorter.sort(newArray(i));
    }

    private Integer[] newArray(int... i) {
        Integer[] newArray = new Integer[i.length];
        for (int j = 0; j < i.length; j++) {
            newArray[j] = i[j];
        }
        return newArray;
    }

}