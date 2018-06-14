package data_structure.graph;

/**
 * Author : Ray
 * Created At : 2018-06-14 下午10:16
 * Email : ryu18356@gmail.com
 * Description : 简单图，邻接矩阵实现，无向无权
 */
public class Graph {

    private final int MAX_VERTEX = 20;

    private Vertex mVertexList[];

    private int[][] adjMatrix;

    private int nVerts;

    public Graph() {
        mVertexList = new Vertex[MAX_VERTEX];
        adjMatrix = new int[][]{};
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        mVertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int index) {
        System.out.print(mVertexList[index].label);
    }

}
