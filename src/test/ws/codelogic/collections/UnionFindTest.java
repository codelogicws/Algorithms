package ws.codelogic.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {

    private UnionFind unionFind;

    @Before
    public void setUp() throws Exception {
        unionFind = new UnionFind();
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
}