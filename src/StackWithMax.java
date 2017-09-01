import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackWithMax {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> max = new Stack<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void push(int item) {
        stack.push(item);
        if (max.isEmpty() || item >= max.peek())
        	max.push(item);
    }

    public int pop() {
        int item = stack.pop();
        if (max.peek() == item) max.pop();
        return item;
    }

    public int peek() {
        return stack.peek();
    }

    public int max() {
        return max.peek();
    }

    public String toString() {
        return stack.toString();
    }

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
