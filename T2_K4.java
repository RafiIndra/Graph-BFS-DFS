package graph;
public class T2_K4 {
    //main method
    public static void main(String[] args){
        Graph graph1 = new Graph(5);
        /*add edges between selected vertex
        when adding edges, keep in mind that last vertex's index is always (number of vertex - 1)*/
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 0);
        graph1.addEdge(3, 4);
        graph1.addEdge(1, 4);
        graph1.addEdge(4, 1);
        graph1.addEdge(4, 2);
        //print the graph in matrix adjacency representation
        graph1.print();
        //perform a DFS starting from vertex 0
        graph1.DFS(0);
    }
}
