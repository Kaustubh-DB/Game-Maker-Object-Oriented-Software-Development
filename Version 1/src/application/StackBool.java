package application;

public class StackBool {
	static final int MAX = 1000; 
    int top; 
    boolean a[] = new boolean[MAX]; // Maximum size of Stack 
  
    boolean isEmpty() 
    { 
        return (top < 0); 
    } 
    StackBool() 
    { 
        top = -1; 
    } 
  
    boolean push(boolean x) 
    { 
        if (top >= (MAX - 1)) { 
            System.out.println("Stack Overflow"); 
            return false; 
        } 
        else { 
            a[++top] = x;  
            return true; 
        } 
    } 
  
    boolean pop() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return false; 
        } 
        else { 
            boolean x = a[top--]; 
            return x; 
        } 
    } 
  
    boolean peek() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return false; 
        } 
        else { 
            boolean x = a[top]; 
            return x; 
        } 
    } 

}
