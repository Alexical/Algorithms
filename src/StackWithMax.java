import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// A stack with return-the-maximum operation.
public class StackWithMax {

	// The stack for the items.
    private Stack<Integer> stack = new Stack<>();

    // The stack for the maximum items.
    private Stack<Integer> max = new Stack<>();

    // Returns true if the stack is empty.
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Returns the number of items in the stack.
    public int size() {
        return stack.size();
    }

    // Adds an item to the stack.
    public void push(int item) {
        stack.push(item);
        if (max.isEmpty() || item >= max.peek())
        	max.push(item);
    }

    // Removes and returns the last item on the stack.
    public int pop() {
        int item = stack.pop();
        if (max.peek() == item) max.pop();
        return item;
    }

    // Returns the last item on the stack.
    public int peek() {
        return stack.peek();
    }

    // Returns the maximum item in the stack.
    public int max() {
        return max.peek();
    }

    // Returns a string representation of the stack.
    public String toString() {
        return stack.toString();
    }

    // Tests the class.
    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) stack.pop();
            else stack.push(Integer.parseInt(item));
            StdOut.printf("%s(%d)\n", stack, stack.max());
        }
    }

}
