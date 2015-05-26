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
        if(nodes[index1] < nodes[index2]){
            nodes[index2] = findRoot(index1);
        }else{
            nodes[index1] = findRoot(index2);
        }
    }

    public boolean connected(int index1, int index2) {
        indexOutOfBounds(index1, index2);
        return findRoot(nodes[index1]) == findRoot(nodes[index2]);
    }

    private int findRoot(int index) {
        int temp = index;
        while(nodes[temp] != temp)
            temp = nodes[temp];
        return temp;
    }

    private boolean sizeOutOfBounds(int index) {
        return index >= nodes.length || index < 0;
    }

    private void indexOutOfBounds(int i1, int i2) {
        if(sizeOutOfBounds(i1) || sizeOutOfBounds(i2)) throw new OutOfBounds();
    }
}
