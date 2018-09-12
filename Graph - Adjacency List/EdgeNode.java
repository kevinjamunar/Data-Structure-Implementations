class EdgeNode {

    private VertexNode  correspondingVertex; //points to the corresponding vertex in the VertexNode array
    private EdgeNode nextEdge; //gets the next EdgeNode in the list

    EdgeNode(VertexNode correspondingVertex){
        setCorrespondingVertex(correspondingVertex);
    }
    VertexNode getCorrespondingVertex(){
        return this.correspondingVertex;
    }
    EdgeNode getNextEdge(){
        return this.nextEdge;
    }
    private void setCorrespondingVertex(VertexNode correspondingVertex){
        this.correspondingVertex = correspondingVertex;
    }
    void setNextEdge(EdgeNode nextEdge){
        this.nextEdge = nextEdge;
    }
}
