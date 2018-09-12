
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
    /*
        Removes vertex and all edges incident to it
     */
    public boolean removeVertex(int value){

        int indexToRemove = findVertexIndex(value);

        if(indexToRemove < 0){
            return false;
        }
        //remove all edges related to the deleted vertex
        for(int i=0; i<graph.length; i++){
            removeEdge(graph[i].getValue(),value);
        }
        //removes the vertex
        graph[indexToRemove] = null;

        return true;
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
    public boolean removeEdge(int vertexValue, int correspondingVertexValue){
        VertexNode vertexNode = findVertex(vertexValue);
        VertexNode correspondingVertexNode = findVertex(correspondingVertexValue);
        if(vertexNode != null){
            //If the edge to remove is the first EdgeNode
            EdgeNode edgeNode = vertexNode.getEdgeNode();
            if(edgeNode.getCorrespondingVertex() == correspondingVertexNode){
                vertexNode.setEdgeNode(edgeNode.getNextEdge());
                return true;
            }
            //if the edge to remove is not the first EdgeNode
            for(edgeNode = vertexNode.getEdgeNode(); edgeNode != null; edgeNode = edgeNode.getNextEdge()){
                EdgeNode ptr = edgeNode.getNextEdge();
                if(ptr != null){
                    if(ptr.getCorrespondingVertex() == correspondingVertexNode){
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
        int vertexIndex = findVertexIndex(value);
        if(vertexIndex != -1){
            return graph[vertexIndex];
        }
        return null;
    }

    /*
        finds the index of the specified VertexNode's value
     */
    private int findVertexIndex(int value){
        for(int i=0; i<graph.length; i++){
            if(graph[i] != null){
                if(graph[i].getValue() == value){
                    return i;
                }
            }
        }
        return -1;
    }

     /*
        returns the EdgeNode for the specified vertexValue argument
     */
    public EdgeNode getEdgeNode(int vertexValue){
        VertexNode vertexNode = findVertex(vertexValue);
        if(vertexNode != null) {
            return vertexNode.getEdgeNode();
        }
        return null;
    }

    /*
        returns the vertexNode associated with the specified vertex value in the argument
     */
    public VertexNode getVertexNode(int vertexValue){
        VertexNode vertexNode = findVertex(vertexValue);
        if(vertexNode != null){
            return vertexNode;
        }
        return null;
    }

    /*
        returns the length of the graph
     */
    public int getGraphLength(){
        return graph.length;
    }

    /*
        prints the graph in an adjacency list representation
     */
    public void printGraph(){
        for(VertexNode currentVertex: graph) {
            if (currentVertex != null) {
                System.out.print(currentVertex.getValue() + "\t->\t");
                for (EdgeNode edgeNode = currentVertex.getEdgeNode(); edgeNode != null; edgeNode = edgeNode.getNextEdge()) {
                    System.out.print(edgeNode.getCorrespondingVertex().getValue() + "\t");
                }
                System.out.println();
            }
        }
    }
}
