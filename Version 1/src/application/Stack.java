package application;

public class Stack {
	static final int MAX = 1000; 
    int top; 
    double a[] = new double[MAX]; // Maximum size of Stack 
  
    boolean isEmpty() 
    { 
        return (top < 0); 
    } 
    Stack() 
    { 
        top = -1; 
    } 
  
    boolean push(double x) 
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
  
    double pop() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else { 
            double x = a[top--]; 
            System.out.println("Item popped: "+x);
            return x; 
        } 
    } 
  
    double peek() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else { 
            double x = a[top]; 
            return x; 
        } 
    } 

}
