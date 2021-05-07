package graph;
public class Stack {
    public static int[] stack;
    public static int size = 0;
    
    //contructor
    public Stack(int a){
        stack = new int[a];
    }
    
    //push an integer into stack
    public void push(int a){
        stack[size] = a;
        size++;
    }
    
    //remove and return element on top of stack
    public int pop(){
        int temp = stack[size-1];
        stack[size-1] = 0;
        size--;
        return temp;
    }
    
    //print elements of stack
    public void print(){
        for (int i = 0; i < size; i++){
            System.out.println(stack[i]);
        }
    }
    
    //access and return element on top of stack
    public int top(){
        if(size > 0){
        return stack[size-1];
        }else{
            return stack[0];
        }
    }
}
