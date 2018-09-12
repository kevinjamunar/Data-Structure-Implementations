public class GraphMain {

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);


        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(5, 4);

        /*Prints out Graph as an adjacency list*/
        graph.printGraph();
    }
}
