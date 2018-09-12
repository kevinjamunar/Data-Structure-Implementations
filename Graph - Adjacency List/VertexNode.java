class VertexNode {

     private int value;
     private EdgeNode edgeNode;

     VertexNode(int value){
         this.value = value;
     }
     int getValue(){
         return this.value;
     }
     void setValue(int value){
         this.value = value;
     }
     EdgeNode getEdgeNode(){
         return this.edgeNode;
     }
     void setEdgeNode(EdgeNode edgeNode){
         this.edgeNode = edgeNode;
     }

}
