package Graph;

/*
    Class that represents an Edge in the graph.
    Holds a weight and reference to the
    vertex at the head of the Edge.
 */


public class Edge {

    private Vertex headVertex; //vertex the edge's head is directed to
    private int edgeWeight; //weight of the edge

    public Edge(int edgeWeight, Vertex headVertex){
        this.edgeWeight = edgeWeight;
        this.headVertex = headVertex;
    }

    public Vertex getHeadVertex(){
        return this.headVertex;
    }
    public void setHeadVertex(Vertex headVertex){
        this.headVertex = headVertex;
    }
    public int getEdgeWeight(){
        return this.edgeWeight;
    }
    public void setEdgeWeight(int edgeWeight){
        this.edgeWeight = edgeWeight;
    }

}
