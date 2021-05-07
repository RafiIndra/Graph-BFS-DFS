package graph;

public class Queue {

    public Node head;
    public Node tail;
    public int size = 0;

    //insert a new node with data = a into queue
    public void insert(int a) {
        Node b = new Node(a);
        //consider if queue is empty
        if (this.head == null) {
            this.head = b;
            this.tail = b;
            this.tail.next = null;
            size++;
        } else {
            //if queue is not empty
            b.next = this.head;
            this.head = b;
            size++;
        }
    }

    //print all node of queue
    public void print() {
        Node print = this.head;
        for (int i = 0; i < this.size; i++) {
            System.out.print(print.data + " ");
            print = print.next;
        }
    }

    //remove the last node of the queue
    public int dequeue() {
        Node beforeLast = this.head;
        Node temp = this.head;

        //set temp to the last node of queue
        for (int j = 0; j < this.size - 1; j++) {
            temp = temp.next;
        }
        
        //set node beforeLast to the 2nd last node of the queue
        for (int i = 0; i < this.size - 2; i++) {
            //System.out.println("beforelast : " + beforeLast.data);
            beforeLast = beforeLast.next;
        }
        
        //set node before last as the tail of the queue
        this.tail = beforeLast;
        size--;
        return temp.data;
    }
}
