package ws.codelogic.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSorterTest{

    private MergeSorter<Integer> sorter;

    @Before
    public void startUp(){
        sorter = new MergeSorter<>();
    }

    @Test
    public void alreadySortedList_ShouldGiveListBack(){
        assertMatch(newArray(1,2), sort(1,2));
    }

    @Test
    public void sortTheSimplest2Numbers() {
        assertMatch(newArray(1,2), sort(2,1));
    }

    @Test
    public void largerSortTest() {
        assertMatch(newArray(1,5,7,34,98,965), sort(34, 5, 98, 1, 965, 7));
    }

    private void assertMatch(Integer[] expected, Integer[] actual) {
        for (int i = 0; i < expected.length; i++)
            if(!expected[i].equals(actual[i]))
                assertTrue(false);
        assertTrue(true);
    }

    private Integer[] sort(int... i) {
        return sorter.sort(newArray(i));
    }

    private Integer[] newArray(int... i) {
        Integer[] newArray = new Integer[i.length];
        for (int j = 0; j < i.length; j++) {
            newArray[j] = i[j];
        }
        return newArray;
    }

}