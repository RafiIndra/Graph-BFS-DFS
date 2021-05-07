package graph;
public class Node {
    public int data;
    public Node next;
    public Node prev;
    
    //default constructor
    public Node(){}
    
    //constructor with integer parameter
    public Node(int a){
        this.data = a;
        this.next = null;
    }
}
