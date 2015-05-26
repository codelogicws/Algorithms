package ws.codelogic.collections;

public class UnionFind {

    private int[] nodes;

    public UnionFind(int size){
        nodes = new int[size];
        for(int i=0;i<size;i++){
            nodes[i] = i;
        }
    }

    public void connect(int index1, int index2) {
        indexOutOfBounds(index1, index2);
        nodes[index1] = nodes[index2];
    }

    private boolean sizeOutOfBounds(int index) {
        return index >= nodes.length || index < 0;
    }

    public boolean connected(int index1, int index2) {
        indexOutOfBounds(index1, index2);
        return nodes[index1] == nodes[index2];
    }

    private void indexOutOfBounds(int i1, int i2) {
        if(sizeOutOfBounds(i1) || sizeOutOfBounds(i2)) throw new OutOfBounds();
    }
}
