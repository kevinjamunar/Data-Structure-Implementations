
public class Graph {

    private VertexNode[] graph;

    public Graph(int vertexCount){
        this.graph = new VertexNode[vertexCount];
    }

    /*
        Adds a VertexNode to the graph with its value set to the argument 'value'
     */

    public VertexNode addVertex(int value){
        int index = findEmptyIndex();
        if(index >= 0) {
            graph[index] = new VertexNode(value);
            return graph[index];
        }
        return null;
    }

    public boolean removeVertex(int value){
        VertexNode vertexNode = findVertex(value);
        if(vertexNode != null) {
            vertexNode = null;
            return true;
        }
        return false;
    }
    /*
        Adds an EdgeNode to the front of the VertexNode's edge list.
        The VertexNode is retrieved using vertexValue
        The EdgeNode is created using the edgeValue
     */
    public EdgeNode addEdge(int vertexValue, int edgeValue){

        VertexNode vertexNode = findVertex(vertexValue);

        if(vertexNode != null){
            VertexNode correspondingVertex = findVertex(edgeValue);
            EdgeNode edgeNode;

            if(correspondingVertex != null) {
                edgeNode = new EdgeNode(correspondingVertex);
                edgeNode.setNextEdge(vertexNode.getEdgeNode());
                vertexNode.setEdgeNode(edgeNode);
                return edgeNode;
            }
        }
        return null;
    }
    /*
        removes an EdgeNode using the vertexValue of VertexNode and the EdgeNode's correspondingVertex field
     */
    public boolean removeEdge(int vertexValue, VertexNode correspondingVertex){
        VertexNode vertexNode = findVertex(vertexValue);
        if(vertexNode != null){
            //If the edge to remove is the first EdgeNode
            EdgeNode edgeNode = vertexNode.getEdgeNode();
            if(edgeNode.getCorrespondingVertex() == correspondingVertex){
                vertexNode.setEdgeNode(edgeNode.getNextEdge());
                return true;
            }
            //if the edge to remove is not the first EdgeNode
            for(edgeNode = vertexNode.getEdgeNode(); edgeNode != null; edgeNode = edgeNode.getNextEdge()){
                EdgeNode ptr = edgeNode.getNextEdge();
                if(ptr != null){
                    if(ptr.getCorrespondingVertex() == correspondingVertex){
                        edgeNode.setNextEdge(ptr.getNextEdge());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
        finds and empty index in the array
     */
    private int findEmptyIndex(){
        for(int i=0; i<graph.length; i++){
            if(graph[i] == null){
                return i;
            }
        }
        return -1;
    }
    /*
        finds a VertexNode in the graph whose value matches the argument 'value'
     */
    private VertexNode findVertex(int value){
        for(VertexNode currentVertex: graph){
            if(currentVertex != null){
                if(currentVertex.getValue() == value){
                    return currentVertex;
                }
            }
        }
        return null;
    }



}
