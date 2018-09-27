package Graph;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;

/*
    This graph is designed as a directed weighted graph.
    A HashMap is used as a better implementation of mapping
    a key to specified index to reduce lookup times.
    A LinkedList is used for representing a list edges.
    Of course, an array can always be used to hold the vertices,
    however, making a more generic graph later on becomes a problem.
 */

public class Graph {

    private HashMap<Integer, Vertex> graph;
    private int vertexCount;

    public Graph(int vertexCount){
        this.graph = new HashMap<>();
        this.vertexCount = vertexCount;

        for(int i=1; i<=vertexCount; i++){
            addVertex(i);
        }
    }
    public void addVertex(int vertexKey){
        Vertex vertex = new Vertex(vertexKey);
        if(graph.containsKey(vertexKey)){
            throw new IllegalArgumentException();
        }
        graph.put(vertexKey, vertex);
    }

    public boolean removeVertex(int vertexKey){
        if(!graph.containsKey(vertexKey)){
            throw new NoSuchElementException();
        }
        graph.remove(vertexKey);
        return true;
    }

    public void addEdge(int vertexKeyA, int vertexKeyB, int edgeWeight){
        if(!graph.containsKey(vertexKeyA) || !graph.containsKey(vertexKeyB)){
            throw new NoSuchElementException();
        }
        Edge edge = new Edge(edgeWeight, graph.get(vertexKeyB));
        graph.get(vertexKeyA).getEdgeList().addLast(edge);
    }

    public boolean removeEdge(int vertexKeyA, int vertexKeyB){
        if(!graph.containsKey(vertexKeyA) || !graph.containsKey(vertexKeyB)){
            throw new NoSuchElementException();
        }
        Vertex vertexA = graph.get(vertexKeyA);
        Vertex vertexB = graph.get(vertexKeyB);
        int vertexBValue = vertexB.getValue();
        int listSize = vertexA.getEdgeList().size();
        LinkedList<Edge> edgeList = vertexA.getEdgeList();

        for(int i=0; i<listSize; i++) {
            if(edgeList.get(i).getHeadVertex().getValue() == vertexBValue) {
                edgeList.remove(i);
            }
        }
        return true;
    }

    public int getVertexCount(){
        return this.vertexCount;
    }

    public Iterable<Integer> getVertices(){
        return this.graph.keySet();
    }

    public void printGraph(){
        Iterator<Integer> iterator = getVertices().iterator();
        while(iterator.hasNext()){
            Integer currentVertexKey = iterator.next();
            System.out.print(currentVertexKey + "\t->\t");
            Vertex currentVertex = graph.get(currentVertexKey);
            for(int i=0; i<currentVertex.getEdgeList().size(); i++){
                System.out.print(currentVertex.getEdgeList().get(i).getHeadVertex().getValue() + "\t");
            }
            System.out.println();
        }
    }
    public Vertex getValue(int vertexKey){
        return graph.get(vertexKey);
    }
}
