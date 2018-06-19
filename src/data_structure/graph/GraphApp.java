package data_structure.graph;

/**
 * Author : Ray
 * Created At : 2018-06-15 下午2:39
 * Email : ryu18356@gmail.com
 * Description :
 */
public class GraphApp {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1); //AB
        graph.addEdge(1,2); //BC
        graph.addEdge(2,3); //CD
        graph.addEdge(0,3); //AD
        graph.addEdge(3,4); //DE
        graph.dfs();
        System.out.println();
        graph.bfs();
        System.out.println();
        graph.mst();
    }

}
