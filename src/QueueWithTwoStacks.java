import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// A queue implemented with two stacks.
public class QueueWithTwoStacks<Item> {

    // The two stacks.
    private Stack<Item> stack1 = new Stack<>();
    private Stack<Item> stack2 = new Stack<>();

    // Returns true if the queue is empty.
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Returns the number of items in the queue.
    public int size() {
        return stack1.size() + stack2.size();
    }

    // Returns the first item in the queue.
    public Item peek() {
        reverse();
        return stack2.peek();
    }

    // Adds an item to the queue.
    public void enqueue(Item item) {
        stack1.push(item);
    }

    // Removes and returns the first item in the queue.
    public Item dequeue() {
        reverse();
        return stack2.pop();
    }

    // If stack2 is empty, moves all items from stack1 to stack2.
    private void reverse() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    // Tests the class.
    public static void main(String[] args) {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-"))
                StdOut.println(queue.dequeue() + " ");
            else queue.enqueue(item);
        }
    }

}
