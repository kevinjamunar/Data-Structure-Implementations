package Graph;

import java.util.LinkedList;

/*
    Class that represents a vertex in the graph.
    Specialized for Dijkstra's Shortest Path
    algorithm.
 */

public class Vertex{

    private int value;
    private int currentDistance;
    private boolean isShortestPath;
    private Vertex prevVertex;
    private LinkedList<Edge> edgeList;

    public Vertex(int value){
        this.value = value;
        this.edgeList = new LinkedList<>();
        this.currentDistance = Integer.MAX_VALUE;
        this.prevVertex = null;
    }

    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public LinkedList<Edge> getEdgeList(){
        return this.edgeList;
    }
    public int getCurrentDistance(){
        return this.currentDistance;
    }
    public void setCurrentDistance(int currentDistance){
        this.currentDistance = currentDistance;
    }
    public boolean getIsShortestPath(){
        return this.isShortestPath;
    }
    public void setIsShortestPath(boolean isShortestPath){
        this.isShortestPath = isShortestPath;
    }
    public Vertex getPrevVertex(){
        return this.prevVertex;
    }
    public void setPrevVertex(Vertex prevVertex){
        this.prevVertex = prevVertex;
    }
}
