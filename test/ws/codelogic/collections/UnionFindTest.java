package ws.codelogic.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {

    private static final int SIZE = 10;
    private UnionFind unionFind;

    @Before
    public void setUp() {
        unionFind = new UnionFind(SIZE);
    }

    @Test
    public void connect() {
        unionFind.connect(5, 2);
    }

    @Test
    public void isConnected() {
        unionFind.connect(5,2);
        assertTrue(unionFind.connected(5, 2));
    }

    @Test
    public void isNotConnected() {
        assertFalse(unionFind.connected(5,2));
    }

    @Test (expected = OutOfBounds.class)
    public void ifAttemptToConnectWhenSizeExceeded() {
        unionFind.connect(SIZE,0);
    }

    @Test (expected = OutOfBounds.class)
    public void ifAttemptToConnectWhenIndexIsLessThenZero() {
        unionFind.connect(4, -1);
    }

    @Test (expected = OutOfBounds.class)
    public void ifAttemptToCheckIsConnectedWithIndexThatExceedsTheLimit() {
        unionFind.connected(4, SIZE);
    }

    @Test (expected = OutOfBounds.class)
    public void ifAttemptToCheckIsConnectedWithIndexIsLessThenZero() {
        unionFind.connected(-1, 3);
    }

    @Test
    public void indirectUnion() {
        unionFind.connect(1, 2);
        unionFind.connect(2, 5);
        unionFind.connect(8, 5);
        assertTrue(unionFind.connected(1, 8));
    }

    @Test
    public void nonConnection() {
        unionFind.connect(1,4);
        unionFind.connect(9,4);
        unionFind.connect(3,8);
        assertFalse(unionFind.connected(1,8));
    }

}