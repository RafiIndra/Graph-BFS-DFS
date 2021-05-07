package graph;

public class Graph {

    public int[][] adj;

    public Graph(int a) {
        //create new graph with (a) amount of vertex
        this.adj = new int[a][a];
    }

    //add edges between selected vertex
    public void addEdge(int a, int b) {
        try{
        this.adj[a][b] = 1;
        }
        //catching IndexOutOfBoundsException
        catch(java.lang.ArrayIndexOutOfBoundsException ex){
            System.out.println("Can't create edge(" + a + ",  " + b + ")");
            System.out.println("vertex's index is only up to " + (this.adj.length-1));
            System.out.println("edge not created.");
            System.out.println("");
        }
    }

    //method to print the adjacency matrix represantation
    public void print() {
        //printing X axis
        for (int i = 0; i <= this.adj.length; i++) {
            if (i == 0) {
                System.out.print("    ");
            } else {
                System.out.print(i - 1 + " ");
            }
        }
        System.out.println("");
        for (int l = 0; l <= this.adj.length * 2 + 2; l++) {
            System.out.print("-");
        }
        System.out.println("");

        for (int j = 0; j < this.adj.length; j++) {
            for (int k = 0; k < this.adj.length + 1; k++) {

                //printing Y axis if j = 0
                if (k == 0) {
                    System.out.print(j + " | ");
                } else {
                    //if j != 0, print matrix.
                    System.out.print(this.adj[j][k - 1] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //perform breadth first search
    public void BFS(int a) {
        System.out.println("======Performing BFS======");
        //initialization, first part:
        char[] color = new char[this.adj.length];
        for (int i = 0; i < adj.length; i++) {
            color[i] = 'W';
        }
        int[] d = new int[this.adj.length];
        int[] pred = new int[this.adj.length];
        int u;

        //initialization, 2nd part:
        color[a] = 'G';
        d[a] = 0;
        Queue Q = new Queue();
        Queue Q2 = new Queue();
        Q.insert(a);
        Q2.insert(a);

        //main loop:
        while (Q.size != 0) {
            u = Q.dequeue();
            System.out.println("Evaluating adj of [" + u + "]");

            //visiting each adj of vertex u
            for (int i = 0; i < this.adj.length; i++) {

                //checking the color of vertex u adj
                if (this.adj[u][i] == 1 && color[i] == 'W') {
                    System.out.println("visiting [" + i +"]");
                    //set vertex color to grey
                    color[i] = 'G';
                    System.out.println("Color[" + i + "] = " + color[i]);
                    //set vertex distance to (d[u] + 1)
                    d[i] = d[u] + 1;
                    System.out.println("Distance[" + i + "] = " + d[i]);
                    //set vertex predecessor to (u)
                    pred[i] = u;
                    System.out.println("Pred[" + i + "] = " + pred[i]);
                    //put vertex into queue
                    Q.insert(i);
                    //print elements of queue
                    System.out.print("Queue = < ");
                    Q.print();
                    System.out.println(">");
                    System.out.println("");
                    Q2.insert(i);
                } else {
                    continue;
                }
            }
            //set color[u] to black after visiting all of its adj
            System.out.println("No more white adj of [" + u + "] found");
            color[u] = 'B';
            System.out.println("Color[" + u + "] = " + color[u]);
            System.out.println("===================");
        }
        System.out.println("Finished, BFS result : ");
        while (Q2.size != 0){
            System.out.print(Q2.dequeue() + " ");
        }
        System.out.println("");
    }

    //perform depth first search
    public void DFS(int a) {
        System.out.println("======Performing DFS======");
        //initialization, part 1: 
        char color[] = new char[this.adj.length];
        int time = 0;
        //set all vertex color to white
        for (int i = 0; i < this.adj.length; i++) {
            color[i] = 'W';
        }
        int[] f = new int[this.adj.length];
        int[] d = new int[this.adj.length];
        int[] pred = new int[this.adj.length];
        //initialization, part 2:
        int u;
        Stack s = new Stack(this.adj.length);
        Queue Q = new Queue();
        s.push(a);
        Q.insert(a);
        color[a] = 'G';

        //main loop: 
        while (s.size != 0) {
            //evaluate adj of vertex on top of stack
            u = s.top();
            System.out.println("Evaluating adj of :[" + u + "]");
            for (int i = 0; i < this.adj.length; i++) {
                //visiting white adj of vertex u
                if (this.adj[u][i] == 1 && color[i] == 'W') {
                    System.out.println("Visiting [" + i + "]");
                    //set adj color to grey
                    color[i] = 'G';
                    System.out.println("Color[" + i + "] : " + color[i]);
                    //set adj distance to (distance[u]+1)
                    d[i] = ++time;
                    System.out.println("d[" + i + "] : " + d[i]);
                    //push adj into stack
                    s.push(i);
                    Q.insert(i);
                    System.out.println("==========================");
                    break;
                } else {
                    //if no white adj found
                    if (i == this.adj.length - 1) {
                        //remove vertex from stack
                        s.pop();
                        //set color[u] to black;
                        color[u] = 'B';
                        System.out.println("color[" + u + "] : " + color[u]);
                        //set vertex finish time
                        f[u] = ++time;
                        System.out.println("f[" + u + "] : " + f[u]);
                        System.out.println("No white adj found, back tracking to [" + s.top() + "]");
                        System.out.println("==========================");
                    }
                }
            }
        }
        System.out.println("Finished, DFS result :");
        while (Q.size != 0){
            System.out.print(Q.dequeue() + " ");
        }
        System.out.println("");
    }
}
